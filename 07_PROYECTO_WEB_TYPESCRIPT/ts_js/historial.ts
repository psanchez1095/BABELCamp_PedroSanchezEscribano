class Historial {
    public id: number;
    public golesAnotados: number;
    public tarjetasA: number;
    public tarjetasR: number;
  
  
    constructor(golesAnotados: number, tarjetasA: number, tarjetasR: number, id?: number) {
      this.id = id ? id : -1;
      this.golesAnotados = golesAnotados;
      this.tarjetasA = tarjetasA;
      this.tarjetasR = tarjetasR;
    }
  
    public getGolesAnotados(): number {
      return this.golesAnotados ;
    }
    public getTarjetasA(): number {
      return this.tarjetasA ;
    }
    public getTarjetasR(): number {
      return this.tarjetasR ;
    }
  }

  export {Historial}