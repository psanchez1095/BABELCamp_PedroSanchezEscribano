import { Component } from '@angular/core';

@Component({
  selector: 'app-main-contact',
  templateUrl: './main-contact.component.html',
  styleUrls: ['./main-contact.component.css']
})
export class MainContactComponent{
  
   //Asignando valores al componente Footer
  currentBtnBack = false;
  currentBtnLogin:boolean = false;
  currentBtnAboutUs: boolean = false;
  currentBtnContact: boolean = true;

  //Property Binding
  ciudad : string ="Madrid"
  correo:string ="appGames@gmail.com"
  telefono:string ="666666666"
  urlImgMail : string = "../../assets/img/mainContactImages/email.png"
  urlImgPhone : string = "../../assets/img/mainContactImages/phone.png"
  urlImgCity : string = "../../assets/img/mainContactImages/city.png"
  urlImgGameConsole : string ="../../assets/img/icon_gameconsole.png"
  urlImgAccesory : string ="../../assets/img/icon_accessory.png"
  urlImgGame: string ="../../assets/img/icon_cd.png"
  
  constructor() { }

}
