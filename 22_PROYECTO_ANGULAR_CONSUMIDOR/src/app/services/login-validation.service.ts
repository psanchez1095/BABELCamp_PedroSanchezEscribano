import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class LoginValidationService {

  readonly endPoint = 'http://localhost:8080/20_PROYECTO_JAVA_MAVEN_SERVICIO_WEB/usuarios/login'

  constructor(private _httpClient : HttpClient) {

   }

   /**
    *
    * Método que consume el servicio web de validacíon de usuario mediante una peticion GET
    * @author Pedro Sanchez Escribano
    * @param user nombre de usuario de tipo String
    * @param password contraseña del usuario de tipo String
    */
   public login(user:String,password:String):Observable<any>{
    return this._httpClient.get<any>(`${this.endPoint}?nombre=${user}&password=${password}`) .pipe(catchError(this.manejarError))
  }

  /**
   * Metodo que maneja los posibles errores de las llamadas al servicio rest
   * @param error 
   * @returns 
   */
   private manejarError(e: HttpErrorResponse){
    let mensajeError = ''
    if (e.error instanceof ErrorEvent) {
      mensajeError = 'A ocurrido un error:' + e.error
    } else {
      mensajeError = `El servicio Rest retorno: Status: ${e.status}, ` +
            `Body: ${e.error}`
    }
    console.error(mensajeError)
    return throwError(() => new Error(mensajeError));
  }
}
