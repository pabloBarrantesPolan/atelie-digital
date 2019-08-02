import { Component, OnInit } from '@angular/core';
import { Contato } from '../contato';
import { Observable } from 'rxjs';
import { ContatoService } from '../contato.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-email-list',
  templateUrl: './email-list.component.html',
  styleUrls: ['./email-list.component.css']
})
export class EmailListComponent implements OnInit {

  emails: Observable<Contato[]>;
  constructor(private contatoService: ContatoService, private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }
  reloadData() {
    this.emails = this.contatoService.getEmails();
  }

  deleteEmail(id: number) {
    this.contatoService.deleteEmail(id).subscribe(
      data => {
        console.log(data);
        this.reloadData();
      }, error => console.log(error)
    );
  }

  emailDetails(id: number) {
    this.router.navigate(['admin/emails/detalhe', id]);
  }

  clienteUpdate(id: number) {
    this.router.navigate(['cliente/modificar', id]);
  }

}
