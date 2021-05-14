import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  "forgotPasswordForm": FormGroup;
  // "user": User[];
  "successMsg": boolean = false;
  "userNameEntered": boolean = false;
  constructor(private fb: FormBuilder, private router: Router,private userService:UserService) { }

  ngOnInit(): void { 
    this.forgotPasswordForm = this.fb.group({
    userName: ['', [
      Validators.required
    ]],
    
    password: ['', [
      Validators.required
    ]],
    confirmPassword: ['', [
      Validators.required
    ]],
    
  });
  }

  public getFormControl(name: string) {
    return this.forgotPasswordForm.get(name);
  }

  onUserNameEntered() {
    console.log("In submit")
    console.log(this.forgotPasswordForm.value.userName);
    this.userNameEntered = true;
  }

  onPasswordChange(){
    console.log(this.forgotPasswordForm.value);
    this.userService.forgotPassword(this.forgotPasswordForm.value.userName,this.forgotPasswordForm.value).subscribe(
      {
        next:(data:any)=>{if(data.status){
          this.userNameEntered=false;
          this.successMsg = true;
         this.router.navigateByUrl('/forgot-password');
         console.log(data.message);
        }else{
          console.log(data.message);
        }}
      });
  }

}
