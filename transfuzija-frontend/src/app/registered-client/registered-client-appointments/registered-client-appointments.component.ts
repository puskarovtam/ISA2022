import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BloodCenterAppointmentService } from 'src/app/services/blood-center-appointment.service';

@Component({
  selector: 'app-registered-client-appointments',
  templateUrl: './registered-client-appointments.component.html',
  styleUrls: ['./registered-client-appointments.component.css']
})
export class RegisteredClientAppointmentsComponent implements OnInit {
  id: number = 0;
  appointments!: any;

  constructor(private appointmentService: BloodCenterAppointmentService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.id = +this.route.snapshot.paramMap.get('id')!;
    this.appointmentService.findAvailableAppointments(this.id).subscribe((data)=>{
      this.appointments = data;
      console.table(this.appointments);
    })
  }

}
