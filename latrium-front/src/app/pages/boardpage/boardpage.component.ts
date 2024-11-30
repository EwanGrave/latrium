import { Component, inject, OnInit } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { ActivatedRoute } from '@angular/router';
import { PostitemComponent } from '../../components/postitem/postitem.component';
import { MatDividerModule } from '@angular/material/divider';

@Component({
  selector: 'app-boardpage',
  imports: [MatCardModule, PostitemComponent, MatDividerModule],
  templateUrl: './boardpage.component.html',
  styleUrl: './boardpage.component.css',
})
export class BoardpageComponent implements OnInit {
  route = inject(ActivatedRoute);
  name = '';

  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.name = params['name'];
    });
  }
}
