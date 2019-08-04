import { Component, OnInit } from '@angular/core';
import { Profissional } from '../profissional';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProfissionalService } from '../profissional.service';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-profissional-update',
  templateUrl: './profissional-update.component.html',
  styleUrls: ['./profissional-update.component.css']
})
export class ProfissionalUpdateComponent implements OnInit {

  prof: Profissional;
  editForm: FormGroup;


  constructor(private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private router: Router,
              private profissionalService: ProfissionalService) { }

  ngOnInit() {
    let profId = this.route.snapshot.params['id'];

    this.editForm = this.formBuilder.group({
      id: [],
      nome: ['', Validators.required],
      cep: ['', Validators.required],
      email: ['', Validators.required],
      telefone: ['', Validators.required],
      cpf: ['', Validators.required],
      regiao: ['', Validators.required],
      senha: ['', Validators.required],
      plano: ['', Validators.required]

    });
    this.profissionalService.getProfissional(profId)
    .subscribe( data => {
      console.log(data);
      this.editForm.setValue(data);

    });
    }
    onSubmit() {
      let profId = this.route.snapshot.params['id'];
      this.profissionalService.updateProfissional(profId, this.editForm.value)
      .pipe(first()).subscribe(
        data => {
          this.router.navigate(['admin/home']);
        },
        error => {
          alert(error);
        });
    }

}
