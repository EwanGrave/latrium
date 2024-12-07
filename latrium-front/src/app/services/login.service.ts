import { inject, Injectable, signal, Signal } from '@angular/core';
import { CredentialsDTO, UserControllerService, UserDTO } from '../../../api';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private userLogin = inject(UserControllerService);
  private readonly USER_DATA_KEY = 'USER_Data';

  constructor() {}

  private setStorageItem(key: string, value: string): void {
    localStorage.setItem(key, value);
    sessionStorage.setItem(key, value);
  }

  private removeStorageItem(key: string): void {
    localStorage.removeItem(key);
    sessionStorage.removeItem(key);
  }

  isLoggedIn(): boolean {
    return !!sessionStorage.getItem(this.USER_DATA_KEY);
  }

  logout(): void {
    this.removeStorageItem(this.USER_DATA_KEY);
    sessionStorage.clear();
    window.location.reload();
  }

  login(credentials: CredentialsDTO): Promise<boolean> {
    return new Promise<boolean>((resolve) => {
      this.userLogin.getUserFromCredentials(credentials).subscribe({
        next: (value) => {
          if (value.success) {
            this.setStorageItem(this.USER_DATA_KEY, JSON.stringify(value.user));
            window.location.reload();
          }
          resolve(value.success ?? true);
        },
      });
    });
  }
}
