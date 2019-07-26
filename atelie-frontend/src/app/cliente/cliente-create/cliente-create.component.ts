import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ClienteService } from '../cliente.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cliente-create',
  templateUrl: './cliente-create.component.html',
  styleUrls: ['./cliente-create.component.css']
})
export class ClienteCreateComponent implements OnInit {

  cliente: Cliente = new Cliente();
  submitted = false;

  constructor(private clienteService: ClienteService, private router: Router) { }

  ngOnInit() {
  }

  newPessoa(): void {
    this.submitted = false;
    this.cliente = new Cliente();
  }

  save() {
    this.clienteService.createCliente(this.cliente)
    .subscribe(
      data => console.log(data),
      error => console.log(error)
    );
    this.cliente = new Cliente();
    this.gotoList();
  }

  onSubmit() {
    console.log(this.cliente);
    this.submitted = true;
    this.save();
  }

  gotoList() {
    setTimeout(() => {
      this.router.navigate(['/clientes']);
    }, 1500);

  }

}
