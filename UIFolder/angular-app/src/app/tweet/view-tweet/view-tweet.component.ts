import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';
import { TweetService } from 'src/app/service/tweet.service';


@Component({
  selector: 'app-view-tweet',
  templateUrl: './view-tweet.component.html',
  styleUrls: ['./view-tweet.component.css']
})
export class ViewTweetComponent implements OnInit {
  "tweetList": any = [];
  "byUser": boolean
  constructor(private tweetService: TweetService,private authService:AuthService, private router: Router) { }

  ngOnInit(): void {
    sessionStorage.clear();
    let url = window.location.pathname.split('/').pop();
    if (url == 'home') {
      this.byUser = false;
      this.tweetService.getAllTweet().subscribe({
        next: (data: any) => { if (data.status) { this.tweetList = data.posts } },
      });
    } else {
      this.byUser = true;
      this.tweetService.getAllTweetByUserName().subscribe({
        next: (data: any) => { if (data.status) { this.tweetList = data.posts } },
      });;
    }
  }
  getUserName(){
    return this.authService.getUser();
  }

  onUpdate(detail: any) {
    sessionStorage.setItem('updateTweet', JSON.stringify(detail));
    this.router.navigateByUrl('/updateTweet');
  }

  onDelete(tweetId: string) {
    this.tweetService.deleteTweet(tweetId).subscribe(
      data => {
        if (data.status) {
          //mess
          let index = this.tweetList.findIndex((data: any) => data.id == tweetId);
          this.tweetList.splice(index, 1);
        } else {
          //mess
        }
      }
    )
  }

  AddLike(tweetId: string) {
    this.tweetService.likeATweet(tweetId).subscribe({
      next: (data: any) => {
        if (data.status) {
          let index = this.tweetList.findIndex((data: any) => data.id == tweetId);
          this.tweetList[index].likes++;
        } else {
          //mess
        }
      }
    })
  }

}