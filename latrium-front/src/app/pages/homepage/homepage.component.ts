import { Component } from '@angular/core';
import { MatDividerModule } from '@angular/material/divider';
import { PostitemComponent } from '../../components/postitem/postitem.component';

@Component({
  selector: 'app-homepage',
  imports: [PostitemComponent, MatDividerModule],
  templateUrl: './homepage.component.html',
  styleUrl: './homepage.component.css',
})
export class HomepageComponent {}
