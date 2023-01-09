import { Pipe, PipeTransform } from '@angular/core';
import { BloodCenterAppointment } from '../model/blood-center-appointment';

@Pipe({
  name: 'sortBy'
})
export class SortByPipe implements PipeTransform {

  transform(appointments: BloodCenterAppointment[], field: string): BloodCenterAppointment[] {
    if (!appointments) return [];

    switch (field) {
      case 'DATE_ASC':
        return appointments.sort((a, b) => a.appointmentStart > b.appointmentStart ? 1 : -1);
      case 'DATE_DES':
        return appointments.sort((a, b) => a.appointmentStart < b.appointmentStart ? 1 : -1);
      case 'DURATION_ASC':
        return appointments.sort((a, b) => a.duration > b.duration ? 1 : -1);
      case 'DURATION_DES':
        return appointments.sort((a, b) => a.duration < b.duration ? 1 : -1);
      default:
        return appointments;
    }
  }

}
