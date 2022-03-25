import {Jugador} from './jugador.js';

class Equipo {
    private id: number;
    private nombre: string;
    private fechaFund: string;
    private jugadores: Array<Jugador>;
  
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