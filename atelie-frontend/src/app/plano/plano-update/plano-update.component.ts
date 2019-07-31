import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { Plano } from '../plano';
import { ActivatedRoute, Router } from '@angular/router';
import { PlanoService } from '../plano.service';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-plano-update',
  templateUrl: './plano-update.component.html',
  styleUrls: ['./plano-update.component.css']
})
export class PlanoUpdateComponent implements OnInit {

  plano: Plano;
  editForm: FormGroup;


  constructor(private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private router: Router,
              private planoService: PlanoService) { }

  ngOnInit() {
    let planoId = this.route.snapshot.params['id'];

    this.editForm = this.formBuilder.group({
      id: [],
      tipo: ['', Validators.required],
      numero: ['', Validators.required],
      descricao: ['', Validators.required],
      valor: ['', Validators.required]
    });
    this.planoService.getPlano(planoId)
    .subscribe( data => {
      console.log(data);
      this.editForm.setValue(data);

    });
    }
    onSubmit() {
      let planoId = this.route.snapshot.params['id'];
      this.planoService.updatePlano(planoId, this.editForm.value)
      .pipe(first()).subscribe(
        data => {
          this.router.navigate(['planos']);
        },
        error => {
          alert(error);
        });
    }

}
