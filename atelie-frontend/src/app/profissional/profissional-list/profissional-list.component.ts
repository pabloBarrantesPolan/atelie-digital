import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Profissional } from '../profissional';
import { ProfissionalService } from '../profissional.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profissional-list',
  templateUrl: './profissional-list.component.html',
  styleUrls: ['./profissional-list.component.css']
})
export class ProfissionalListComponent implements OnInit {

  profissionais: Observable<Profissional[]>;

  constructor(private profissionalService: ProfissionalService, private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }
  reloadData() {
    this.profissionais = this.profissionalService.getProfissionais();
  }

  deleteProfissional(id: number) {
    this.profissionalService.deleteProfissional(id).subscribe(
      data => {
        console.log(data);
        this.reloadData();
      }, error => console.log(error)
    );
  }
  profissionalUpdate(id: number) {
    this.router.navigate(['profissionais/modificar', id]);
  }

  profissionalDetails(id: number) {
    this.router.navigate(['profissionais/detalhe', id]);
  }

  profissionalfindByRegiao(regiao: string){
    this.router.navigate(['profissionais/list', String]);
  }

}
