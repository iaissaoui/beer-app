import { KeycloakService } from 'keycloak-angular';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'demo-ng';

  constructor(private keycloakService:KeycloakService){

  }

  logout() {
    this.keycloakService.logout();
  }

}
