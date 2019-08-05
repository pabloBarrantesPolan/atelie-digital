import { Injectable } from '@angular/core';
import { Profissional } from '../profissional/profissional';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private profissionalAutenticado: boolean = false;

  constructor(private router: Router) { }

  public login(profissional: Profissional){
    if (profissional.email === 'admin@admin' &&
        profissional.senha === 'admin'){

          this.profissionalAutenticado = true;
          this.router.navigate(['admin/home']);


        } else{
          this.profissionalAutenticado = false;
        }


  }

  public isLoggedIn(){
    return localStorage.getItem('ACCESS_TOKEN') !== null;

  }

  public logout(){
    localStorage.removeItem('ACCESS_TOKEN');
  }
}




