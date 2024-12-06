import { Component, inject, OnInit } from '@angular/core';
import { MatDividerModule } from '@angular/material/divider';
import { PostitemComponent } from '../../components/postitem/postitem.component';
import { PostControllerService, PostDTO } from '../../../../api';

@Component({
  selector: 'app-homepage',
  imports: [PostitemComponent, MatDividerModule],
  templateUrl: './homepage.component.html',
  styleUrl: './homepage.component.css',
})
export class HomepageComponent implements OnInit {
  postService = inject(PostControllerService);
  posts!: PostDTO[];

  ngOnInit(): void {
    this.postService.getAllPosts().subscribe((value) => {
      this.posts = value;
    });
  }
}
