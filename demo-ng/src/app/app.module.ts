import { BrowserModule } from '@angular/platform-browser';
import { APP_INITIALIZER, NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BeerListComponent } from './beer-list/beer-list.component';
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';
import { environment } from 'src/environments/environment';


function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: environment.auth,
        realm: 'beer-realm',
        clientId: 'beer-front-app',
      },
      initOptions: {
        // onLoad: 'login-required',
        // checkLoginIframe: false
        onLoad: 'login-required',
        checkLoginIframe: false,
         silentCheckSsoRedirectUri:
          window.location.origin + '/assets/silent-check-sso.html'
      },
    });
  }


@NgModule({
  declarations: [
    AppComponent,
    BeerListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    KeycloakAngularModule
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
