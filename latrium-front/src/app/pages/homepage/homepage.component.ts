import { Component, inject, OnInit } from '@angular/core';
import { MatDividerModule } from '@angular/material/divider';
import { PostitemComponent } from '../../components/postitem/postitem.component';
import { PostService } from '../../servives/postservice.service';

@Component({
  selector: 'app-homepage',
  imports: [PostitemComponent, MatDividerModule],
  templateUrl: './homepage.component.html',
  styleUrl: './homepage.component.css',
})
export class HomepageComponent implements OnInit {
  private postService = inject(PostService);
  posts = this.postService.posts;

  ngOnInit() {
    this.postService.getAllPosts().subscribe();
  }
}
