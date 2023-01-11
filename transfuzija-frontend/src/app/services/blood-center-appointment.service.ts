import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BloodCenterAppointment } from '../model/blood-center-appointment';

const CENTER_APPOINTMENTS_API =
  'http://localhost:8080/api/blood-center-appointments/';

@Injectable({
  providedIn: 'root'
})
export class BloodCenterAppointmentService {

  constructor(private http: HttpClient) { }

  findAvailableAppointments(id: any) {
    return this.http.get<BloodCenterAppointment[]>(`${CENTER_APPOINTMENTS_API}` + `center/${id}`);
  }

  createAppointment(appointment: any) {
    return this.http.post(`${CENTER_APPOINTMENTS_API}`, appointment);
  }

  bookAppointment(clientId: any, appointmentId: any) {
    return this.http.put<any>(`${CENTER_APPOINTMENTS_API}` + `book/${clientId}/${appointmentId}`, null);
  }

  cancelAppointment(clientId: any, appointmentId: any) {
    return this.http.delete(`${CENTER_APPOINTMENTS_API}` + `cancel/${clientId}/${appointmentId}`);
  }

  cancelledByClient(clientId: any, appointmentId: any) {
    return this.http.get<boolean>(`${CENTER_APPOINTMENTS_API}` + `has-cancelled/${clientId}/${appointmentId}`);
  }
}
