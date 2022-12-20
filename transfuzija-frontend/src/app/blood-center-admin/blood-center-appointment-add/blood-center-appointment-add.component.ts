import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { BloodCenterAdminService } from 'src/app/services/blood-center-admin.service';
import { BloodCenterAppointmentService } from 'src/app/services/blood-center-appointment.service';
import { BloodCenterService } from 'src/app/services/blood-center.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-blood-center-appointment-add',
  templateUrl: './blood-center-appointment-add.component.html',
  styleUrls: ['./blood-center-appointment-add.component.css']
})
export class BloodCenterAppointmentAddComponent implements OnInit {
  loggedInAdmin!: any;
  center!: any;
  medicalStuff!: any;

  appointmentForm!: FormGroup;

  constructor(private tokenStorage: TokenStorageService,
    private authService: AuthService,
    private centerService: BloodCenterService,
    private adminService: BloodCenterAdminService,
    private appointmentService: BloodCenterAppointmentService,
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.loadData();
    this.createForm();
  }

  loadData() {
    this.authService.find(this.tokenStorage.getUser().id).subscribe((data) => {
      this.loggedInAdmin = data;
      this.centerService.findOne(this.loggedInAdmin.transfusionCenter.id).subscribe((data) => {
        this.center = data;
        this.adminService.findAllAdmins(this.center.id).subscribe((data) => {
          this.medicalStuff = data;
        });
      });
    });
  }

  createForm() {
    this.appointmentForm = this.formBuilder.group({
      appointmentStart: [],
      duration: [],
      stuff: []
    });
  }

  submit() {
    let appointment = {
      appointmentStart: this.appointmentForm.controls.appointmentStart.value,
      duration: this.appointmentForm.controls.duration.value,
      centerID: this.center.id,
      clientID: 0,
      stuffID: this.appointmentForm.controls.stuff.value
    }

    this.appointmentService.createAppointment(appointment).subscribe((data) => {
      this.router.navigate(['../available-appointments'], { relativeTo: this.route });
    })
  }

}
