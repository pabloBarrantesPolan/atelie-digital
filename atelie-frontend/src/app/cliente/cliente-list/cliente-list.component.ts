import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../cliente';
import { ClienteService } from '../cliente.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cliente-list',
  templateUrl: './cliente-list.component.html',
  styleUrls: ['./cliente-list.component.css']
})
export class ClienteListComponent implements OnInit {

  clientes: Observable<Cliente[]>;
  constructor(private clienteService: ClienteService, private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }
  reloadData() {
    this.clientes = this.clienteService.getClientes();
  }

  deleteCliente(id: number) {
    this.clienteService.deleteCliente(id).subscribe(
      data => {
        console.log(data);
        this.reloadData();
      }, error => console.log(error)
    );
  }

  clienteDetails(id: number) {
    this.router.navigate(['cliente/detalhe', id]);
  }

}
