import { Injectable } from '@angular/core';
import { User } from '../model/user';
import { UserPlaylist } from '../model/user-playlist';

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  constructor() { }

  user:User | undefined;

  trueUser:UserPlaylist | undefined;
}
