class Jugador {
    constructor(nombre, edad, pais, historial, urlImg, id) {
        this.id = id ? id : -1;
        this.nombre = nombre;
        this.edad = edad;
        this.pais = pais;
        this.historial = historial;
        this.urlImg = urlImg;
    }
    getNombre() {
        return this.nombre;
    }
    getEdad() {
        return this.nombre;
    }
    getPais() {
        return this.nombre;
    }
    getHistorial() {
        return this.nombre;
    }
    getUrlImg() {
        return this.urlImg;
    }
}
export { Jugador };
