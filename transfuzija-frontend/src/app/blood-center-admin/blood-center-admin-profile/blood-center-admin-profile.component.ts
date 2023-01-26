import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BloodCenterAdminService } from 'src/app/services/blood-center-admin.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-blood-center-admin-profile',
  templateUrl: './blood-center-admin-profile.component.html',
  styleUrls: ['./blood-center-admin-profile.component.css']
})
export class BloodCenterAdminProfileComponent implements OnInit {
  centerAdmin: any;
  centerAdminProfileForm!: FormGroup;
  change!: boolean;
  submitted!: boolean;

  constructor(private tokenStorage: TokenStorageService,
    private adminService: BloodCenterAdminService,
    private formBuilder: FormBuilder,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.centerAdminInfo();
  }

  centerAdminInfo() {
    this.adminService.findByAdminId(this.tokenStorage.getUser().id).subscribe((data) => {
      this.centerAdmin = data;
      this.centerAdminProfileForm = this.formBuilder.group({
        email: [this.centerAdmin.email, [Validators.required, Validators.email]],
        name: [this.centerAdmin.name, Validators.required],
        surname: [this.centerAdmin.surname, Validators.required],
        address: [this.centerAdmin.address, Validators.required],
        city: [this.centerAdmin.city, Validators.required],
        country: [this.centerAdmin.country, Validators.required],
        phoneNumber: [this.centerAdmin.phoneNumber, Validators.required],
      });
    });
    this.change = true;
  }

  enableChanges() {
    this.change = !this.change;
  }

  cancelChanges() {
    this.change = !this.change;
    this.centerAdminInfo();
  }

  saveChanges() {
    this.submitted = true;
    if (this.centerAdminProfileForm.invalid) {
      return;
    }

    var centerAdmin = {
      id: this.centerAdmin.id,
      email: this.centerAdminProfileForm.controls.email.value,
      name: this.centerAdminProfileForm.controls.name.value,
      surname: this.centerAdminProfileForm.controls.surname.value,
      address: this.centerAdminProfileForm.controls.address.value,
      city: this.centerAdminProfileForm.controls.city.value,
      country: this.centerAdminProfileForm.controls.country.value,
      phoneNumber: this.centerAdminProfileForm.controls.phoneNumber.value,
    }

    this.adminService.editAdmin(centerAdmin).subscribe((data) => {
      this.change = !this.change;
    });
  }

}
