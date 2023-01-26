import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BloodCenterAppointment } from '../model/blood-center-appointment';
import { TokenStorageService } from './token-storage.service';

const CENTER_APPOINTMENTS_API =
  'http://localhost:8080/api/blood-center-appointments/';

@Injectable({
  providedIn: 'root'
})
export class BloodCenterAppointmentService {

  constructor(private http: HttpClient,
    private tokenStorage: TokenStorageService
  ) { }

  findAvailableAppointments(id: number) {
    const headers = this.tokenStorage.getHeaders();
    return this.http.get<BloodCenterAppointment[]>(`${CENTER_APPOINTMENTS_API}` + `center/${id}`, { headers: headers });
  }

  createAppointment(appointment: any) {
    const headers = this.tokenStorage.getHeaders();
    return this.http.post(`${CENTER_APPOINTMENTS_API}`, appointment, { headers: headers });
  }

  bookAppointment(clientId: any, appointmentId: any) {
    const headers = this.tokenStorage.getHeaders();
    return this.http.put<any>(`${CENTER_APPOINTMENTS_API}` + `book/${clientId}/${appointmentId}`, null, { headers: headers });
  }

  cancelAppointment(clientId: any, appointmentId: any) {
    const headers = this.tokenStorage.getHeaders();
    return this.http.delete(`${CENTER_APPOINTMENTS_API}` + `cancel/${clientId}/${appointmentId}`, { headers: headers });
  }

  cancelledByClient(clientId: any, appointmentId: any) {
    const headers = this.tokenStorage.getHeaders();
    return this.http.get<boolean>(`${CENTER_APPOINTMENTS_API}` + `has-cancelled/${clientId}/${appointmentId}`, { headers: headers });
  }
}
