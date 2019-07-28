import { Component, OnInit } from '@angular/core';
import { Empresa } from '../empresa';
import { EmpresaService } from '../empresa.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-empresa-list',
  templateUrl: './empresa-list.component.html',
  styleUrls: ['./empresa-list.component.css']
})
export class EmpresaListComponent implements OnInit {

  empresas: Observable<Empresa[]>;

  constructor(private empresaService: EmpresaService, private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }
  reloadData() {
    this.empresas = this.empresaService.getEmpresas();
  }

  deleteEmpresa(id: number) {
    this.empresaService.deleteEmpresa(id).subscribe(
      data => {
        console.log(data);
        this.reloadData();
      }, error => console.log(error)
    );
  }

  empresaDetails(id: number) {
    this.router.navigate(['empresas/detalhe', id]);
  }

}
