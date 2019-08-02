import { Component, OnInit } from '@angular/core';
import { Contato } from './contato';
import { ContatoService } from './contato.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-contato',
  templateUrl: './contato.component.html',
  styleUrls: ['./contato.component.css']
})
export class ContatoComponent implements OnInit {

  contato: Contato = new Contato();


  constructor(private contatoService: ContatoService, private router: Router) { }

  ngOnInit() {
  }

  newEmail(): void {
    this.contato = new Contato();
  }

  save() {
    this.contatoService.createEmail(this.contato)
    .subscribe(
      data => console.log(data),
      error => console.log(error)
    );
    this.contato = new Contato();
    this.gotoList();
  }

  onSubmit() {
    console.log(this.contato);

    this.save();
  }

  gotoList() {
    setTimeout(() => {
      alert('E-mail enviado com sucesso');
      this.router.navigate(['/home']);
    }, 1500);

  }

}
