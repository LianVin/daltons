import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Post } from 'src/app/models/post';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private url = environment.backendUrl + "/post/"

  constructor(private httpClient: HttpClient) { }

  getPosts() {
    return this.httpClient.get<Post[]>(this.url);
  }

  getPostbyId(id: number) {
    return this.httpClient.get<Post>(this.url + id);
  }

  deletePost(id: number) {
    return this.httpClient.delete(this.url + id);
  }

  updatePost(post: Post) {
    return this.httpClient.put<Post>(this.url + post.postId, post);
  }

  createPost(post: Post) {
    return this.httpClient.post(this.url, post);
  }
}
