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
  
  urlIconUser: string= MainComponent.static_urlIconUser
  userEmail: string = MainComponent.static_userEmail
  constructor(route:ActivatedRoute) {
    
  }

  

}
