class Game {
  public id: number;
  public titulo: string;
  public compania: string;
  public urlImg: string;
  public valoracionMedia: number;
  public descripcion: string;

  constructor(
    titulo: string,
    compania: string,
    valoracionMedia: number,
    id?: number, 
    urlImg? : string,
    descripcion? :string,

  ) {
    this.id = id ? id : 0;
    this.titulo = titulo;
    this.compania = compania;
    this.valoracionMedia = valoracionMedia;
    this.urlImg = urlImg ? urlImg : "../../assets/img/defaultUrlGame.png";
    this.descripcion = descripcion ? descripcion : "Descripción no disponible por el momento"
  }

  public getId(): number {
    return this.id;
  }
  public getTitulo(): string {
    return this.titulo;
  }
  public getCompania(): string {
    return this.compania;
  }
  public getValoracionMedia(): number {
    return this.valoracionMedia;
  }
  public getUrlImg(): string {
    return this.urlImg;
  }
  public getDescripcion(): string {
    return this.descripcion;
  }

  public setTitulo(titulo: string) {
    this.titulo = titulo;
  }
  public setCompania(comp: string) {
    this.compania = comp;
  }
  public setValoracionMedia(vmedia: number) {
    this.valoracionMedia = vmedia;
  }
  public setUrlImg(urlImg: string) {
    this.urlImg = urlImg;
  }
  public setDescripcion(desc: string) {
    this.descripcion = desc;
  }
}
export { Game };
