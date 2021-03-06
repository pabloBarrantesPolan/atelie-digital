import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Profissional } from 'src/app/profissional/profissional';
import { ProfissionalService } from 'src/app/profissional/profissional.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

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
    this.router.navigate(['admin/profissionais/modificar', id]);
  }

  profissionalDetails(id: number) {
    this.router.navigate(['admin/profissionais/detalhe', id]);
  }

}
