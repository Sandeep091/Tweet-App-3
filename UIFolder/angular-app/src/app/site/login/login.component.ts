import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';
import { UserService } from 'src/app/service/user.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  "username": String;
  "loginForm": FormGroup;
  "isLoggedIn": boolean;
  "formValidation": boolean = true;
  constructor(private fb: FormBuilder, private router: Router,private auth:AuthService, private userService: UserService) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      userName: ['', [
        Validators.required
      ]],
      password: ['', [
        Validators.required
      ]]
    })
  }
  login() {
    if (this.loginForm.valid)
      this.userService.userLogin(this.loginForm.value).subscribe({
        next:(data:any)=>{if(data.status){
          console.log(data);
          console.log(data.status);

          this.auth.isLoggedIn = true;
          this.auth.setUser(this.loginForm.value.userName);
          this.router.navigateByUrl('/home')
        }else{
          this.auth.isLoggedIn = false;
          console.log("Failed");
          console.log("");
        }}
      });
  }
}
