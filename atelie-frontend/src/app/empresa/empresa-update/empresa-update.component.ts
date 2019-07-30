import { Component, OnInit } from '@angular/core';
import { Empresa } from '../empresa';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { EmpresaService } from '../empresa.service';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-empresa-update',
  templateUrl: './empresa-update.component.html',
  styleUrls: ['./empresa-update.component.css']
})
export class EmpresaUpdateComponent implements OnInit {

  empresa: Empresa;
  editForm: FormGroup;

  constructor(/*private token: TokenStorageService,*/
              private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private router: Router,
              private empresaService: EmpresaService) { }

  ngOnInit() {
    let empresaId = this.route.snapshot.params['id'];
    if(!empresaId) {
      alert("Ação inválida!")
      this.router.navigate(['empresas']);
      return;
    }
    this.editForm = this.formBuilder.group({
      id: [],
      nomeFantasia: ['', Validators.required],
      razaoSocial: ['', Validators.required],
      cnpj: ['', Validators.required],
      cep: ['', Validators.required],
      email: ['', Validators.required],
      telefone: ['', Validators.required],
      regiao: ['', Validators.required],
      plano: ['', Validators.required],
      senha: ['', Validators.required]
    });
    this.empresaService.getEmpresa(empresaId)
    .subscribe( data => {
      this.editForm.setValue(data);
    });
  }

  onSubmit() {
    let empresaId = this.route.snapshot.params['id'];
    this.empresaService.updateEmpresa(empresaId, this.editForm.value)
    .pipe(first())
    .subscribe(
      data => {
        this.router.navigate(['empresas']);
      },
      error => {
        alert(error);
      });
  }

  goToLogin() {
    this.router.navigate(['login']);
  }

}
