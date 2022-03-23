import { Component} from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-main-detail-game',
  templateUrl: './main-detail-game.component.html',
  styleUrls: ['./main-detail-game.component.css']
})
export class MainDetailGameComponent  {
  titleUser:string ="User Info"
  titleDetailGame:string ="Detalles Juego"
  urlIconUser: string=""
  userEmail: string =""
  constructor(route:ActivatedRoute) {
    //Recogemos los datos enviados con route
    this.userEmail = route.snapshot.params["userEmail"]
    this.urlIconUser =  route.snapshot.params["urlIconStatus"]
  }

  

}
