import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BloodCenterAppointment } from '../model/blood-center-appointment';

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

  editClient(client: any) {
    return this.http.put(`${REGISTERED_CLIENTS_API}`, client);
  }

  saveQuestionnaire(id: any, questionnaire: any){
    return this.http.post(`${REGISTERED_CLIENTS_API}` + `${id}/questionnaire`, questionnaire);
  }

  findUpcomingAppointments(id: any){
    return this.http.get<BloodCenterAppointment[]>(`${REGISTERED_CLIENTS_API}` + `${id}/upcoming-appointments`);
  }

  findPastAppointments(id: any){
    return this.http.get<BloodCenterAppointment[]>(`${REGISTERED_CLIENTS_API}` + `${id}/past-appointments`);
  }
}
