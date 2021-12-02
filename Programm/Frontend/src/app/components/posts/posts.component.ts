import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/models/post';
import { PostService } from 'src/app/service/post/post.service';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.scss']
})
export class PostsComponent implements OnInit {
  posts: Post[]=[];

  constructor(private postService: PostService) {
   }

  ngOnInit(): void {
    this.postService.getPosts().subscribe((res)=>{
      this.posts = res;
    },(err)=>{
      console.log(err);
    });
  }

}
