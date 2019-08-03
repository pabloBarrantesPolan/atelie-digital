import { Component, OnInit } from '@angular/core';
import { Profissional } from 'src/app/profissional/profissional';
import { ActivatedRoute, Router } from '@angular/router';
import { ProfissionalService } from 'src/app/profissional/profissional.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  id: number;
  profissional: Profissional;

  constructor(private route: ActivatedRoute, private router: Router, private profissionalService: ProfissionalService) { }

  ngOnInit() {
    this.profissional = new Profissional();
    this.id = this.route.snapshot.params['id'];
    this.profissionalService.getProfissional(this.id).subscribe(data => {
      console.log(data);
      this.profissional = data;
    }, error => console.log(error));
  }

  list() {
    this.router.navigate(['admin/home']);
  }

}
