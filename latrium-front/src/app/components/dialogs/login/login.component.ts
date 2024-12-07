import { Component, inject } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  ReactiveFormsModule,
} from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { LoginService } from '../../../services/login.service';
import { shaEncrypt } from '../../../utils/StringUtils';

@Component({
  selector: 'app-login',
  imports: [
    MatDialogModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  loginService = inject(LoginService);
  isError: boolean = false;

  loginForm = new FormGroup({
    username: new FormControl<string>('', [Validators.required]),
    password: new FormControl<string>('', [
      Validators.required,
      Validators.minLength(3),
    ]),
  });

  login(): void {
    if (this.loginForm.valid) {
      this.loginService
        .login({
          username: this.loginForm.value.username ?? '',
          password: shaEncrypt(this.loginForm.value.password ?? '', 'sha256'),
        })
        .then((res) => (this.isError = !res));
    }
  }
}
