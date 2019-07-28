import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class EmpresaService {

  private baseUrl = 'http://localhost:8081/api/v1/empresas';

  constructor(private http: HttpClient) { }

  getEmpresas(): Observable<any> {
    return this.http.get(`${this.baseUrl}/`);
  }

  getEmpresa(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }


  // tslint:disable-next-line: ban-types
  createEmpresa(profisional: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/`, profisional);
  }


  // tslint:disable-next-line: ban-types
  updateEmpresa(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteEmpresa(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, {responseType: 'text'});
  }

  findByRegiao(regiao: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${regiao}`);
  }
}
