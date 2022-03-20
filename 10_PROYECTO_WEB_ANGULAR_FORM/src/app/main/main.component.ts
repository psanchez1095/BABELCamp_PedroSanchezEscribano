import { Component, OnInit } from '@angular/core';
import {Game} from 'src/app/main/game'
@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent {
  //Map
 
  //Array Juegos
  games :Array<Game> = []
  //MAP <id,game>
  map = new Map<string, Game>()

  //Property Binding
  titledivDerMain:string ="Operaciones Juegos";
  titleArrGames:string = "Juegos Disponibles"
  placeholderID:string ="Id";
  placeholderTitulo:string ="Titulo";
  placeholderCompania:string ="Compañia";
  placeholderVMedia:string ="Valoración Media";

  id:string ="";
  titulo:string ="";
  compania:string ="";
  vMedia:string ="";

  errorMessage:string="";
  error:boolean =true;

    
  constructor() {}

  public addGame(){
        //Comrpuebo que los campos no esten vacios y que la valoracion media es un número
        if(this.id!="" && this.titulo!="" && this.compania!="" && this.vMedia!="" && !isNaN(parseInt(this.vMedia))){
          
          //compruebo si existe el id en el array ayudandome de un Map
          if(this.map.has(this.id)){

            this.errorMessage= "Ya existe un juego con ese id."
            this.error = false;

            setTimeout( () => {
             this.error=true;
            },2500)

          }
          //En caso de que no exista meto el juego en el array y añado al map el <id,juego>
          else{
              let game = new Game(this.titulo,this.compania,parseInt(this.vMedia),"",parseInt(this.id))
              this.map.set(this.id,game)
              this.games.push(game);
              this.id = "";
              this.titulo = "";
              this.compania = "";
              this.vMedia= "";
          }
        }
         //En caso de que algun campo este vacio y/o la valoración media sea un string
        else{
            
            if(this.vMedia != "" &&isNaN(parseInt(this.vMedia)))  this.errorMessage= "La valoración media debe ser un número."
            else this.errorMessage= "Los campos titulo,compañia y valoración media no pueden estar vacios."
            this.error=false;
           
            setInterval( () => {
              this.error=true;
             },2500)
                  
        }

  }
 
}
