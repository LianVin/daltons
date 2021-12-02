import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Role } from 'src/app/models/role';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class RoleService {

  private url = environment.backendUrl + "/role/"

  constructor(private httpClient: HttpClient) { }

  getRole() {
    return this.httpClient.get<Role []>(this.url);
  }

  getRolebyId(id: number) {
    return this.httpClient.get<Role>(this.url + id);
  }

  deleteRole(id: number) {
    return this.httpClient.delete(this.url + id);
  }

  updateRole(role: Role) {
    return this.httpClient.put<Role>(this.url + role.roleId, role);
  }

  createRole(role: Role) {
    return this.httpClient.post(this.url, role);
  }
}
