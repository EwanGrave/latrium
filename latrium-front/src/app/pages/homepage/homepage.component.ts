import { Component } from '@angular/core';
import { PostitemComponent } from '../../components/homepage/postitem/postitem.component';
import { MatDividerModule } from '@angular/material/divider';

@Component({
  selector: 'app-homepage',
  imports: [PostitemComponent, MatDividerModule],
  templateUrl: './homepage.component.html',
  styleUrl: './homepage.component.css',
})
export class HomepageComponent {}
