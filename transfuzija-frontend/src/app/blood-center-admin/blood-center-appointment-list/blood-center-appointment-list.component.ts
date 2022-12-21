import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BloodCenterAdminService } from 'src/app/services/blood-center-admin.service';
import { BloodCenterAppointmentService } from 'src/app/services/blood-center-appointment.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-blood-center-appointment-list',
  templateUrl: './blood-center-appointment-list.component.html',
  styleUrls: ['./blood-center-appointment-list.component.css']
})
export class BloodCenterAppointmentListComponent implements OnInit {
  availableAppointments!: any;
  loggedInAdmin: any;

  constructor(private appointmentService: BloodCenterAppointmentService,
    private adminService: BloodCenterAdminService,
    private tokenStorage: TokenStorageService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.adminService.findByAdminId(this.tokenStorage.getUser().id).subscribe((data) => {
      this.loggedInAdmin = data;
      this.appointmentService.findAvailableAppointments(this.loggedInAdmin.transfusionCenterId).subscribe((data) => {
        this.availableAppointments = data;
      });
    });
  }

  newAppointment() {
    this.router.navigate(['../new-appointment'], { relativeTo: this.route });
  }

}
