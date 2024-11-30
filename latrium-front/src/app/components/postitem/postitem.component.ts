import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-postitem',
  imports: [MatCardModule, MatButtonModule, RouterLink],
  templateUrl: './postitem.component.html',
  styleUrl: './postitem.component.css',
})
export class PostitemComponent {}
