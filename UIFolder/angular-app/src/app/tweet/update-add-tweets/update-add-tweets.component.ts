import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TweetService } from 'src/app/service/tweet.service';

@Component({
  selector: 'app-update-add-tweets',
  templateUrl: './update-add-tweets.component.html',
  styleUrls: ['./update-add-tweets.component.css']
})
export class UpdateAddTweetsComponent implements OnInit {

  "addTweetForm": FormGroup;
  "isUpdate": Boolean;
  "updateDetail":any;
  constructor(private fb: FormBuilder, private router: Router, private tweetService: TweetService) { }

  ngOnInit(): void {
    this.formInitialization();
    let url = window.location.pathname.split('/').pop();
    if (url == 'addTweet') {
      this.isUpdate = false;
    } else {
      this.isUpdate = true;
      this.updateDetail = sessionStorage.getItem('updateTweet');
      this.patchValue(JSON.parse(this.updateDetail));
    }
  }

  formInitialization(): void {
    this.addTweetForm = this.fb.group({
      tweet: ['', [Validators.required]],
      tags: [''],
    })
  }

  patchValue(detail: any): void {
    this.addTweetForm.patchValue({
      tweet: detail.tweet,
      tags: detail.tags
    })
  }

  submit(): void {
    if (this.addTweetForm.valid) {
      if (this.isUpdate) {
        this.tweetService.updateTweet(this.addTweetForm.value, JSON.parse(this.updateDetail).id).subscribe(
          (data) => {
            if (data.status) {
              //msg
              setTimeout(() => {
                this.router.navigateByUrl('/home');
              }, 5000);
            }
          });
      } else {
        this.tweetService.addTweet(this.addTweetForm.value).subscribe(
          (data) => {
            if (data.status) {
              //msg
              setTimeout(() => {
                this.router.navigateByUrl('/home');
              }, 5000);
            }
          });
      }
    } else {
      //msg
    }
  }

}
