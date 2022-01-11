import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav-header',
  templateUrl: './nav-header.component.html',
  styleUrls: ['./nav-header.component.scss']
})
export class NavHeaderComponent implements OnInit {
  
  logedin: Boolean;
  constructor() { }
  

  ngOnInit(): void {
    this.logedin = localStorage.getItem('loggedin')?.includes('t');
  }


  logedout(){
    localStorage.clear();
  }

}
