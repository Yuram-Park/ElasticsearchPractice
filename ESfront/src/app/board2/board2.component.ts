import { Component } from '@angular/core';
import { Board2Service, Post } from './board2.service';

@Component({
  selector: 'app-board2',
  standalone: true,
  imports: [],
  templateUrl: './board2.component.html',
  styleUrl: './board2.component.css'
})
export class Board2Component {
  post: any; // type 설정 필요 post: Post | undefined 
  error: any;

  constructor(private board2Service: Board2Service) {}

  showPost() {
    this.board2Service.getPost()
      .subscribe({
        next: data => this.post = data,
        error: error => this.error = error
      });
  }
}
