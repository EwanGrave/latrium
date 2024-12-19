import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {
  CommentDTO,
  PostControllerService,
  PostDTO,
  UserDTO,
} from '../../../../api';
import {
  formatDateFromString,
  getFormattedCurrentDate,
} from '../../utils/StringUtils';
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { LoginService } from '../../services/login.service';

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
  loginService = inject(LoginService);
  idPost!: number;
  post!: PostDTO | undefined;
  user: UserDTO | null = this.loginService.getLoggedUser();

  commentForm = new FormGroup({
    comment: new FormControl<string>('', [Validators.required]),
  });

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.idPost = params['idPost'];
    });

    this.postService.getPostById(this.idPost).subscribe((value) => {
      this.post = value;
    });
  }

  addComment(): void {
    if (this.commentForm.valid && this.user) {
      const comment: CommentDTO = {
        content: this.commentForm.value.comment ?? '',
        createdAt: getFormattedCurrentDate(),
        post: this.post,
        user: this.user,
      };
      this.postService.createComment(comment).subscribe();
    }
  }
}
