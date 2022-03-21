import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent  {
  public titulo : string ="Videogames App"
  public urlTitleImg : string ="../../assets/img/headerImages/iconGB.png"
  public urlheader1Img : string ="../../assets/img/headerImages/meristation.jpg"
  public urlheader2Img : string ="../../assets/img/headerImages/3dJuegos.png"
  constructor() { }

 

}
