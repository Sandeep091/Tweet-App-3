import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class TweetService {
  private baseUrl = environment.serviceUrl + "tweets/";
  constructor(private http: HttpClient, private auth: AuthService) { }

  public getAllTweet() {
    return this.http.get<any>(this.baseUrl + "all")
  }
  public getAllTweetByUserName() {
    return this.http.get<any>(this.baseUrl + this.auth.getUser())
  }
  public addTweet(data: any) {
    return this.http.post<any>(this.baseUrl + this.auth.getUser() + '/add', data);
  }
  public updateTweet(data: any, tweetId: String) {
    return this.http.put<any>(this.baseUrl + this.auth.getUser() + '/update/' + tweetId, data);
  }
  public likeATweet(tweetId: string) {
    return this.http.put<any>(this.baseUrl + this.auth.getUser() + '/like/' + tweetId, {});
  }
  public replyToTweet(data: any, tweetId: string) {
    return this.http.post<any>(this.baseUrl + this.auth.getUser() + '/reply/' + tweetId, data);
  }
  public deleteTweet(tweetId: string) {
    return this.http.delete<any>(this.baseUrl + this.auth.getUser() + '/delete/' + tweetId);
  }
}