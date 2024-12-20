import { Component, inject, OnInit } from '@angular/core';
import { BoardControllerService, BoardDTO } from '../../../../api';
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
  boards!: BoardDTO[];

  postForm = new FormGroup({
    title: new FormControl<string>('', [Validators.required]),
    content: new FormControl<string>('', [Validators.required]),
    boardName: new FormControl<string>('', [Validators.required]),
  });

  ngOnInit(): void {}
}
