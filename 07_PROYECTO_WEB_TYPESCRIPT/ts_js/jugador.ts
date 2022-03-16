import {Historial} from './historial.js'

class Jugador {
    public id: number;
    public nombre: string;
    public edad: string;
    public pais: string;
    public historial : Historial;
  
    constructor(nombre: string, edad: string, pais: string, historial:Historial ,id?: number) {
      this.id = id ? id : -1;
      this.nombre = nombre;
      this.edad = edad;
      this.pais = pais;
      this.historial = historial;
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
  }

  export {Jugador}