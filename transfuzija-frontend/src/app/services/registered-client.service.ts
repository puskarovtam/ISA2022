import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BloodCenterAppointment } from '../model/blood-center-appointment';
import { TokenStorageService } from './token-storage.service';

const REGISTERED_CLIENTS_API =
  'http://localhost:8080/api/clients/';

@Injectable({
  providedIn: 'root'
})
export class RegisteredClientService {

  constructor(private http: HttpClient,
    private tokenStorage: TokenStorageService
  ) { }

  findAllClients() {
    return this.http.get(`${REGISTERED_CLIENTS_API}`);
  }

  findClientById(id: number) {
    const headers = this.tokenStorage.getHeaders();
    return this.http.get(`${REGISTERED_CLIENTS_API}` + `${id}`, { headers: headers });
  }

  editClient(client: any) {
    const headers = this.tokenStorage.getHeaders();
    return this.http.put(`${REGISTERED_CLIENTS_API}`, client, { headers: headers });
  }

  saveQuestionnaire(id: number, questionnaire: any) {
    const headers = this.tokenStorage.getHeaders();
    return this.http.post(`${REGISTERED_CLIENTS_API}` + `${id}/questionnaire`, questionnaire, { headers: headers });
  }

  findUpcomingAppointments(id: number) {
    const headers = this.tokenStorage.getHeaders();
    return this.http.get<BloodCenterAppointment[]>(`${REGISTERED_CLIENTS_API}` + `${id}/upcoming-appointments`, { headers: headers });
  }

  findPastAppointments(id: any) {
    const headers = this.tokenStorage.getHeaders();
    return this.http.get<BloodCenterAppointment[]>(`${REGISTERED_CLIENTS_API}` + `${id}/past-appointments`, { headers: headers });
  }
}
