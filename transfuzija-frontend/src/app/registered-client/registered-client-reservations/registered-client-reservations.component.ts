import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BloodCenterAppointmentService } from 'src/app/services/blood-center-appointment.service';
import { RegisteredClientService } from 'src/app/services/registered-client.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-registered-client-reservations',
  templateUrl: './registered-client-reservations.component.html',
  styleUrls: ['./registered-client-reservations.component.css']
})
export class RegisteredClientReservationsComponent implements OnInit {
  appointments: any;
  sort: string = 'NO_SORT';

  constructor(private tokenStorage: TokenStorageService,
    private clientService: RegisteredClientService,
    private appointmentService: BloodCenterAppointmentService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.clientService.findUpcomingAppointments(this.tokenStorage.getUser().id).subscribe((data) => {
      this.appointments = data;
      for (const appointment of this.appointments) {
        let today = new Date();
        appointment.appointmentStart = new Date(appointment.appointmentStart);
        let hours = 1 + Math.floor((appointment.appointmentStart.getTime() - today.getTime()) / 1000 / 60 / 60);
        appointment.cancel = hours > 24;
      }
    });
  }

  cancelAppointment(appointment: any) {
    if (confirm('Da li želite da otkažete termin u ' + appointment.center.name + '?')) {
      this.appointmentService.cancelAppointment(this.tokenStorage.getUser().id, appointment.id).subscribe((data) => {
        this.router.navigate(['../'], { relativeTo: this.route });
      });
    }
  }
}
