import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { post } from 'src/app/models/post';
import { PostService } from 'src/app/service/post/post.service';

@Component({
  selector: 'app-alert-news',
  templateUrl: './alert-news.component.html',
  styleUrls: ['./alert-news.component.scss'],
})
export class AlertNewsComponent implements OnInit {
  post: post;
  news: FormGroup;

  constructor(
    fb: FormBuilder,
    private postService: PostService,
    private route: ActivatedRoute
  ) {
    this.news = fb.group({
      titel: '',
      text: '',
      isConcert: false,
    });
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((m) => {
      this.postService
        .getPostbyId(Number.parseInt(m.get('id')))
        .subscribe((res: post) => {
          this.post = res;
          this.news.get('titel').setValue(this.post.title);
          this.news.get('text').setValue(this.post.text);
          this.news.get('isConcert').setValue(this.post.isConcert);
        });
    });
  }

  editPost() {
    this.post.title = this.news.get('titel').value;
    this.post.text = this.news.get('text').value;
    this.post.isConcert = this.news.get('isConcert').value;
    this.postService.updatePost(this.post).subscribe(
      (res) => {
        alert('Post erfolgreich erstellt');
      },
      (err) => {
        alert('Post konnte nicht erstellt werden Error: ' + err);
      }
    );
  }
}
