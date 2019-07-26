import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component, ComponentDecorator } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClienteCreateComponent } from './cliente/cliente-create/cliente-create.component';
import { ClienteDetailComponent } from './cliente/cliente-detail/cliente-detail.component';
import { ClienteListComponent } from './cliente/cliente-list/cliente-list.component';
import { ClienteDeleteComponent } from './cliente/cliente-delete/cliente-delete.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [
    AppComponent,
    ClienteCreateComponent,
    ClienteDetailComponent,
    ClienteListComponent,
    ClienteDeleteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
