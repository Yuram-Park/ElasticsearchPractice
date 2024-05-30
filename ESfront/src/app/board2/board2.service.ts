import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export interface Post {
    id: number;
    name: string;
    message: string;
}

@Injectable({
    providedIn: 'root'
  })
export class Board2Service {
    url = 'http://localhost:8080/jasoSearch/ㅇㅇㄷㅇ'

    constructor(private http: HttpClient) {}

    getPost() {
        return this.http.get<Post>(this.url);
    }
}