import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Profissional } from 'src/app/profissional/profissional';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  profissional:Profissional;
  loginForm: FormGroup;

  constructor(private router: Router, private formBuilder: FormBuilder) {
    this.createForm();
   }

   createForm() {
    this.loginForm = this.formBuilder.group({
      nome: ['', Validators.required],
      senha: ['', Validators.required]
    });
   }

  ngOnInit() {
  }

  onSubmit() {
    if (this.loginForm.get('nome').value === 'admin' && this.loginForm.get('senha').value === 'admin') {
      console.log("e o admin");

    }
  }

}
