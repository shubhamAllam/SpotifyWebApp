import { Injectable } from '@angular/core';
import { Song } from '../model/song';

@Injectable({
  providedIn: 'root'
})
export class SongsService {

  constructor() { }

  songList:Array<Song> = [
    {
      "songId":"100001",
      "songName":"Sans Theme",
      "artist":"Toby Fox",
      "band":"Undertale",
      "address":"/addr1" 
    },
    {
      "songId":"100002",
      "songName":"Berdly Theme",
      "artist":"Toby Fox",
      "band":"DeltaRune",
      "address":"/addr2" 
    },
    {
      "songId":"100003",
      "songName":"Queen Theme",
      "artist":"Toby Fox",
      "band":"Deltarune",
      "address":"/addr3" 
    },
    {
      "songId":"100004",
      "songName":"Papyrus Theme",
      "artist":"Toby Fox",
      "band":"Undertale",
      "address":"/addr4" 
    },
    {
      "songId":"100005",
      "songName":"Numb",
      "artist":"Jester",
      "band":"Linkin Park",
      "address":"/addr5" 
    },
    {
      "songId":"100006",
      "songName":"Londen view",
      "artist":"XXXTencent",
      "band":"NIL",
      "address":"/addr6" 
    },
    {
      "songId":"100007",
      "songName":"Fell Invincible",
      "artist":"Skillet",
      "band":"Skillet",
      "address":"/addr7" 
    },
    {
      "songId":"100008",
      "songName":"Live Free or let me Die",
      "artist":"Skillet",
      "band":"Skillet",
      "address":"/addr8" 
    },
    {
      "songId":"100009",
      "songName":"I will not Die",
      "artist":"Three days gracce",
      "band":"Three days gracce",
      "address":"/addr9" 
    },
    {
      "songId":"100010",
      "songName":"I Don't Like",
      "artist":"Bang",
      "band":"Bang",
      "address":"/addr10" 
    },
    {
      "songId":"100011",
      "songName":"Curtain call",
      "artist":"Three days gracce",
      "band":"Three days gracce",
      "address":"/addr11" 
    },
    {
      "songId":"100012",
      "songName":"I am Dengeroues",
      "artist":"Three days gracce",
      "band":"Three days gracce",
      "address":"/addr12" 
    },
    {
      "songId":"100013",
      "songName":"Leave out all the rest",
      "artist":"Jester, Shinoda",
      "band":"Linkin Park",
      "address":"/addr13" 
    },
    {
      "songId":"100014",
      "songName":"Assassin's Pride",
      "artist":"Unknown",
      "band":"Assassin's Creed",
      "address":"/addr14" 
    },
    {
      "songId":"100015",
      "songName":"Demons",
      "artist":"Imagine Dragons",
      "band":"Imagine Dragons",
      "address":"/addr15" 
    },
    {
      "songId":"100016",
      "songName":"Redioactive",
      "artist":"Imagine Dragons",
      "band":"Imagine Dragons",
      "address":"/addr16" 
    },
    {
      "songId":"100017",
      "songName":"Melody",
      "artist":"Fat Rat",
      "band":"Fat Rat",
      "address":"/addr17" 
    },
    {
      "songId":"100018",
      "songName":"Undyne Theme",
      "artist":"Undertale",
      "band":"Undertale",
      "address":"/addr18" 
    },
    {
      "songId":"100019",
      "songName":"Kise Theme",
      "artist":"Knb",
      "band":"Knb",
      "address":"/addr19" 
    },
    {
      "songId":"100020",
      "songName":"Triple threat",
      "artist":"Akashi",
      "band":"Knb",
      "address":"/addr20" 
    },
  ];
}
