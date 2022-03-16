class Jugador {
    constructor(nombre, edad, pais, historial, id) {
        this.id = id ? id : -1;
        this.nombre = nombre;
        this.edad = edad;
        this.pais = pais;
        this.historial = historial;
    }
    getNombre() {
        return this.nombre;
    }
}
export { Jugador };
