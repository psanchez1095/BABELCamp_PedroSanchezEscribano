import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { MainComponent } from './components/main/main.component';
import { FooterComponent } from './components/footer/footer.component';
import { MainLoginComponent } from './components/main-login/main-login.component';
import { MainAboutUsComponent } from './components/main-about-us/main-about-us.component';
import { MainContactComponent } from './components/main-contact/main-contact.component';
import { MainDetailGameComponent } from './components/main-detail-game/main-detail-game.component';

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
