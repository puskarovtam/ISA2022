import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MustMatch } from '../helpers/must-match.validator';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  registerForm!: FormGroup;
  submitted = false;

  constructor(
    private authService: AuthService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group(
      {
        email: [null, [Validators.required, Validators.email]],
        password: [null, [Validators.required, Validators.minLength(6)]],
        repeat: [null, [Validators.required, Validators.minLength(6)]],
        name: [null, Validators.required],
        surname: [null, Validators.required],
        address: [null, Validators.required],
        city: [null, Validators.required],
        country: [null, Validators.required],
        phoneNumber: [null, Validators.required],
        jmbg: [null, Validators.required, Validators.minLength(13)],
        gender: [null, Validators.required],
        occupation: [null, Validators.required],
        jobInformation: [null, Validators.required],
      },
      {
        validator: MustMatch('password', 'repeat'),
      }
    );
  }

  onSubmit() {
    this.submitted = true;
    if (this.registerForm.invalid) {
      return;
    }

    var registerDTO = {
      email: this.registerForm.controls.email.value,
      password: this.registerForm.controls.password.value,
      repeat: this.registerForm.controls.repeat.value,
      name: this.registerForm.controls.name.value,
      surname: this.registerForm.controls.surname.value,
      address: this.registerForm.controls.address.value,
      city: this.registerForm.controls.city.value,
      country: this.registerForm.controls.country.value,
      phoneNumber: this.registerForm.controls.phoneNumber.value,
      jmbg: this.registerForm.controls.jmbg.value,
      gender: this.registerForm.controls.gender.value,
      occupation: this.registerForm.controls.occupation.value,
      jobInformation: this.registerForm.controls.jobInformation.value,
    };

    this.authService.register(registerDTO).subscribe(
      (data) => {
        console.log(data);
      },
      (err) => {
        console.log(err);
      }
    );
  }
}
