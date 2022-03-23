import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { MainComponent } from './main/main.component';
import { FooterComponent } from './footer/footer.component';
import { MainLoginComponent } from './main-login/main-login.component';
import { MainAboutUsComponent } from './main-about-us/main-about-us.component';
import { MainContactComponent } from './main-contact/main-contact.component';
import { MainDetailGameComponent } from './main-detail-game/main-detail-game.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    MainComponent,
    FooterComponent,
    MainLoginComponent,
    MainAboutUsComponent,
    MainContactComponent,
    MainDetailGameComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
