import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegisteredClientService } from 'src/app/services/registered-client.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-registered-client-profile',
  templateUrl: './registered-client-profile.component.html',
  styleUrls: ['./registered-client-profile.component.css']
})
export class RegisteredClientProfileComponent implements OnInit {
  client: any;
  clientProfileForm!: FormGroup;
  change!: boolean;
  submitted!: boolean;

  constructor(
    private tokenStorage: TokenStorageService,
    private clientService: RegisteredClientService,
    private formBuilder: FormBuilder,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.clientInfo();
  }

  clientInfo() {
    this.clientService.findClientById(this.tokenStorage.getUser().id).subscribe((data) => {
      this.client = data;
      this.clientProfileForm = this.formBuilder.group({
        email: [this.client.email, [Validators.required, Validators.email]],
        name: [this.client.name, Validators.required],
        surname: [this.client.surname, Validators.required],
        address: [this.client.address, Validators.required],
        city: [this.client.city, Validators.required],
        country: [this.client.country, Validators.required],
        phoneNumber: [this.client.phoneNumber, Validators.required],
        jmbg: [this.client.jmbg, [Validators.required, Validators.minLength(13)]],
        gender: [this.client.gender, Validators.required],
        occupation: [this.client.occupation, Validators.required]
      });
      this.change = true;
    });
  }

  enableChanges() {
    this.change = !this.change;
  }

  cancelChanges() {
    this.change = !this.change;
    this.clientInfo();
  }

}
