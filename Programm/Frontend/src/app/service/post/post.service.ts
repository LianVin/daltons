import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { post } from 'src/app/models/post';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private url = environment.backendUrl + "/post/"

  constructor(private httpClient: HttpClient) { }

  getPosts() {
    return this.httpClient.get<post[]>(this.url);
  }

  getPostbyId(id: number) {
    return this.httpClient.get<post>(this.url + id);
  }

  deletePost(id: number) {
    return this.httpClient.delete(this.url + id);
  }

  updatePost(post: post) {
    return this.httpClient.put<post>(this.url + post.postId, post);
  }

  createPost(post: post) {
    return this.httpClient.post(this.url, post);
  }
}
