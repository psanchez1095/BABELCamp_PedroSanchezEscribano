import {Historial} from './historial.js'

class Jugador {
    public id: number;
    public nombre: string;
    public edad: number;
    public pais: string;
    public urlImg: string;
    public historial : Historial;
  
    constructor(nombre: string, edad: number, pais: string, historial:Historial ,urlImg:string,id?: number) {
      this.id = id ? id : -1;
      this.nombre = nombre;
      this.edad = edad;
      this.pais = pais;
      this.historial = historial;
      this.urlImg = urlImg;
    }
  
    public getNombre(): string {
      return this.nombre ;
    }
    public getEdad(): string {
        return this.nombre ;
    }
    public getPais(): string {
        return this.nombre ;
    }
    public getHistorial(): string {
        return this.nombre ;
    }
    public getUrlImg(): string {
        return this.urlImg ;
    }
  }

  export {Jugador}