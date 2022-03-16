class Jugador {
    constructor(nombre, edad, pais, id) {
        this.id = id ? id : -1;
        this.nombre = nombre;
        this.edad = edad;
        this.pais = pais;
    }
    getNombre() {
        return this.nombre;
    }
}
export { Jugador };
