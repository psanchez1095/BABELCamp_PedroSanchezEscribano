class Equipo {
    public id: number;
    public nombre: string;
    public fechaFund: string;
  
  
    constructor(nombre: string, fechaFund: string, id?: number) {
      this.id = id ? id : -1;
      this.nombre = nombre;
      this.fechaFund = fechaFund;
    }
  
    public getNombre(): string {
      return this.nombre ;
    }
  }

  export {Equipo}