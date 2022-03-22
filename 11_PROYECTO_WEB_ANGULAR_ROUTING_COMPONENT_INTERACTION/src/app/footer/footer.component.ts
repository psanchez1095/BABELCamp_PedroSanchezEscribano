import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})


export class FooterComponent {
  urlImgContact : string = "../../assets/img/icon_contact.png"
  urlImgInfo :  string = "../../assets/img/icon_info.png"
  constructor() { }

}
