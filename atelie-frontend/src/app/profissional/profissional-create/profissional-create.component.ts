import { Component, OnInit } from '@angular/core';
import { Cliente, Profissional } from '../profissional';
import { ClienteService, ProfissionalService } from '../profissional.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profissional-create',
  templateUrl: './profissional-create.component.html',
  styleUrls: ['./profissional-create.component.css']
})
export class ProfissionalCreateComponent implements OnInit {

  profissional: Profissional = new Profissional();
  submitted = false;

  constructor(private profissionalService: ProfissionalService, private router: Router) { }

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
