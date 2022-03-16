class Equipo {
    constructor(nombre, fechaFund, jugadores, id) {
        this.id = id ? id : -1;
        this.nombre = nombre;
        this.fechaFund = fechaFund;
        this.jugadores = jugadores;
    }
    getNombre() {
        return this.nombre;
    }
}
export { Jugador } from 'ts_js/jugador.js';
