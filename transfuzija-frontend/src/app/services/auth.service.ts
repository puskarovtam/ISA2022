import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const AUTH_API = 'http://localhost:8080/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
};

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}

  register(registerDTO: any): Observable<any> {
    return this.http.post(AUTH_API + 'register', registerDTO, httpOptions);
  }

  login(loginDTO: any): Observable<any> {
    return this.http.post(AUTH_API + 'login', loginDTO, httpOptions);
  }

  find(id: any){
    return this.http.get(`${AUTH_API} + ${id}`);
  }
}
