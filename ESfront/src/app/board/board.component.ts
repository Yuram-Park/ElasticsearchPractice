import { Component } from '@angular/core';
import { PostService } from './post.service';

@Component({
  selector: 'app-board',
  standalone: true,
  imports: [],
  templateUrl: './board.component.html',
  styleUrl: './board.component.css'
})
export class BoardComponent {
  post: any;

  constructor(private service:PostService) {};

  fnHello(){
    this.service.getPosts().subscribe(resp => {this.post = resp;})
  }
}
