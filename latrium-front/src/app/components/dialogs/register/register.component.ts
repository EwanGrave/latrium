import { ChangeDetectionStrategy, Component, inject } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { UserControllerService, UserWithPasswordDTO } from '../../../../../api';
import { shaEncrypt } from '../../../utils/StringUtils';

@Component({
  selector: 'app-register',
  imports: [
    MatDialogModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
  ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class RegisterComponent {
  userService = inject(UserControllerService);

  registerForm = new FormGroup({
    username: new FormControl<string>('', [Validators.required]),
    password: new FormControl<string>('', [
      Validators.required,
      Validators.minLength(3),
    ]),
    confirmPassword: new FormControl<string>('', [
      Validators.required,
      Validators.minLength(3),
    ]),
  });

  register(): void {
    if (
      this.registerForm.valid &&
      this.registerForm.value.password ===
        this.registerForm.value.confirmPassword
    ) {
      const user: UserWithPasswordDTO = {
        username: this.registerForm.value.username ?? '',
        password: shaEncrypt(this.registerForm.value.password ?? '', 'sha256'),
        role: 'USER',
      };
      this.userService.createUser(user).subscribe((data) => console.log(data));
      window.location.reload();
    }
  }
}
