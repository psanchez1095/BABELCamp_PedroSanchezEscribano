import {Jugador} from './jugador.js';

class Equipo {
    public id: number;
    public nombre: string;
    public fechaFund: string;
    public jugadores: Array<Jugador>;
  
    constructor(nombre: string, fechaFund: string, jugadores:Array<Jugador>,id?: number) {
      this.id = id ? id : -1;
      this.nombre = nombre;
      this.fechaFund = fechaFund;
      this.jugadores = jugadores;
    }
  
    public getNombre(): string {
      return this.nombre ;
    }
    public getFechaFund(): string {
        return this.fechaFund ;
    }
    public getJugadores(): Array<Jugador> {
        return this.jugadores ;
    }
     
  }

  export {Equipo} ;