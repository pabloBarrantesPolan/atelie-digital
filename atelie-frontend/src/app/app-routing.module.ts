
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClienteListComponent} from './cliente/cliente-list/cliente-list.component';
import { ClienteCreateComponent} from './cliente/cliente-create/cliente-create.component';
import { ClienteDetailComponent} from './cliente/cliente-detail/cliente-detail.component';
import { ProfissionalListComponent } from './profissional/profissional-list/profissional-list.component';
import { ProfissionalCreateComponent } from './profissional/profissional-create/profissional-create.component';
import { ProfissionalDetailComponent } from './profissional/profissional-detail/profissional-detail.component';
import { EmpresaListComponent } from './empresa/empresa-list/empresa-list.component';
import { EmpresaCreateComponent } from './empresa/empresa-create/empresa-create.component';
import { EmpresaDetailComponent } from './empresa/empresa-detail/empresa-detail.component';
import { ClienteUpdateComponent } from './cliente/cliente-update/cliente-update.component';
import { EmpresaUpdateComponent } from './empresa/empresa-update/empresa-update.component';



const routes: Routes = [
  {path: '', redirectTo: '/clientes', pathMatch: 'full'},
  {path: 'clientes', component: ClienteListComponent},
  {path: 'clientes/adicionar', component: ClienteCreateComponent},
  {path: 'cliente/modificar/:id', component: ClienteUpdateComponent},
  {path: 'cliente/detalhe/:id', component: ClienteDetailComponent},
  {path: 'profissionais', component: ProfissionalListComponent},
  {path: 'profissionais/adicionar', component: ProfissionalCreateComponent},
  {path: 'profissionais/detalhe/:id', component: ProfissionalDetailComponent},
  {path: 'empresas', component: EmpresaListComponent},
  {path: 'empresas/adicionar', component: EmpresaCreateComponent},
  {path: 'empresas/detalhe/:id', component: EmpresaDetailComponent},
  {path: 'empresas/modificar/:id', component: EmpresaUpdateComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
