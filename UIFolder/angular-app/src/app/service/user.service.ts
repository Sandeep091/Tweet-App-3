import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl = environment.serviceUrl + "tweets/";
  constructor(private http: HttpClient) { }

  public userLogin(data: any) {
   return this.http.post<any>(this.baseUrl + 'login', data);
  }

  public userRegister(data: any) {
   return this.http.post<any>(this.baseUrl + 'register', data);
  }

  public forgotPassword(userName:String, data: any) {
    return this.http.put<any>(this.baseUrl + `${userName}/forgot`,data );
  }
}