import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  isLoggedIn = false;
  private "userName": string;
  private "userId": number;
  constructor() { }

  public setUser(userName: string) {
    this.userName = userName;
  }
  public getUser() {
    return this.userName;
  }
  public setUserId(Id: number) {
    this.userId = Id;
  }
  public getUserId() {
    return this.userId;
  }
}