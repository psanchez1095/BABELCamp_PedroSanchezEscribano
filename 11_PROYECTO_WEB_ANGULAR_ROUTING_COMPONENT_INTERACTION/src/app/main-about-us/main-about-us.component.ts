import { Component} from '@angular/core';

@Component({
  selector: 'app-main-about-us',
  templateUrl: './main-about-us.component.html',
  styleUrls: ['./main-about-us.component.css']
})
export class MainAboutUsComponent {

  //Asignando valores al componente Footer
  currentBtnAboutUs: boolean = true;
  currentBtnContact: boolean = false;
  currentBtnLogin : boolean = false;

  constructor() { }

}
