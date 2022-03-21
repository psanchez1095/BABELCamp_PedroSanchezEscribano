import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { MainLoginComponent } from './main-login/main-login.component';
import { MainComponent } from './main/main.component';

const routes: Routes = [
  {
    path : '', //En este caso decimos el componente que mostraremos de base
    component : MainLoginComponent
  },
  {
    path : 'index/:routeMessage', //cuando definimos el 'path' no puede empezar por '/'
    component : MainComponent
  },

 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
