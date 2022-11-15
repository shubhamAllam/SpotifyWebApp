import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Song } from '../model/song';
import { StorageService } from '../services/storage.service';
import { UserAuthService } from '../services/user-auth.service';

@Component({
  selector: 'app-playlist',
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.scss']
})
export class PlaylistComponent implements OnInit {

  constructor(private router:Router, private storage:StorageService, private userAuthService:UserAuthService) { }

  ngOnInit(): void {
  }

  navToDashboard(){
    this.router.navigateByUrl('dashboard');
  }

  playlistItem:Array<Song> = this.storage.trueUser?.playlist;

  playSong(){
    alert("Playing Song!");
  }

  removeSong(song:Song){
    this.userAuthService.removeSongFromPlaylist(song, localStorage.getItem('email')).subscribe(() => {      //
      console.log("I was Here");
      this.userAuthService.updateEverything(localStorage.getItem('email'));
      alert("Song has been Deleted!");
    },
    (error) => {
      console.log(error);
    })
  }
}
