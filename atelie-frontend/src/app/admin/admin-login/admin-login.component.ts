import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgModel, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  constructor(private router: Router ) { }
  senha = "admin";
  usuario = "admin"
  ngOnInit() {
  }
  onSubmit(){
    if (this.senha === NgModel.name && this.usuario === NgModel.name) {
        this.goToAdmin();
    }
  }
  goToAdmin() {
    this.router.navigate(['admin/home']);
  }

}
