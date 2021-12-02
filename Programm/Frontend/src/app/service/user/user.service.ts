import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { resourceUsage } from 'process';
import { user } from 'src/app/models/user';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class UserService {
  private url = environment.backendUrl + "user"

  constructor(private httpClient: HttpClient) { }

  getUser() {
    return this.httpClient.get<user[]>(this.url);
  }

  getUserbyId(id: number) {
    return this.httpClient.get<User>(this.url + id);
  }

  deleteUser(id: number) {
    return this.httpClient.delete(this.url + id);
  }

  updateUser(user: User) {
    return this.httpClient.put<User>(this.url + user.userId, user);
  }

  createUser(user: user) {
    return this.httpClient.post(this.url, user).subscribe(result=>{console.log(result)});
  }

  getUserByName(username: String){
    return this.httpClient.get<user>(this.url + "/getByUsername/" + username);
  }
}
