import { Component, OnInit } from '@angular/core';
import { Profissional } from '../profissional';
import { ProfissionalService } from '../profissional.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Plano } from 'src/app/plano/plano';

@Component({
  selector: 'app-profissional-create',
  templateUrl: './profissional-create.component.html',
  styleUrls: ['./profissional-create.component.css']
})

export class ProfissionalCreateComponent implements OnInit {

  planos: Observable<Plano[]>;
  profissional: Profissional = new Profissional();
  submitted = false;
  authService: any;

  constructor(private profissionalService: ProfissionalService, private router: Router) { }

  ngOnInit() {
  }

  seleciona() {


  }

  newPessoa(): void {
    this.submitted = false;
    this.profissional = new Profissional();
  }

  save() {
    this.profissionalService.createProfissional(this.profissional)
    .subscribe(
      data => console.log(data),
      error => console.log(error)
    );
    this.profissional = new Profissional();
    this.gotoList();
  }

  onSubmit() {
    console.log(this.profissional);
    this.submitted = true;
    this.save();
  }

  gotoList() {
    setTimeout(() => {
      this.router.navigate(['/profissionais/detalhe']);
    }, 1500);

  }
  logout() {
    this.authService.logout();
    this.router.navigateByUrl('/home');
  }

}
