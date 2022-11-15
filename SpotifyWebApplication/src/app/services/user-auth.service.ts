import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RegUser } from '../model/reg-user';
import { Song } from '../model/song';
import { User } from '../model/user';
import { UserPlaylist } from '../model/user-playlist';
import { StorageService } from './storage.service';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  constructor(private httpClient: HttpClient, private storage:StorageService) { }

  tempUser:User=new User();
  user:RegUser=new RegUser();

  registerApi = 'http://localhost:9000/app/spotify-service/user';
  loginApi = 'http://localhost:9000/app/authentication/login';                                      // User API
  getUserWithPlaylistApi = 'http://localhost:9000/app/spotify-service/user/'

  addSongToPlaylistApi = 'http://localhost:9000/app/spotify-service/user/playlist/'                  // Playlist API
  deleteSongfromPlaylistApi = 'http://localhost:9000/app/spotify-service/user/playlist/remove/'
  

  registerUser(regData:any):Observable<RegUser>{
    return this.httpClient.post<RegUser>(this.registerApi, regData);
  }

  LoginUser(loginData:any):Observable<User>{
    return this.httpClient.post<User>(this.loginApi, loginData);
  }

  getRealUser(email:any):Observable<UserPlaylist>{
    return this.httpClient.get<UserPlaylist>(this.getUserWithPlaylistApi.concat(email));
  }

  addSongToPlaylist(songData:any, email:any):Observable<any>{
    return this.httpClient.put<Song>(this.addSongToPlaylistApi.concat(email), songData);
  }

  removeSongFromPlaylist(songData:any, email:any):Observable<any>{
    return this.httpClient.put<Song>(this.deleteSongfromPlaylistApi.concat(email), songData);
  }

  updateEverything(email:any){
    this.httpClient.get<UserPlaylist>(this.getUserWithPlaylistApi.concat(email)).subscribe((response) => {
      this.storage.trueUser = response;
    })
  }
}
