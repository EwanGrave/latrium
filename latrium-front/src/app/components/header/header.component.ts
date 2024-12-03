import { Component, inject } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { RegisterComponent } from '../dialogs/register/register.component';

@Component({
  selector: 'app-header',
  imports: [MatButtonModule, MatDialogModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css',
})
export class HeaderComponent {
  readonly registerDialog = inject(MatDialog);

  openRegisterDialog() {
    this.registerDialog.open(RegisterComponent);
  }
}
