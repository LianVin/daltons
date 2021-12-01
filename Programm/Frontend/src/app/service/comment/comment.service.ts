import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { comment } from 'src/app/models/comment';
import { commentCreate } from 'src/app/models/commentCreate';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private url = environment.backendUrl + "/comment/"

  constructor(private httpClient: HttpClient) { }

  getComments() {
    return this.httpClient.get<comment[]>(this.url);
  }

  getCommentbyId(id: number) {
    return this.httpClient.get<comment>(this.url + id);
  }

  deleteComment(id: number) {
    return this.httpClient.delete(this.url + id);
  }

  updateComment(comment: comment) {
    return this.httpClient.put<comment>(this.url + comment.commentId, comment);
  }

  createComment(comment: commentCreate) {
    return this.httpClient.post(this.url, comment);
  }
}
