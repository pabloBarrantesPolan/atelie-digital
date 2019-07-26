import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClienteService } from '../cliente.service';
import { Cliente } from '../cliente';

@Component({
  selector: 'app-cliente-detail',
  templateUrl: './cliente-detail.component.html',
  styleUrls: ['./cliente-detail.component.css']
})
export class ClienteDetailComponent implements OnInit {

  constructor(private route: ActivatedRoute, private router: Router, private clienteService: ClienteService) { }

  id: number;
  cliente: Cliente;

  ngOnInit() {
    this.cliente = new Cliente();
    this.id = this.route.snapshot.params['id'];
    this.clienteService.getCliente(this.id).subscribe(data => {
      console.log(data);
      this.cliente = data;
    }, error => console.log(error));
  }

  list() {
    this.router.navigate(['clientes']);
  }
}


