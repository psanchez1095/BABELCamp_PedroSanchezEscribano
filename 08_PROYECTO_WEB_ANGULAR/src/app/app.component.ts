import { Component } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  public nombre : string  = 'Pedro Sánchez Escribano';
  public correo : string = 'ps95se@gmail.com';
  public telefono : number = 630413222;
  public municipio : string ="Madrid"
}
