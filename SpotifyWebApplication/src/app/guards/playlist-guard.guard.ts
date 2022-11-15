import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { CheckLoginService } from '../services/check-login.service';

@Injectable({
  providedIn: 'root'
})
export class PlaylistGuardGuard implements CanActivate {

  constructor(private loginService:CheckLoginService, private route:Router){}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if(this.loginService.isLogin){
      return true;
    }else if(!this.loginService.isLogin){
      alert('Login is Mandatory!');
      this.route.navigateByUrl('/home')
      return false;
    }else{
      return false;
    }
  }
  
}
