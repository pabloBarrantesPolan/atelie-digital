import { Component, OnInit } from '@angular/core';
import {Plano} from '../plano';
import {PlanoService} from '../plano.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-plano-create',
  templateUrl: './plano-create.component.html',
  styleUrls: ['./plano-create.component.css']
})
export class PlanoCreateComponent implements OnInit {

  plano: Plano = new Plano();
  submitted = false;

  constructor(private planoService: PlanoService,
              private router: Router) { }

  ngOnInit() {
  }

  newPessoa(): void {
    this.submitted = false;
    this.plano = new Plano();
  }

  save() {
    this.planoService.createPlano(this.plano)
      .subscribe(
        data => console.log(data),
        error => console.log(error)
      );
    this.plano = new Plano();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    setTimeout(() => {

      this.router.navigate(['planos']);
    },1500);
  }



}
