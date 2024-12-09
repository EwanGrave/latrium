import { Routes } from '@angular/router';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { BoardpageComponent } from './pages/boardpage/boardpage.component';
import { PostpageComponent } from './pages/postpage/postpage.component';

export const routes: Routes = [
  {
    path: '',
    component: HomepageComponent,
  },
  {
    path: 'a/:name',
    component: BoardpageComponent,
  },
  {
    path: 'a/:name/post/:idPost',
    component: PostpageComponent,
  },
];
