class Historial {
    constructor(golesAnotados, tarjetasA, tarjetasR, id) {
        this.id = id ? id : -1;
        this.golesAnotados = golesAnotados;
        this.tarjetasA = tarjetasA;
        this.tarjetasR = tarjetasR;
    }
    getGolesAnotados() {
        return this.golesAnotados;
    }
    getTarjetasA() {
        return this.tarjetasA;
    }
    getTarjetasR() {
        return this.tarjetasR;
    }
}
export { Historial };
