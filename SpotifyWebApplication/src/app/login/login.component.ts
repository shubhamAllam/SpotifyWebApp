import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { CheckLoginService } from '../services/check-login.service';
import { StorageService } from '../services/storage.service';
import { UserAuthService } from '../services/user-auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private router:Router, private userAuthService:UserAuthService, private loginService:CheckLoginService, private storage:StorageService) { }


  ngOnInit(): void {
    //this.dummyUser = this.authService.LoginUser(this.LoginForm.value);
  }

  LoginForm = new FormGroup({
    userName  : new FormControl('', Validators.required),
    password : new FormControl('', Validators.required)
  });

  loginFunc(){
    const regData = this.LoginForm.value; 
    this.userAuthService.LoginUser(regData).subscribe(
      (response) => {
        this.loginService.isLogin=true;
        console.log(response);
        this.storage.user = response;
        localStorage.setItem('email',response.email);
        alert("Login Successfull!");
        this.router.navigateByUrl("dashboard");
      },
      () => {
        alert("Username or Password Invalid!");
      }
    )
  }

  fetchData(){
    this.userAuthService.getRealUser(localStorage.getItem('email')).subscribe(
      (response) => {
        this.storage.trueUser=response;
      }
    )
  }

  callLoginFuncFetchData(){
    this.loginFunc();
    
    this.fetchData();
  }

  navToRegister(){
    this.router.navigateByUrl('/home/register');
  }

}
