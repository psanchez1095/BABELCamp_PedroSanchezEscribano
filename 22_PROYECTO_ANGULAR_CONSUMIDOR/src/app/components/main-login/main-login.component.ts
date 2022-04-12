import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Game } from '../../entities/game';
import { User } from '../../entities/user';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
@Component({
  selector: 'app-main-login',
  templateUrl: './main-login.component.html',
  styleUrls: ['./main-login.component.css']
})

export class MainLoginComponent {
  //Hacemos que el atributo sea solo de lectura
  readonly endPoint = 'http://localhost:8080'
  //Array Usuarios
  users : Array<User> = []
  mapUserPswd : Map<string,string> = new Map<string,string>()

  //Property Binding
  mainTitle: string = 'Login';
  infoTitle: string = 'Información';
  infoText : string = "Para acceder a Videogames App debe loguearse con un usuario y contraseña previamente registrados. En el caso de que haya algun error se notificará al usuario"
  infoFormatLogin : string = "El usuario podra loguearse con su email o correo electrónico y su contraseña"
  userEmail : string = ""
  password :  string = ""
  urlBtnPassword : string = "../../assets/img/eye.png"
  typeBtnPassword : string = "password"
  //Placeholders
  placeholderUserEmail: string = 'Correo / Nombre de Usuario';
  placeholderContrasenia: string = 'Contraseña';

  //Errors
  errorMessage: string = '';
  error: boolean = true;
  pswdVisible: boolean = false
  
  constructor(private router:Router,private _httpClient : HttpClient) {
    
    let user1 = new User("pedro@gmail.com","app10101")
    this.mapUserPswd.set(user1.getUserEmail(),user1.getPassword())
    this.users.push(user1)
    user1 = new User("prueba@gmail.com","prueba10101",User.urlIconSilver,1)
    this.mapUserPswd.set(user1.getUserEmail(),user1.getPassword())
    this.users.push(user1)
    user1 = new User("pedro","pswd11",User.urlIconGold,2)
    this.mapUserPswd.set(user1.getUserEmail(),user1.getPassword())
    this.users.push(user1)
    user1 = new User("babel","babel01",User.urlIconGold,2)
    this.mapUserPswd.set(user1.getUserEmail(),user1.getPassword())
    this.users.push(user1)

    //USUARIOS BASE DE DATOS
    /**
     * pedro
     * pswd11
     */
  }
  
    /**
     *  USUARIOS BASE DE DATOS
     *  usuario : pedro
     *  contraseña : pswd11
     */

  /**
   * @author Pedro Sanchez Escribano
   * Método que realiza el proceso de login con los datos introducidos por el usuario.
   * En caso de error se mostrará un mensaje de error
   */
  async login(){
    await fetch(`http://localhost:8080/20_PROYECTO_JAVA_MAVEN_SERVICIO_WEB/usuarios/login?nombre=${this.userEmail}&password=${this.password}`,{mode: 'cors'})
    .then(v => v.json())
    .then(v => {
      if(JSON.parse(v.validado)){
        let user = null;
        for(let x in this.users){
            if(this.users[x].getUserEmail() === this.userEmail && this.users[x].getPassword() === this.password ) user = this.users[x]
        }
        this.router.navigate(["/index",user?.getUserEmail(),user?.getUrlIconStatus(),user?.getId()])
      }else {
        setTimeout(() => {
          this.error=false
          this.errorMessage="La contraseña no coincide, revísela"
          this.error=true
        }, 2000);
      }
    });

      /*this._httpClient.get(this.endPoint+'/usuarios/login?nombre=pedro&password=pswd1')
      .subscribe(respuesta => {//'respuesta' es un objeto Json que contiene el body
        console.log(respuesta);
      });*/
        //Si el correo o nombre de usuario no se corresponde con ninguno de los usuarios registrados
        /*if(!this.mapUserPswd.has(this.userEmail)){

            this.error=false
            this.errorMessage="El usuario no existe, revise el correo o nombre de usuario"

            setTimeout(() => {
              this.error=true
            }, 2000);
        }
        else{

          if(this.mapUserPswd.get(this.userEmail)!=this.password){
            this.error=false
            this.errorMessage="La contraseña no coincide, revísela"

            setTimeout(() => {
              this.error=true
            }, 2000);
              
          }

          else{
            let user = null;
            for(let x in this.users){
                if(this.users[x].getUserEmail() === this.userEmail && this.users[x].getPassword() === this.password ) user = this.users[x]
            }
            this.router.navigate(["/index",user?.getUserEmail(),user?.getUrlIconStatus(),user?.getId()])
          }
         

        }
         */
  }

  /**
   * @author Pedro Sanchez Escribano
   * Método que se encarga de ocultar o mostrar la contraseña.
   * El usuario invoca el metodo pulsando el botón del ojo(abierto / cerrado )
   */
  public showPassword(){

      if(this.pswdVisible) {
        this.typeBtnPassword="password"
        this.urlBtnPassword = "../../assets/img/eye.png"
        this.pswdVisible = false;
      }
      else{
        this.typeBtnPassword="text"
        this.urlBtnPassword = "../../assets/img/closeEye.png"
        this.pswdVisible = true;
      }
  }

}
