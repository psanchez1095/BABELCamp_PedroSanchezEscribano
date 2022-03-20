import { Component, OnInit } from '@angular/core';
import { Game } from 'src/app/main/game';
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
  titledivDerMain: string = 'Operaciones Juegos';
  titleArrGames: string = 'Juegos Disponibles';
  placeholderID: string = 'Id';
  placeholderTitulo: string = 'Titulo';
  placeholderCompania: string = 'Compañia';
  placeholderVMedia: string = 'Valoración Media';

  id: string = '';
  titulo: string = '';
  compania: string = '';
  vMedia: string = '';

  errorMessage: string = '';

  error: boolean = true;
  addButtonDisabled: boolean = false;
  deleteButtonDisabled: boolean = true;
  editButtonDisabled: boolean = true;
  clearButtonDisabled: boolean = true;
  
  constructor() {

    //Para Pruebas
    let game = new Game("1w"," 2", 63, 3)
    let game2 = new Game("44r41"," 2ew", 43, 2)
    let game3 = new Game("ewr1"," 2ewr", 23, 4)
    let game4 = new Game("1qew"," 2ewrew", 13, 1)
    let game5 = new Game("erew1"," 2", 23, 55)
    this.games.push(game,game2,game3,game4,game5)
  }

  public getGames() : Array<Game>{
    return this.games;
  }

  //Añade un juego al array con los datos del formulario
  public addGame() {
    //Compruebo que los campos no esten vacios y que la valoracion media es un número
    if (
      this.id != '' &&
      this.titulo != '' &&
      this.compania != '' &&
      this.vMedia != '' &&
      !isNaN(parseInt(this.vMedia))
    ) {
      //compruebo si existe el id en el array ayudandome de un Map
      if (this.map.has(this.id)) {
        this.errorMessage = 'Ya existe un juego con ese id.';
        this.error = false;

        setTimeout(() => {
          this.error = true;
        }, 2500);
      }
      //En caso de que no exista meto el juego en el array y añado al map el <id,juego>
      else {
        let game = new Game(
          this.titulo,
          this.compania,
          parseInt(this.vMedia),
          parseInt(this.id)
        );
        this.map.set(this.id, game);
        this.games.push(game);
        this.id = '';
        this.titulo = '';
        this.compania = '';
        this.vMedia = '';
      }
    }
    //En caso de que algun campo este vacio y/o la valoración media sea un string
    else {
      if (this.vMedia != '' && isNaN(parseInt(this.vMedia)))
        this.errorMessage = 'La valoración media debe ser un número.';
      else
        this.errorMessage =
          'Los campos titulo,compañia y valoración media no pueden estar vacios.';
      this.error = false;

      setInterval(() => {
        this.error = true;
      }, 2500);
    }
  }
  
  //Borra un juego del array de juegos
  public delete() {
    
  }
  
  //Limpia los valores de un juego
  public edit() {
    
  }

  //Limpia los campos del formulario
  public clear() {
    this.id = '';
    this.titulo = '';
    this.compania = '';
    this.vMedia = '';
  }
  
  //Funcion que ese ejecuta cuando se selecciona un juego
  public select(game : Game) {
    
    this.id = game.getId().toString();
    this.titulo = game.getTitulo()
    this.compania = game.getCompania()
    this.vMedia = game.getValoracionMedia().toString()
  
    this.addButtonDisabled = true
    this.editButtonDisabled = false
    this.deleteButtonDisabled = false
  }
  
}
