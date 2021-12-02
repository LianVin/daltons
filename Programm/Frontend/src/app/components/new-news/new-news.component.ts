import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Post } from 'src/app/models/post';
import { PostService } from 'src/app/service/post/post.service';

@Component({
  selector: 'app-new-news',
  templateUrl: './new-news.component.html',
  styleUrls: ['./new-news.component.scss'],
})
export class NewNewsComponent implements OnInit {
  news: FormGroup;

  constructor(fb: FormBuilder, private postService: PostService) {
    this.news = fb.group({
      titel: '',
      text: '',
      isConcert: false,
    });
  }

  ngOnInit(): void {}

  createPost() {
    let newPost = new Post();
    newPost.title = this.news.get('titel').value;
    newPost.text = this.news.get('text').value;
    newPost.isConcert = this.news.get('isConcert').value;
    this.postService.createPost(newPost).subscribe((res)=>{
      alert('Post erfolgreich erstellt');
    }, (err)=>{
      alert('Post konnte nicht erstellt werden Error: '+err)
    })
  }
  
}
