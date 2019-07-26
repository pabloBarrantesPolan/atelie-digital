
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClienteListComponent} from './cliente/cliente-list/cliente-list.component';
import { ClienteCreateComponent} from './cliente/cliente-create/cliente-create.component';
import { ClienteDetailComponent} from './cliente/cliente-detail/cliente-detail.component';



const routes: Routes = [
  {path: '', redirectTo: '/clientes', pathMatch: 'full'},
  {path: 'clientes', component: ClienteListComponent},
  {path: 'adicionar', component: ClienteCreateComponent},
  {path: 'detalhe/:id', component: ClienteDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
