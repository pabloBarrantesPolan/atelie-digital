import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClienteCreateComponent } from './cliente/cliente-create/cliente-create.component';
import { ClienteDetailComponent } from './cliente/cliente-detail/cliente-detail.component';
import { ClienteListComponent } from './cliente/cliente-list/cliente-list.component';
import { ClienteDeleteComponent } from './cliente/cliente-delete/cliente-delete.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ProfissionalListComponent } from './profissional/profissional-list/profissional-list.component';
import { ProfissionalCreateComponent } from './profissional/profissional-create/profissional-create.component';
import { ProfissionalDetailComponent } from './profissional/profissional-detail/profissional-detail.component';
import { ProfissionalDeleteComponent } from './profissional/profissional-delete/profissional-delete.component';



@NgModule({
  declarations: [
    AppComponent,
    ClienteCreateComponent,
    ClienteDetailComponent,
    ClienteListComponent,
    ClienteDeleteComponent,
    ProfissionalListComponent,
    ProfissionalCreateComponent,
    ProfissionalDetailComponent,
    ProfissionalDeleteComponent,
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
