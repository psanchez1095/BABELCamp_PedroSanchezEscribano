class Game {

    public id: number;
    public titulo: string;
    public compañia: string;
    public valoracionMedia: number;
    public urlImg: string;
  
    constructor(titulo: string, compañia: string, valoracionMedia: number,urlImg:string,id?: number) {
        
      this.id = id ? id : -1;
      this.titulo = titulo;
      this.compañia = compañia;
      this.valoracionMedia = valoracionMedia;
      this.urlImg = urlImg;
    }
  
    public getTitulo(): string {
      return this.titulo ;
    }
    public getCompañia(): string {
        return this.compañia ;
    }
    public getValoracionMedia(): number {
        return this.valoracionMedia ;
    }
    public getUrlImg(): string {
        return this.urlImg ;
    }
    
  }
  export{Game}