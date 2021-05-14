import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/service/user';
import { UserService } from 'src/app/service/user.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  "signupForm": FormGroup;
  "user": User[];
  // passwordError: boolean;
  "signupformValidation": boolean = false;
  constructor(private fb: FormBuilder, private router: Router,private userService:UserService) { };

  ngOnInit() {
    // this.passwordError = true;
    // this.error = null;
    this.signupForm = this.fb.group({
      userName: ['', [
        Validators.required
      ]],
      firstName: ['', [
        Validators.required
      ]],
      lastName: [''],
      password: ['', [
        Validators.required
      ]],
      confirmPassword: ['', [
        Validators.required
      ]],
      email: ['', [Validators.required, Validators.email]],
      contactNumber:['',[Validators.required,Validators.pattern(/^[0-9]{0,9}$/)]]
    });
  }
  public getFormControl(name: string) {
    return this.signupForm.get(name);
  }
  onSignup() {
    if (this.signupForm.value.password != this.signupForm.value.confirmPassword) {
      this.signupformValidation = true;

    }
    else {
      console.log("Successful");
      
    }

  }
  onSubmit() {
    console.log("In submit")
    console.log(this.signupForm.value);
    this.userService.userRegister(this.signupForm.value).subscribe(
      {
        next:(data:any)=>{if(data.status){
         this.router.navigateByUrl('/login');
         console.log(data.message);
        }else{
          console.log(data.message);
        }}
      });
  }
}