import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserAuthService } from '../services/user-auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  constructor(private userAuthService:UserAuthService, private router:Router) { }

  ngOnInit(): void {
  }

  RegistryForm = new FormGroup({
    userName : new FormControl('',[Validators.required]),
    password : new FormControl('',[Validators.required, Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[#$@!%&*?])[A-Za-z\d#$@!%&*?]{8,30}$/)]),
    email : new FormControl('',[Validators.required, Validators.email]),
    userId : new FormControl('',[Validators.pattern(/^\d+$/), Validators.maxLength(6)])
  })

  registerData(){
    const regData = this.RegistryForm.value;
    this.userAuthService.registerUser(regData).subscribe(() =>{
      alert("Registeration Successfully!")
      this.router.navigateByUrl("/home/login");
    },error => {
      alert(error)
    });
  }
  
}
