import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-main-login',
  templateUrl: './main-login.component.html',
  styleUrls: ['./main-login.component.css']
})

export class MainLoginComponent {

  //Property Binding
  mainTitle: string = 'Login';
  infoTitle: string = 'Información';
  infoText : string = "Para acceder a Videogames App debe loguearse con un usuario y contraseña previamente registrados. En el caso de que haya algun error se notificará al usuario"
  infoFormatLogin : string = "El usuario podra loguearse con su email o correo electrónico y su contraseña"
  placeholderUserEmail: string = 'Correo / Nombre de Usuario';
  placeholderContrasenia: string = 'Contraseña';
  errorMessage: string = '';

  error: boolean = true;
  
  route : ActivatedRoute = new ActivatedRoute();
  constructor(route:ActivatedRoute) {
    route  = route;
  }

  
}
