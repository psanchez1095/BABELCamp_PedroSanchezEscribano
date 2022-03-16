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
    getFechaFund() {
        return this.fechaFund;
    }
    getJugadores() {
        return this.jugadores;
    }
}
export { Equipo };
