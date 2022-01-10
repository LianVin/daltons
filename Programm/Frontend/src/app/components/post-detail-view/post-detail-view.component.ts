import { identifierModuleUrl } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Post } from 'src/app/models/post';
import { Comment } from 'src/app/models/comment';
import { CommentService } from 'src/app/service/comment/comment.service';
import { PostService } from 'src/app/service/post/post.service';

@Component({
  selector: 'app-post-detail-view',
  templateUrl: './post-detail-view.component.html',
  styleUrls: ['./post-detail-view.component.scss'],
})
export class PostDetailViewComponent implements OnInit {
  post: Post;
  value = 'Super Post :)';
  isAdmin: Boolean;
  isLoggedIn: Boolean;
  constructor(
    private route: ActivatedRoute,
    private postService: PostService,
    private commentService: CommentService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.isAdmin = localStorage.getItem('admin')?.includes('t');
    this.isLoggedIn = localStorage.getItem('loggedin')?.includes('t');
    this.route.paramMap.subscribe((m) => {
      this.postService
        .getPostbyId(Number.parseInt(m.get('id')))
        .subscribe((res: Post) => {
          this.post = res;
        });
    });
  }

  createComment() {
    let newComment = new Comment();
    newComment.postId = this.post;
    newComment.text = this.value;
    console.log(newComment)
    this.commentService.createComment(newComment).subscribe();
  }
}
