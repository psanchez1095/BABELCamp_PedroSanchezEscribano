import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})


export class FooterComponent {

  urlImgLogin :  string = "../../assets/img/icon_logout.png"
  urlImgContact : string = "../../assets/img/icon_contact.png"
  urlImgInfo :  string = "../../assets/img/icon_info.png"
  
  //Compartiendo información entre componentes
  @Input()  showBtnLogin:   boolean = false
  @Input()  showBtnAboutUs: boolean =false
  @Input()  showBtnContact: boolean = false
 
  constructor(private router:Router) {}
  
  /**
   * Metodo que navega al indice de la aplicación web
   */
  public navigateIndex(){
    this.router.navigate(["/"])
  }

   /**
   * Metodo que navega a la página AboutUs
   */
  public navigateAboutUs(){
    this.router.navigate(["aboutUs"])
  }
  /**
   * Metodo que navega a la página de información de contacto
   */
  public navigateContact(){
    this.router.navigate(["contact"])
  }

}
