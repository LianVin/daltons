import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Role } from 'src/app/models/role';
import { User } from 'src/app/models/user';
import { RoleService } from 'src/app/service/role/role.service';
import { UserService } from 'src/app/service/user/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent implements OnInit {
  public newUser: FormGroup;
  public users: User[] = [];
  public user = <User>{};
  public e: any = {};

  constructor(private _userService: UserService, private _roleService: RoleService, private router: Router, fb: FormBuilder) {
    this.newUser = fb.group({
      username: null,
      firstName: null,
      lastName: null,
      email: null,
      password: null
    });
  }

  ngOnInit(): void {}

  registeration(): void{
    let user = new User();
    user.firstName = this.newUser.get('firstName').value;
    user.username = this.newUser.get('username').value;
    user.lastName = this.newUser.get('lastName').value;
    user.email = this.newUser.get('email').value;
    user.password = this.newUser.get('password').value;
    console.log(user);
    this._userService.getUserByName(user.username).subscribe(result => {
      if (result == null) {
        this._roleService.getRolebyId(1).subscribe((result) => {
          user.roleId = result;
          this._userService.createUser(user).subscribe();
          this.router.navigate(['/news/']);
        });
      } else {
        console.log("Username already in use")
      }
    })
  }
}
