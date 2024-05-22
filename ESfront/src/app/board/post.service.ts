import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  private url = 'http://localhost:8080/api/post'

  constructor(private http: HttpClient) { }

  getPosts(){
    return this.http.get(this.url);
  }
}
