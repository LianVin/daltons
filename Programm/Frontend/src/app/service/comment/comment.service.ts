import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Comment } from 'src/app/models/comment';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private url = environment.backendUrl + "/comment/"

  constructor(private httpClient: HttpClient) { }

  getComments() {
    return this.httpClient.get<Comment[]>(this.url);
  }

  getCommentbyId(id: number) {
    return this.httpClient.get<Comment>(this.url + id);
  }

  deleteComment(id: number) {
    return this.httpClient.delete(this.url + id);
  }

  updateComment(comment: Comment) {
    return this.httpClient.put<Comment>(this.url + comment.commentId, comment);
  }

  createComment(comment: Comment) {
    return this.httpClient.post(this.url, comment);
  }
}
