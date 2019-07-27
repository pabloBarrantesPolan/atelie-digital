import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfissionalService {

  private baseUrl = 'http://localhost:8081/api/v1/profissionais';

  constructor(private http: HttpClient) { }

  getProfissionais(): Observable<any> {
    return this.http.get(`${this.baseUrl}/`);
  }

  getProfissional(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }


  // tslint:disable-next-line: ban-types
  createProfissional(profisional: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/`, profisional);
  }


  // tslint:disable-next-line: ban-types
  updateProfissional(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteProfissional(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, {responseType: 'text'});
  }

  findByRegiao(regiao: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${regiao}`);
  }
}
