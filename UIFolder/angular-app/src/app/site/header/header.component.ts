import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private auth:AuthService) { }

  ngOnInit(): void {
  }
  getUser() {
    return this.auth.getUser() ;
  }
  onSignOut() {
    
  }
  isLogin() {
    return this.auth.isLoggedIn;
  }
}