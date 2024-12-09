import { Component, Input } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { RouterLink } from '@angular/router';
import { PostDTO } from '../../../../api';

@Component({
  selector: 'app-postitem',
  imports: [MatCardModule, MatButtonModule, RouterLink],
  templateUrl: './postitem.component.html',
  styleUrl: './postitem.component.css',
})
export class PostitemComponent {
  @Input({ required: true }) post!: PostDTO;
  @Input({ required: true }) display!: 'User' | 'Board';
}
