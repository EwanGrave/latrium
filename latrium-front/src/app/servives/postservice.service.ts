import { HttpClient } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PostService {
  private http = inject(HttpClient);
  posts = signal<Object>([]);

  constructor() {}

  getAllPosts() {
    return this.http.get('http://localhost:8080/api/posts');
  }
}
