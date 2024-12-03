import { Component, inject } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { RegisterComponent } from '../dialogs/register/register.component';
import { LoginComponent } from '../dialogs/login/login.component';

@Component({
  selector: 'app-header',
  imports: [MatButtonModule, MatDialogModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css',
})
export class HeaderComponent {
  readonly dialog = inject(MatDialog);

  openRegisterDialog() {
    this.dialog.open(RegisterComponent);
  }

  openLoginDialog() {
    this.dialog.open(LoginComponent);
  }
}
