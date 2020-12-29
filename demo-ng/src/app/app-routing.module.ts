import { BeerKnownComponent } from './beer-known/beer-known.component';
import { BeerRandomComponent } from './beer-random/beer-random.component';
import { AppHomeComponent } from './app-home/app-home.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BeerListComponent } from './beer-list/beer-list.component';

const routes: Routes = [
  { path: '', component: AppHomeComponent, pathMatch: 'full' },
  { path: 'beers', component: BeerListComponent, pathMatch: 'full' },
  { path: 'beers/random', component: BeerRandomComponent, pathMatch: 'full' },
  { path: 'beers/:id', component: BeerKnownComponent, pathMatch: 'full' }
  // { path:"**", component: ErrorComponent }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
