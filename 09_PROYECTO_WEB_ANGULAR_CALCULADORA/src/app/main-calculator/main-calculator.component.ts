import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main-calculator',
  templateUrl: './main-calculator.component.html',
  styleUrls: ['./main-calculator.component.css'],
})
export class MainCalculatorComponent {

  public textScreen: string = 'Screen';
  public n1: string = '';
  public n2: string = '';
  public mensajeOculto = true;
  public mensaje: string = '';

  constructor() { }

  public add() {
    //If para asegurar que ambos números introducidos son numeros y no estan vacios
    if (this.n1 != '' && this.n2 != '' &&!isNaN(parseInt(this.n1)) && !isNaN(parseInt(this.n2))) {
      this.textScreen = (parseInt(this.n1) + parseInt(this.n2)).toString();
    } else {
      this.mensaje = 'Debe introducir dos números';
      this.mensajeOculto = false;
      setTimeout(() => {
        this.mensajeOculto = true;
      }, 1500);
    }
  }
  public subtraction() {
    if (this.n1 != '' && this.n2 != '' &&!isNaN(parseInt(this.n1)) && !isNaN(parseInt(this.n2))) {
      this.textScreen = (parseInt(this.n1) - parseInt(this.n2)).toString();
    } else {
      this.mensaje = 'Debe introducir dos números';
      this.mensajeOculto = false;
      setTimeout(() => {
        this.mensajeOculto = true;
      }, 1500);
    }
  }
  public multiplication() {
    if (this.n1 != '' && this.n2 != '' &&!isNaN(parseInt(this.n1)) && !isNaN(parseInt(this.n2))) {
      this.textScreen = (parseInt(this.n1) * parseInt(this.n2)).toString();
    } else {
      this.mensaje = 'Debe introducir dos números';
      this.mensajeOculto = false;
      setTimeout(() => {
        this.mensajeOculto = true;
      }, 1500);
    }
  }

  public division() {
    if (this.n1 != '' && this.n2 != '' &&!isNaN(parseInt(this.n1)) && !isNaN(parseInt(this.n2))) {
      this.textScreen = (parseInt(this.n1) / parseInt(this.n2)).toString();
    } else {
      this.mensaje = 'Debe introducir dos números';
      this.mensajeOculto = false;
      setTimeout(() => {
        this.mensajeOculto = true;
      }, 1500);
    }
  }
}
