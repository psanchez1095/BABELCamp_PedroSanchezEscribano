import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-main-login',
  templateUrl: './main-login.component.html',
  styleUrls: ['./main-login.component.css']
})

export class MainLoginComponent {

  //Property Binding
  titledivDerMain: string = 'Login';
  titleArrGames: string = 'Información';
  placeholderUserEmail: string = 'Correo / Nombre de Usuario';
  placeholderContrasenia: string = 'Contraseña';
  errorMessage: string = '';

  error: boolean = true;
  
  route : ActivatedRoute = new ActivatedRoute();
  constructor(route:ActivatedRoute) {
    route  = route;
  }

  
}
