import { Component, inject } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { RegisterComponent } from '../dialogs/register/register.component';
import { LoginComponent } from '../dialogs/login/login.component';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-header',
  imports: [MatButtonModule, MatDialogModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css',
})
export class HeaderComponent {
  readonly dialog = inject(MatDialog);
  loginService = inject(LoginService);
  isLogged: boolean = this.loginService.isLoggedIn();

  openRegisterDialog() {
    this.dialog.open(RegisterComponent);
  }

  openLoginDialog() {
    this.dialog.open(LoginComponent);
  }

  logout(): void {
    this.loginService.logout();
  }
}
