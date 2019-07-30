import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {Plano} from '../plano';
import {PlanoService} from '../plano.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-plano-list',
  templateUrl: './plano-list.component.html',
  styleUrls: ['./plano-list.component.css']
})
export class PlanoListComponent implements OnInit {

  planos: Observable<Plano[]>;
  plano: () => Observable<any>;

  constructor(private planoService: PlanoService,
              private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.planos = this.planoService.getPlanos();
  }

  deletePlano(id: number) {
    this.planoService.deletePlano(id)
      .subscribe(
   data => {
          console.log(data);
          this.reloadData();
        },
   error => console.log(error)
      );
  }

  planoDetails(id: number) {
    this.router.navigate(['details', id]);
  }

}
