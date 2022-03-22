import { Component } from '@angular/core';

@Component({
  selector: 'app-main-contact',
  templateUrl: './main-contact.component.html',
  styleUrls: ['./main-contact.component.css']
})
export class MainContactComponent{
  
   //Asignando valores al componente Footer
  currentBtnLogin:boolean = false;
  currentBtnAboutUs: boolean = false;
  currentBtnContact: boolean = true;
  
  constructor() { }

}
