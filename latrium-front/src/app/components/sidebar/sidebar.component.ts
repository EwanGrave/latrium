import { Component, inject, OnInit } from '@angular/core';
import { ThemeControllerService, ThemeDTO } from '../../../../api';

@Component({
  selector: 'app-sidebar',
  imports: [],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css',
})
export class SidebarComponent implements OnInit {
  themeService = inject(ThemeControllerService);
  themes!: ThemeDTO[];

  ngOnInit(): void {
    this.themeService.getAllThemes().subscribe({
      next: (themes) => {
        this.themes = themes;
      },
    });
  }
}
