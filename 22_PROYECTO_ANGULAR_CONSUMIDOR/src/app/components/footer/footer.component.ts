import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { MainComponent } from '../main/main.component';
@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})


export class FooterComponent {

  urlImgBack :  string = "../../assets/img/footerImages/icon_back.png"
  urlImgLogin :  string = "../../assets/img//footerImages/icon_logout.png"
  urlImgContact : string = "../../assets/img/footerImages/icon_contact.png"
  urlImgInfo :  string = "../../assets/img/footerImages/icon_info.png"
  userEmail : string = ""
  //Compartiendo información entre componentes
  @Input()  showBtnBack:   boolean = false
  @Input()  showBtnLogin:   boolean = false
  @Input()  showBtnAboutUs: boolean =false
  @Input()  showBtnContact: boolean = false
  @Input()  userEmailInput: string = ""
  @Input()  urlImgUser: string = ""
 
  constructor(private router:Router) {}
  
  public navigateMain(){
    this.router.navigate(["/index",MainComponent.static_userEmail,MainComponent.static_urlIconUser,MainComponent.static_userId])
  }
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
