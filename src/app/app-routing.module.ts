import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ArticoliComponent } from './components/articoli/articoli.component';
import { HomeComponent } from './components/home/home.component';
import { OrdiniComponent } from './components/ordini/ordini.component';
import { TariffeComponent } from './components/tariffe/tariffe.component';

const routes: Routes = [
  { path: 'articoli', component: ArticoliComponent },
  { path: 'ordini', component: OrdiniComponent },
  { path: 'tariffe', component: TariffeComponent },
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
