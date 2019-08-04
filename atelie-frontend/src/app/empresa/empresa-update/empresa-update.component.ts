import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { EmpresaService } from '../empresa.service';
import { Empresa } from '../empresa';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-empresa-update',
  templateUrl: './empresa-update.component.html',
  styleUrls: ['./empresa-update.component.css']
})
export class EmpresaUpdateComponent implements OnInit {

  empresa: Empresa;
  editForm: FormGroup;


  constructor(private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private router: Router,
              private empresaService: EmpresaService) { }

  ngOnInit() {
    let empresaId = this.route.snapshot.params['id'];

    this.editForm = this.formBuilder.group({
      id: [],
      nomeFantasia: ['', Validators.required],
      razaoSocial: ['', Validators.required],
      cep: ['', Validators.required],
      email: ['', Validators.required],
      telefone: ['', Validators.required],
      cnpj: ['', Validators.required],
      regiao: ['', Validators.required],
      senha: ['', Validators.required],
      plano: ['', Validators.required]

    });
    this.empresaService.getEmpresa(empresaId)
    .subscribe( data => {
      console.log(data);
      this.editForm.setValue(data);

    });
    }
    onSubmit() {
      let empresaId = this.route.snapshot.params['id'];
      this.empresaService.updateEmpresa(empresaId, this.editForm.value)
      .pipe(first()).subscribe(
        data => {
          this.router.navigate(['empresas']);
        },
        error => {
          alert(error);
        });
    }
}