class Equipo {
    constructor(nombre, fechaFund, id) {
        this.id = id ? id : -1;
        this.nombre = nombre;
        this.fechaFund = fechaFund;
    }
    getNombre() {
        return this.nombre;
    }
}
export { Equipo };
