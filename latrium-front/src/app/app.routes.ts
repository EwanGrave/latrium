import { Routes } from '@angular/router';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { BoardpageComponent } from './pages/boardpage/boardpage.component';

export const routes: Routes = [
  {
    path: '',
    component: HomepageComponent,
  },
  {
    path: 'board/:name',
    component: BoardpageComponent,
  },
];
