import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BloodCenterAppointment } from 'src/app/model/blood-center-appointment';
import { BloodCenterAppointmentService } from 'src/app/services/blood-center-appointment.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-registered-client-appointments',
  templateUrl: './registered-client-appointments.component.html',
  styleUrls: ['./registered-client-appointments.component.css']
})
export class RegisteredClientAppointmentsComponent implements OnInit {
  id: number = 0;
  appointments: BloodCenterAppointment[] = [];
  sort: string = 'NO_SORT';

  constructor(private appointmentService: BloodCenterAppointmentService,
    private tokenStorage: TokenStorageService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.id = +this.route.snapshot.paramMap.get('id')!;
    this.appointmentService.findAvailableAppointments(this.id).subscribe((data) => {
      this.appointments = data;
      for (const appointment of this.appointments) {
        this.appointmentService.cancelledByClient(this.tokenStorage.getUser().id, appointment.id).subscribe((data) => {
          appointment.cancelledByClient = data;
        });
      }
    })
  }

  bookAppointment(appointmentId: any) {
    this.appointmentService.bookAppointment(this.tokenStorage.getUser().id, appointmentId).subscribe((data) => {
      this.router.navigate(['../../../reservations'], { relativeTo: this.route });
    });
  }

}
