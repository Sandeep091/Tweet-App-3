import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './site/header/header.component';
import { LoginComponent } from './site/login/login.component';
import { RegisterComponent } from './user/register/register.component';
import { ViewTweetComponent } from './tweet/view-tweet/view-tweet.component';
import { AuthGuard } from './auth.guard';
import { UpdateAddTweetsComponent } from './tweet/update-add-tweets/update-add-tweets.component';
import { ForgotPasswordComponent } from './user/forgot-password/forgot-password.component';



const routes: Routes = [
  { path: "home", component: ViewTweetComponent, canActivate:[AuthGuard] },
  { path: "home/user", component: ViewTweetComponent,canActivate:[AuthGuard] },
  { path: 'addTweet', component: UpdateAddTweetsComponent,canActivate:[AuthGuard] },
  { path: 'updateTweet', component: UpdateAddTweetsComponent,canActivate:[AuthGuard] },
  { path: 'signup', component: RegisterComponent },
  { path: "", redirectTo: "login", pathMatch: "full" },
  { path: "login", component: LoginComponent },
  {path:"forgot-password", component:ForgotPasswordComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    RegisterComponent,
    ViewTweetComponent,
    UpdateAddTweetsComponent,
    ForgotPasswordComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
