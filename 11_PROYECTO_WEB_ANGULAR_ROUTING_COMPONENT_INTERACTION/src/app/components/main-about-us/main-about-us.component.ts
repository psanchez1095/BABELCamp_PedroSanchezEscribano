import { Component} from '@angular/core';

@Component({
  selector: 'app-main-about-us',
  templateUrl: './main-about-us.component.html',
  styleUrls: ['./main-about-us.component.css']
})
export class MainAboutUsComponent {

  //Asignando valores al componente Footer
  currentBtnBack: boolean = false;
  currentBtnAboutUs: boolean = true;
  currentBtnContact: boolean = false;
  currentBtnLogin : boolean = false;

  //Property Binding
  titleAboutUs:string = "¿Quiénes somos?"
  textAboutUs:string ="VideoGames App es una empresa con sede en el planeta babelian. Nuestro principal objetivo es conservar el patrimonio humano de juegos a través de la divulgación de noticias acerca de los videojuegos. "
  textAboutUsCont:string ="Nuestros empleados son amantes de los videojuegos y su historia "
  urlImgGameConsole : string ="../../assets/img/icon_gameconsole.png"
  urlImgAccesory : string ="../../assets/img/icon_accessory.png"
  urlImgGame: string ="../../assets/img/icon_cd.png"
  constructor() { }

}
