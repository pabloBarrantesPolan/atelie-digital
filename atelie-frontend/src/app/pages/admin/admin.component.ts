import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
    
  }
  logout(){
    this.authService.logout();
    this.router.navigateByUrl('/home');
  }

  gotoList() {
    setTimeout(() => {
      this.router.navigate(['/clientes']);
    }, 1500);

  }

}
