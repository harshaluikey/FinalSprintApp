import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignUpComponent } from './sign-up/sign-up.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { HomeComponent } from './home/home.component';
import { ShowUsersComponent } from './show-users/show-users.component';

const routes: Routes = [
  {
    path:'signUp',
    component:SignUpComponent
  },
  {
    path:'signIn',
    component:SignInComponent
  },
  {
    path:'',
    component:HomeComponent
  },
  {
  path:'signIn/signUp',
  component:SignUpComponent
  },
  {
    path:'showUsers',
    component:ShowUsersComponent
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
