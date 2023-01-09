import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BloodCenterAppointmentService } from 'src/app/services/blood-center-appointment.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-registered-client-appointments',
  templateUrl: './registered-client-appointments.component.html',
  styleUrls: ['./registered-client-appointments.component.css']
})
export class RegisteredClientAppointmentsComponent implements OnInit {
  id: number = 0;
  appointments!: any;

  constructor(private appointmentService: BloodCenterAppointmentService,
    private tokenStorage: TokenStorageService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.id = +this.route.snapshot.paramMap.get('id')!;
    this.appointmentService.findAvailableAppointments(this.id).subscribe((data) => {
      this.appointments = data;
    })
  }

  bookAppointment(appointmentId: any) {
    this.appointmentService.bookAppointment(this.tokenStorage.getUser().id, appointmentId).subscribe((data) => {
      this.router.navigate(['../../../reservations'], { relativeTo: this.route });
    });
  }

}
