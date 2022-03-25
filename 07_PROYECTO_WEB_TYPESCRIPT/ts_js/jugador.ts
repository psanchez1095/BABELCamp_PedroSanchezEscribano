import {Historial} from './historial.js'

class Jugador {
  
    private id: number;
    private nombre: string;
    private edad: number;
    private pais: string;
    private urlImg: string;
    private historial : Historial;
  
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
    public getEdad(): number {
        return this.edad ;
    }
    public getPais(): string {
        return this.pais ;
    }
    public getHistorial(): Historial {
        return this.historial ;
    }
    public getUrlImg(): string {
        return this.urlImg ;
    }
  }

  export {Jugador}