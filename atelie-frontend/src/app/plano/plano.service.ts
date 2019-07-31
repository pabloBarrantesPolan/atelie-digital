import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlanoService {

  private baseUrl = 'http://localhost:8082/api/v1/planos';

  constructor(private http: HttpClient) { }

  getPlano(id:number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
  getPlanos(): Observable<any> {
    return this.http.get(`${this.baseUrl}/`);
  }

  createPlano(plano: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/`, plano);
  }

  updatePlano(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deletePlano(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`,
      { responseType: 'text'});
  }

}
