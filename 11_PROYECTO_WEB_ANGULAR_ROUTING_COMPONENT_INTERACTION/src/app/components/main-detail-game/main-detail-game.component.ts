import { Component} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MainComponent } from '../main/main.component';

@Component({
  selector: 'app-main-detail-game',
  templateUrl: './main-detail-game.component.html',
  styleUrls: ['./main-detail-game.component.css']
})
export class MainDetailGameComponent  {

  titleUser:string ="User Info"
  titleDetailGame:string ="Detalles Juego"

  
  titleGame:string ="";
  companiaGame:string ="";
  urlImgGame:string=""
  descriptionGame:string =""
  valoracionMediaGame:string=""

  urlIconUser: string= MainComponent.static_urlIconUser
  
  userEmail: string = MainComponent.static_userEmail
  constructor(route:ActivatedRoute) {
    this.titleGame = route.snapshot.params["title"]
    this.companiaGame = route.snapshot.params["compania"]
    this.urlImgGame = route.snapshot.params["urlImg"]
    this.valoracionMediaGame = route.snapshot.params["vMedia"]
    this.descriptionGame = route.snapshot.params["desc"]

  }

  

}
