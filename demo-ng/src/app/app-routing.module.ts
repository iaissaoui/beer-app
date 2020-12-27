import { AppHomeComponent } from './app-home/app-home.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BeerListComponent } from './beer-list/beer-list.component';
import { BeerComponent } from './beer/beer.component';

const routes: Routes = [
  { path: '', component: AppHomeComponent, pathMatch: 'full' },
  { path: 'beers', component: BeerListComponent, pathMatch: 'full' },
  { path: 'beers/:id', component: BeerComponent, pathMatch: 'full' }
  // { path:"**", component: ErrorComponent }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
