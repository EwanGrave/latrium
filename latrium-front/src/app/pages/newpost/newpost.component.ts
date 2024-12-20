import { Component, inject, OnInit } from '@angular/core';
import {
  BoardControllerService,
  BoardDTO,
  PostControllerService,
  PostDTO,
} from '../../../../api';
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { getFormattedCurrentDate } from '../../utils/StringUtils';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-newpost',
  imports: [
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    MatSelectModule,
  ],
  templateUrl: './newpost.component.html',
  styleUrl: './newpost.component.css',
})
export class NewpostComponent implements OnInit {
  boardService = inject(BoardControllerService);
  postService = inject(PostControllerService);
  loginService = inject(LoginService);
  router = inject(Router);
  boards!: BoardDTO[];

  postForm = new FormGroup({
    title: new FormControl<string>('', [Validators.required]),
    content: new FormControl<string>('', [Validators.required]),
    boardName: new FormControl<string>('', [Validators.required]),
  });

  ngOnInit(): void {
    this.boardService.getAllBoards().subscribe((value) => {
      this.boards = value;
    });
  }

  createPost(): void {
    const user = this.loginService.getLoggedUser();
    if (this.postForm.valid && user) {
      const newPost: PostDTO = {
        score: '0',
        title: this.postForm.value.title ?? '',
        content: this.postForm.value.content ?? '',
        comments: [],
        createdAt: getFormattedCurrentDate(),
        user: user,
        board: this.boards.find(
          (b) => b.name === this.postForm.value.boardName
        ),
      };
      this.postService.createPost(newPost).subscribe();
      this.router.navigateByUrl('/');
    }
  }
}
