import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { picture } from 'src/app/models/picture';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PictureService {

  private url = environment.backendUrl + "/picture/"

  constructor(private httpClient: HttpClient) { }

  getPictures() {
    return this.httpClient.get<picture[]>(this.url);
  }

  getPicturebyId(id: number) {
    return this.httpClient.get<picture>(this.url + id);
  }

  deletePicture(id: number) {
    return this.httpClient.delete(this.url + id);
  }

  updatePicture(picture: picture) {
    return this.httpClient.put<picture>(this.url + picture.pictureId, picture);
  }

  createPicture(picture: picture) {
    return this.httpClient.post(this.url, picture);
  }
}
