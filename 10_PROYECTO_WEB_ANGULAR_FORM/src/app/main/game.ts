class Game {

    public id: number;
    public titulo: string;
    public compania: string;
    public valoracionMedia: number;
   
    constructor(titulo: string, compania: string, valoracionMedia: number,id?: number) {
        
      this.id = id ? id : 0;
      this.titulo = titulo;
      this.compania = compania;
      this.valoracionMedia = valoracionMedia;
    }
  
    public getId(): number {
      return this.id;
  }
    public getTitulo(): string {
      return this.titulo ;
    }
    public getCompania(): string {
        return this.compania ;
    }
    public getValoracionMedia(): number {
        return this.valoracionMedia ;
    }

    public setTitulo(titulo:string) {
      this.titulo=titulo ;
    }
    public setCompania(comp:string){
      this.compania=comp;
    }
    public setValoracionMedia(vmedia:number) {
      this.valoracionMedia=vmedia;
    }
   
    
  }
  export{Game}
