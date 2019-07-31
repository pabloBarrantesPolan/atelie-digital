import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../cliente.service';
import { Cliente } from '../cliente';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
//import { TokenStorageService } from '../../auth/token-storage.service';

@Component({
  selector: 'app-cliente-update',
  templateUrl: './cliente-update.component.html',
  styleUrls: ['./cliente-update.component.css']
})
export class ClienteUpdateComponent implements OnInit {

  cliente: Cliente;
  editForm: FormGroup;

  constructor(/*private token: TokenStorageService,*/
              private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private router: Router,
              private clienteService: ClienteService) { }

  ngOnInit() {
    let clienteId = this.route.snapshot.params['id'];
  
    this.editForm = this.formBuilder.group({
      id: [],
      nome: ['', Validators.required],
      email: ['', Validators.required],
      senha: ['', Validators.required]
    });
    this.clienteService.getCliente(clienteId)
    .subscribe( data => {
      this.editForm.setValue(data);
    });
  }

  onSubmit() {
    let clienteId = this.route.snapshot.params['id'];
    this.clienteService.updateCliente(clienteId, this.editForm.value)
    .pipe(first())
    .subscribe(
      data => {
        this.router.navigate(['clientes']);
      },
      error => {
        alert(error);
      });
  }

  goToLogin() {
    this.router.navigate(['login']);
  }
}

