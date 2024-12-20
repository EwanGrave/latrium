import { inject } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';

export const AdminGuard = () => {
  const loginService = inject(LoginService);
  const router = inject(Router);

  if (!loginService.isLoggedIn() || !loginService.isAdmin()) {
    router.navigateByUrl('/');
    return false;
  }
  return true;
};
