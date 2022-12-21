import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const REGISTERED_CLIENTS_API =
  'http://localhost:8080/api/clients/';

@Injectable({
  providedIn: 'root'
})
export class RegisteredClientService {

  constructor(private http: HttpClient) { }

  findAllClients() {
    return this.http.get(`${REGISTERED_CLIENTS_API}`);
  }

  findClientById(id: any) {
    return this.http.get(`${REGISTERED_CLIENTS_API}` + `${id}`);
  }
}
