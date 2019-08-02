import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContatoService {

  private baseUrl = 'http://localhost:8082/api/v1/emails';

  constructor(private http: HttpClient) { }

  getEmail(): Observable<any> {
    return this.http.get(`${this.baseUrl}/`);
  }

  getEmails(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }


  // tslint:disable-next-line: ban-types
  createEmail(contato: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/`, contato);
  }


  deleteEmail(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, {responseType: 'text'});
  }


}
