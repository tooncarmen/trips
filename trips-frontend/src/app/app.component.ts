import {Component, ViewChild} from '@angular/core';
import {MdDialog, MdDialogRef, MdSidenav} from '@angular/material';
import {LoginDialogComponent} from "./login/login.component";
import {NavigationComponent} from "./navigation/navigation.component";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Homepage';
  @ViewChild('app-navigation') public myNav: NavigationComponent;

  constructor(public dialog: MdDialog) {}

  ShowLoginDialog() {
    const dialogRef = this.dialog.open(LoginDialogComponent, {
      // height: '200px',
      // width: '400px',
    });
  }


}
