import { Component, inject, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  ReactiveFormsModule,
} from '@angular/forms';
import {
  BoardControllerService,
  BoardDTO,
  ThemeControllerService,
  ThemeDTO,
} from '../../../../api';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { Router } from '@angular/router';
import { LoginService } from '../../services/login.service';
import { getFormattedCurrentDate } from '../../utils/StringUtils';

@Component({
  selector: 'app-newboard',
  imports: [
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    MatSelectModule,
  ],
  templateUrl: './newboard.component.html',
  styleUrl: './newboard.component.css',
})
export class NewboardComponent implements OnInit {
  themeService = inject(ThemeControllerService);
  loginService = inject(LoginService);
  boardService = inject(BoardControllerService);
  router = inject(Router);
  themes!: ThemeDTO[];

  boardForm = new FormGroup({
    name: new FormControl<string>('', [Validators.required]),
    description: new FormControl<string>('', [Validators.required]),
    themes: new FormControl<ThemeDTO[]>([]),
  });

  ngOnInit(): void {
    this.themeService.getAllThemes().subscribe((value) => {
      this.themes = value;
    });
  }

  createBoard(): void {
    const user = this.loginService.getLoggedUser();
    if (this.boardForm.valid && user) {
      const newBoard: BoardDTO = {
        name: this.boardForm.value.name ?? '',
        description: this.boardForm.value.description ?? '',
        createdAt: getFormattedCurrentDate(),
        themes: this.boardForm.value.themes ?? [],
      };

      this.boardService.createBoard(newBoard).subscribe();
      this.router.navigateByUrl('/');
    }
  }
}
