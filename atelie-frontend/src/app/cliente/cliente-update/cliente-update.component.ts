import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../cliente.service';
import { Cliente } from '../cliente';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpParams, HttpClient } from '@angular/common/http';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-cliente-update',
  templateUrl: './cliente-update.component.html',
  styleUrls: ['./cliente-update.component.css']
})
export class ClienteUpdateComponent implements OnInit {

  id: number;
  cliente: Cliente;
  submitted = false;
  private baseUrl = 'http://localhost:8081/api/v1/clientes';

  constructor(private route: ActivatedRoute, private clienteService: ClienteService,
              private router: Router, private httpClient: HttpClient) { }

  ngOnInit() {
    this.cliente = new Cliente();
    this.id = this.route.snapshot.params['id'];

  }
  clienteAtualizado(): void {
    this.submitted = false;

  }

update() {
  const params = new HttpParams()
    .set('nome', this.cliente.nome)
    .set('email', this.cliente.email)
    .set('senha', this.cliente.senha);
  this.cliente.nome = params.get('nome');
  this.cliente.email = params.get('email');
  this.cliente.senha = params.get('senha');
  this.clienteService.updateCliente(this.id, this.cliente);
  this.gotoList();

 }

  onSubmit() {
    this.submitted = true;
    this.update();
  }

  gotoList() {
    setTimeout(() => {
      this.router.navigate(['/clientes']);
    }, 1500);
  }
}
