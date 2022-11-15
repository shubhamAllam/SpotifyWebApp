import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CheckLoginService {

  constructor() { }

  isLogin?:boolean;
}
