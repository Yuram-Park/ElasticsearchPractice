import { Component } from '@angular/core';

class BoardVO {
  id: number = 0;
  title: string = '';
  content: string = '';
}

let BoardList: BoardVO[] = [];

@Component({
  selector: 'app-board',
  standalone: true,
  imports: [],
  templateUrl: './board.component.html',
  styleUrl: './board.component.css'
})

export class BoardComponent {
  text: string[] = [];

  fnAdd(newInput:string){
    this.text.push(newInput);
  }

  boardList = BoardList;
  newList = new BoardVO();

  addBoard() {
    let newId = this.boardList[this.boardList.length-1].id + 1;

    let newItem = {
      id: newId,
      title: this.newList.title,
      content: this.newList.content
    }
    this.boardList.push(newItem);
  }
}
