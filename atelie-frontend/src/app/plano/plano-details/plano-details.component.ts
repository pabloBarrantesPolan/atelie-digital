import { Component, OnInit } from '@angular/core';
import { Plano } from '../plano';
import {ActivatedRoute, Router} from '@angular/router';
import {PlanoService} from '../plano.service';

@Component({
  selector: 'app-plano-details',
  templateUrl: './plano-details.component.html',
  styleUrls: ['./plano-details.component.css']
})
export class PlanoDetailsComponent implements OnInit {

  id: number;
  plano: Plano;
 

  constructor(private route: ActivatedRoute,
              private router: Router,
              private planoService: PlanoService) { }

  ngOnInit() {
    this.plano = new Plano();
    this.id = this.route.snapshot.params['id'];
    this.planoService.getPlano(this.id)
      .subscribe(data => {
        console.log(data)
        this.plano = data;
      }, error => console.log(error));
  }

  list() {
    this.router.navigate(['planos']);
  }

}
