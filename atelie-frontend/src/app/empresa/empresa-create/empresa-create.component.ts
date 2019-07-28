import { Component, OnInit } from '@angular/core';
import { Empresa } from '../empresa';
import { EmpresaService } from '../empresa.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-empresa-create',
  templateUrl: './empresa-create.component.html',
  styleUrls: ['./empresa-create.component.css']
})
export class EmpresaCreateComponent implements OnInit {

  empresa: Empresa = new Empresa();
  submitted = false;

  constructor(private empresaService: EmpresaService, private router: Router) { }

  ngOnInit() {
  }

  newEmpresa(): void {
    this.submitted = false;
    this.empresa = new Empresa();
  }

  save() {
    this.empresaService.createEmpresa(this.empresa)
    .subscribe(
      data => console.log(data),
      error => console.log(error)
    );
    this.empresa = new Empresa();
    this.gotoList();
  }

  onSubmit() {
    console.log(this.empresa);
    this.submitted = true;
    this.save();
  }

  gotoList() {
    setTimeout(() => {
      this.router.navigate(['/empresas']);
    }, 1500);

  }

}
