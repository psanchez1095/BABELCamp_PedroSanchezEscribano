class Historial {
    constructor(golesAnotados, TarjetasA, TarjetasR, id) {
        this.id = id ? id : -1;
        this.golesAnotados = golesAnotados;
        this.TarjetasA = TarjetasA;
        this.TarjetasR = TarjetasR;
    }
    getGolesAnotados() {
        return this.golesAnotados;
    }
}
export { Historial };
