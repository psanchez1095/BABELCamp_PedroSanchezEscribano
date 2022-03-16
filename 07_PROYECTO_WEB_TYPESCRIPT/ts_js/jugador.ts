class Jugador {
    public id: number;
    public nombre: string;
    public edad: string;
    public pais: string;
  
  
    constructor(nombre: string, edad: string, pais: string, id?: number) {
      this.id = id ? id : -1;
      this.nombre = nombre;
      this.edad = edad;
      this.pais = pais;
    }
  
    public getNombre(): string {
      return this.nombre ;
    }
  }

  export {Jugador}