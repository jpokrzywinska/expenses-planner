import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {ExpensesComponent} from './component/expenses/expenses.component';
import {RouterModule, Routes} from "@angular/router";
import {AppComponent} from "./app.component";
import { HomeComponent } from './component/home/home.component';
import { TextInputComponent } from './component/common/text-input/text-input.component';
import { ButtonComponent } from './component/common/button/button.component';

const appRoutes: Routes = [
  {path: 'expenses', component: ExpensesComponent, pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'}
]

@NgModule({
  declarations: [
    ExpensesComponent,
    AppComponent,
    HomeComponent,
    TextInputComponent,
    ButtonComponent,
  ],
  imports: [
    RouterModule.forRoot(appRoutes, {
      enableTracing: true,
      useHash: true
    }),
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
