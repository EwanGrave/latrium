import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PostControllerService, PostDTO } from '../../../../api';
import { formatDateFromString } from '../../utils/StringUtils';
import { ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';

@Component({
  selector: 'app-postpage',
  imports: [
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
  ],
  templateUrl: './postpage.component.html',
  styleUrl: './postpage.component.css',
})
export class PostpageComponent implements OnInit {
  route = inject(ActivatedRoute);
  postService = inject(PostControllerService);
  idPost!: number;
  post!: PostDTO | undefined;

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.idPost = params['idPost'];
    });

    this.postService.getPostById(this.idPost).subscribe((value) => {
      this.post = value;
      this.post.createdAt = formatDateFromString(this.post.createdAt ?? '');
      this.post.comments?.forEach((comment) => {
        comment.createdAt = formatDateFromString(comment.createdAt ?? '');
      });
    });
  }
}
