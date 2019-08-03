import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClienteCreateComponent } from './cliente/cliente-create/cliente-create.component';
import { ClienteDetailComponent } from './cliente/cliente-detail/cliente-detail.component';
import { ClienteListComponent } from './cliente/cliente-list/cliente-list.component';
import { ClienteDeleteComponent } from './cliente/cliente-delete/cliente-delete.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ProfissionalListComponent } from './profissional/profissional-list/profissional-list.component';
import { ProfissionalCreateComponent } from './profissional/profissional-create/profissional-create.component';
import { ProfissionalDetailComponent } from './profissional/profissional-detail/profissional-detail.component';
import { ProfissionalDeleteComponent } from './profissional/profissional-delete/profissional-delete.component';
import { ClienteUpdateComponent } from './cliente/cliente-update/cliente-update.component';
import { PlanoUpdateComponent } from './plano/plano-update/plano-update.component';
import { PlanoListComponent} from './plano/plano-list/plano-list.component';
import { PlanoCreateComponent } from './plano/plano-create/plano-create.component';
import { PlanoDetailsComponent } from './plano/plano-details/plano-details.component';
import { ProfissionalUpdateComponent } from './profissional/profissional-update/profissional-update.component';
import { NavbarComponent } from './shared/navbar/navbar.component';
import { FooterComponent } from './shared/footer/footer.component';
import { HomeComponent } from './pages/home/home.component';
import { CardsComponent } from './shared/cards/cards.component';
import { SobreNosComponent } from './pages/sobre-nos/sobre-nos.component';
import { ContatoComponent } from './pages/contato/contato.component';
import { EncontreComponent } from './pages/encontre/encontre.component';
import { LoginComponent } from './pages/login/login.component';
import { AdminComponent } from './pages/admin/admin.component';
import { UsuarioComponent } from './pages/usuario/usuario.component';
import { AdminLoginComponent } from './admin/admin-login/admin-login.component';
import { AdminHomeComponent } from './admin/admin-home/admin-home.component';
import { EmailListComponent } from './pages/contato/email-list/email-list.component';
import { EmailDetailsComponent } from './pages/contato/email-details/email-details.component';




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
    ClienteUpdateComponent,
    PlanoUpdateComponent,
    PlanoListComponent,
    PlanoCreateComponent,
    PlanoDetailsComponent,
    ProfissionalUpdateComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    CardsComponent,
    SobreNosComponent,
    ContatoComponent,
    EncontreComponent,
    LoginComponent,
    AdminComponent,
    UsuarioComponent,

    AdminLoginComponent,
    AdminHomeComponent,
    EmailListComponent,
    EmailDetailsComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
