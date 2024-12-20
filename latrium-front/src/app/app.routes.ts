import { Routes } from '@angular/router';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { BoardpageComponent } from './pages/boardpage/boardpage.component';
import { PostpageComponent } from './pages/postpage/postpage.component';
import { NewpostComponent } from './pages/newpost/newpost.component';
import { LoginGuard } from './guards/Login.guard';

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
  {
    path: 'post/new',
    component: NewpostComponent,
    canActivate: [LoginGuard],
  },
];
