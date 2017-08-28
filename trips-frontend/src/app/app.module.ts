import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {
  MdButtonModule, MdCardModule, MdChipsModule, MdDialogModule, MdIconModule, MdIconRegistry, MdInputModule, MdListModule, MdSidenavModule,
  MdSnackBar,
  MdSnackBarModule,
  MdTabsModule,
  MdToolbarModule, MdTooltipModule
} from "@angular/material";
import {LoginDialogComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {NavigationComponent} from './navigation/navigation.component';
import {RouterRoutingModule} from "./router/router-routing.module";
import {HomeComponent} from './home/home.component';
import {MakeTripsComponent} from './make-trips/make-trips.component';
import {ListTripsComponent} from './list-trips/list-trips.component';
import {UserService} from "./services/user.service";
import {HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";
import { AgmCoreModule } from '@agm/core';
import {TripService} from "./services/trip.service";
import { TripDetailComponent } from './trip-detail/trip-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginDialogComponent,
    RegisterComponent,
    NavigationComponent,
    HomeComponent,
    MakeTripsComponent,
    ListTripsComponent,
    TripDetailComponent
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    RouterRoutingModule,
    HttpModule,
    FormsModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyC_-ntyaDr1eekW8m3MSgqAMUjvcdP_tvg'
    }),
    MdToolbarModule,
    MdCardModule,
    MdInputModule,
    MdButtonModule,
    MdDialogModule,
    MdListModule,
    MdSidenavModule,
    MdIconModule,
    MdTabsModule,
    MdChipsModule,
    MdButtonModule,
    MdTooltipModule,
    MdSnackBarModule
  ],
  providers: [UserService,TripService, MdIconRegistry],
  bootstrap: [AppComponent, NavigationComponent],
  entryComponents: [LoginDialogComponent]
})
export class AppModule {

}
