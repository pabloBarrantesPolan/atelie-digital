import { Component, OnInit } from '@angular/core';
import { Contato } from '../contato';
import { ActivatedRoute, Router } from '@angular/router';
import { ContatoService } from '../contato.service';

@Component({
  selector: 'app-email-details',
  templateUrl: './email-details.component.html',
  styleUrls: ['./email-details.component.css']
})
export class EmailDetailsComponent implements OnInit {

  constructor(private route: ActivatedRoute, private router: Router, private contatoService: ContatoService) { }

  id: number;
  email: Contato;

  ngOnInit() {
    this.email = new Contato();
    this.id = this.route.snapshot.params['id'];
    this.contatoService.getEmail(this.id).subscribe(data => {
      console.log(data);
      this.email = data;
    }, error => console.log(error));
  }

  list() {
    this.router.navigate(['admin/home']);
  }

}
