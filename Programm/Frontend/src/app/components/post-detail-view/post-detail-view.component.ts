import { identifierModuleUrl } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { commentCreate } from 'src/app/models/commentCreate';
import { post } from 'src/app/models/post';
import { CommentService } from 'src/app/service/comment/comment.service';
import { PostService } from 'src/app/service/post/post.service';

@Component({
  selector: 'app-post-detail-view',
  templateUrl: './post-detail-view.component.html',
  styleUrls: ['./post-detail-view.component.scss'],
})
export class PostDetailViewComponent implements OnInit {
  post: post;
  value = 'Super Post :)';

  constructor(
    private route: ActivatedRoute,
    private postService: PostService,
    private commentService: CommentService
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((m) => {
      this.postService
        .getPostbyId(Number.parseInt(m.get('id')))
        .subscribe((res: post) => {
          this.post = res;
        });
    });
  }

  createComment() {
    let commentToCreate: commentCreate;
    commentToCreate.postId = this.post.postId;
    commentToCreate.text = this.value;
    this.commentService.createComment(commentToCreate);
    this.value = '';
  }
}
