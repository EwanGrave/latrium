import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-postitem',
  imports: [MatCardModule, MatButtonModule],
  templateUrl: './postitem.component.html',
  styleUrl: './postitem.component.css',
})
export class PostitemComponent {}
