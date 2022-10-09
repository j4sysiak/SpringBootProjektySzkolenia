import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NgforofDemoComponent } from './components/ngforof-demo/ngforof-demo.component';
import { NgswitchDemoComponent } from './components/ngswitch-demo/ngswitch-demo.component';
import { CustommDirectiveDemoComponent } from './components/customm-directive-demo/customm-directive-demo.component';
import { BoxDirective } from './directives/box.directive';

@NgModule({
  declarations: [
    AppComponent,
    NgforofDemoComponent,
    NgswitchDemoComponent,
    CustommDirectiveDemoComponent,
    BoxDirective
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
