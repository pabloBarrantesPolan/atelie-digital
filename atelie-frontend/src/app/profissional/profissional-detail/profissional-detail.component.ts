import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProfissionalService } from '../profissional.service';
import { Profissional } from '../profissional';

@Component({
  selector: 'app-profissional-detail',
  templateUrl: './profissional-detail.component.html',
  styleUrls: ['./profissional-detail.component.css']
})
export class ProfissionalDetailComponent implements OnInit {

  constructor(private route: ActivatedRoute, private router: Router, private profissionalService: ProfissionalService) { }

  id: number;
  profissional: Profissional;

  ngOnInit() {
    this.profissional = new Profissional();
    this.id = this.route.snapshot.params['id'];
    this.profissionalService.getProfissional(this.id).subscribe(data => {
      console.log(data);
      this.profissional = data;
    }, error => console.log(error));
  }

  list() {
    this.router.navigate(['profissionais']);
  }

}
