import { Component, Input, OnInit } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { RouterLink } from '@angular/router';
import { PostDTO } from '../../../../api';
import { formatDateFromString } from '../../utils/StringUtils';

@Component({
  selector: 'app-postitem',
  imports: [MatCardModule, MatButtonModule, RouterLink],
  templateUrl: './postitem.component.html',
  styleUrl: './postitem.component.css',
})
export class PostitemComponent implements OnInit {
  @Input({ required: true }) post!: PostDTO;
  @Input({ required: true }) display!: 'User' | 'Board';

  formattedDate!: string;

  ngOnInit(): void {
    this.formattedDate = formatDateFromString(this.post.createdAt ?? '');
  }
}
