import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { Song } from '../model/song';
import { CheckLoginService } from '../services/check-login.service';
import { SongsService } from '../services/songs.service';
import { StorageService } from '../services/storage.service';
import { UserAuthService } from '../services/user-auth.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  constructor(private songService:SongsService, private userAuth:UserAuthService, private loginService:CheckLoginService, private router:Router, private storage:StorageService) { }

  ngOnInit(): void {
    
  }

  allSongs = this.songService.songList;
  check:any = this.loginService.isLogin;

  playSong(){
    if(this.loginService.isLogin === true){
      alert("Playing Song!");
    }
    else{
      alert("Login is Mandatory for playing music");
      this.router.navigateByUrl('/home');
    }
  }

  addToPlaylist(song:Song){
    if(this.loginService.isLogin == true){
      this.userAuth.addSongToPlaylist(song, this.storage.trueUser?.email).subscribe(() =>{
        this.userAuth.updateEverything(localStorage.getItem('email'));    //
        alert("Song Added Successfully");
      },
      (err)=>{
        alert(err);
      }
      );
    }else{
      alert("Login is Mandatory for playing music");
      this.router.navigateByUrl('/home');
    }
  }

  navToHome(){
    this.router.navigateByUrl('/home');
  }

  navToPlaylist(){
    this.userAuth.updateEverything(this.storage.trueUser?.email);
    this.router.navigateByUrl('/playlist');
  }

  logoutFunc(){
    this.loginService.isLogin=false;
    alert("Loged Off successful!")
    this.router.navigateByUrl('/home/login')
  }
}
