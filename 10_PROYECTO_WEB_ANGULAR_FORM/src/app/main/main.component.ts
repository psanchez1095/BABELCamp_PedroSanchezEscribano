import { Component, OnInit } from '@angular/core';
import {Game} from 'src/app/main/game'
@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent {

  //Array Juegos
  games :Array<Game> = []

  //Property Binding
  titulodivDerMain:string ="Operaciones Juegos";
  placeholderID:string ="Id";
  placeholderTitulo:string ="Titulo";
  placeholderCompania:string ="Compañia";
  placeholderVMedia:string ="Valoración Media";

    
  constructor() {}

 
}
