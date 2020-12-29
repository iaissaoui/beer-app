import { BrowserModule } from '@angular/platform-browser';
import { APP_INITIALIZER, NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BeerListComponent } from './beer-list/beer-list.component';
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';
import { environment } from 'src/environments/environment';
import { BeerComponent } from './shared/beer/beer.component';
import { AppMaterialModule } from './app-material/app-material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppHomeComponent } from './app-home/app-home.component';
import { BeerRandomComponent } from './beer-random/beer-random.component';
import { BeerKnownComponent } from './beer-known/beer-known.component';


function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: environment.auth,
        realm: 'beer-realm',
        clientId: 'beer-front-app',
      },
      initOptions: {
        onLoad: 'login-required',
        checkLoginIframe: false
      },
    });
  }


@NgModule({
  declarations: [
    AppComponent,
    BeerListComponent,
    BeerComponent,
    AppHomeComponent,
    BeerRandomComponent,
    BeerKnownComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    KeycloakAngularModule,
    AppMaterialModule,
    BrowserAnimationsModule
  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService],
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
