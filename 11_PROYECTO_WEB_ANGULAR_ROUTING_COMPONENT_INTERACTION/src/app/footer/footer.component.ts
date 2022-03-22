import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})


export class FooterComponent {
  urlImgContact : string = "../../assets/img/icon_contact.png"
  urlImgInfo :  string = "../../assets/img/icon_info.png"
  constructor(private router:Router) { }

  public navigateAboutUs(){
    console.log("w32eqwewq")
    this.router.navigate(["aboutUs"])
  }
  public navigateContact(){
    this.router.navigate(["contact"])
  }

}
