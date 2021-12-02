import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { post } from 'src/app/models/post';
import { PostService } from 'src/app/service/post/post.service';

@Component({
  selector: 'app-new-news',
  templateUrl: './new-news.component.html',
  styleUrls: ['./new-news.component.scss'],
})
export class NewNewsComponent implements OnInit {
  post: post;
  news: FormGroup;

  constructor(fb: FormBuilder,private postService: PostService) {
    this.news = fb.group({
      titel: '',
      text: '',
      isConcert: false,
    });
  }

  ngOnInit(): void {}

  createPost() {
    this.post.title = this.news.get('titel').value;
    this.post.text = this.news.get('text').value;
    this.post.isConcert = this.news.get('isConcert').value;
    this.postService.createPost(this.post).subscribe((res)=>{
      alert('Post erfolgreich erstellt');
    }, (err)=>{
      alert('Post konnte nicht erstellt werden Error: '+err)
    })
  }
  
}
