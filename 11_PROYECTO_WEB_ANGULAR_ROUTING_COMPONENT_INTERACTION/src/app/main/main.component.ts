import { Component, OnInit } from '@angular/core';
import { Game } from 'src/app/game';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
})
export class MainComponent {
  //Map

  //Array Juegos
  public games: Array<Game> = [];
  //MAP <id,game>
  map = new Map<string, Game>();

  //Property Binding
  titledivDerMain: string = 'Detalle Juegos';
  titleArrGames: string = 'Juegos Disponibles';
  placeholderID: string = 'Id';
  placeholderTitulo: string = 'Titulo';
  placeholderCompania: string = 'Compañia';
  placeholderVMedia: string = 'Valoración Media';

  id: string = '';
  titulo: string = '';
  compania: string = '';
  vMedia: string = '';
  userEmail: string =""
  urlIconUser: string =""
  errorMessage: string = '';
  titleUser: string ="User Info"
  error: boolean = true;
  addButtonDisabled: boolean = false;
  deleteButtonDisabled: boolean = true;
  editButtonDisabled: boolean = true;
  clearButtonDisabled: boolean = true;
  route : ActivatedRoute = new ActivatedRoute();

  constructor(route:ActivatedRoute) {

     this.userEmail = route.snapshot.params["userEmail"]
     this.urlIconUser =  route.snapshot.params["urlIconStatus"]
     console.log( route.snapshot.params["urlIconStatus"])
    //Para Pruebas
    let game = new Game("1w"," 2", 63, 3)
    let game2 = new Game("44r41"," 2ew", 43, 2)
    let game3 = new Game("ewr1"," 2ewr", 23, 4)
    let game4 = new Game("1qew"," 2ewrew", 13, 1)
    let game5 = new Game("erew1"," 2", 23, 55)
    this.games.push(game,game2,game3,game4,game5)
  }

  public getGames(): Array<Game> {
    return this.games;
  }
  
 /**
  * @author Pedro Sánchez Escribano
  * @param game 
  * Actualiza los valores de los atributos Two Ways Binding con los valores del objecto de tipo Game que recibe
  */
  public select(game: Game) {

    this.id = game.getId().toString();
    this.titulo = game.getTitulo()
    this.compania = game.getCompania()
    this.vMedia = game.getValoracionMedia().toString()

    this.addButtonDisabled = true
    this.editButtonDisabled = false
    this.deleteButtonDisabled = false

  }
  

}
