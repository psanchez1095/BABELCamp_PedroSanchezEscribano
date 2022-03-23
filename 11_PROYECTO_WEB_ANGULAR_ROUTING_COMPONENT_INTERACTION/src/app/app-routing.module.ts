import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { MainAboutUsComponent } from './main-about-us/main-about-us.component';
import { MainContactComponent } from './main-contact/main-contact.component';
import { MainDetailGameComponent } from './main-detail-game/main-detail-game.component';
import { MainLoginComponent } from './main-login/main-login.component';
import { MainComponent } from './main/main.component';

const routes: Routes = [
  {
    path : '', //En este caso decimos el componente que mostraremos de base
    component : MainLoginComponent
  },
  {
    path : 'index/:userEmail/:urlIconStatus', //cuando definimos el 'path' no puede empezar por '/'
    component : MainComponent
  },
  {
    path : 'contact',
    component : MainContactComponent
  },
  {
    path : 'aboutUs',
    component : MainAboutUsComponent
  },
  {
    path : 'detailGame/:title/:compania/:vMedia/:urlImg/:userEmail/:urlIconStatus', 
    component : MainDetailGameComponent
  },

 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
