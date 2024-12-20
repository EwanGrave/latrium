import { inject } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';

export const LoginGuard = () => {
  const loginService = inject(LoginService);
  const router = inject(Router);

  if (!loginService.isLoggedIn()) {
    router.navigateByUrl('/');
    return false;
  }
  return true;
};
