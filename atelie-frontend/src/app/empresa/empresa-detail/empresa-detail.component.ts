import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmpresaService } from '../empresa.service';
import { Empresa } from '../empresa';

@Component({
  selector: 'app-empresa-detail',
  templateUrl: './empresa-detail.component.html',
  styleUrls: ['./empresa-detail.component.css']
})
export class EmpresaDetailComponent implements OnInit {

  constructor(private route: ActivatedRoute, private router: Router, private empresaService: EmpresaService) { }

  id: number;
  empresa: Empresa;

  ngOnInit() {
    this.empresa = new Empresa();
    this.id = this.route.snapshot.params['id'];
    this.empresaService.getEmpresa(this.id).subscribe(data => {
      console.log(data);
      this.empresa = data;
    }, error => console.log(error));
  }

  list() {
    this.router.navigate(['empresas']);
  }

}
