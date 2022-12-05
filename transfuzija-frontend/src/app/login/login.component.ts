import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  submitted = false;

  constructor(
    private authService: AuthService,
    private tokenStorage: TokenStorageService,
    private formBuilder: FormBuilder,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      email: [null, [Validators.required, Validators.email]],
      password: [null, [Validators.required, Validators.minLength(6)]],
    });
  }

  onSubmit() {
    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    }

    var loginDTO = {
      email: this.loginForm.controls.email.value,
      password: this.loginForm.controls.password.value,
    };

    this.authService.login(loginDTO).subscribe(
      (data) => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUser(data);
        if (this.tokenStorage.getUser().roles == "CENTER_ADMINISTRATOR") {
          this.router.navigate(['blood-center-admin']);
        } else if (this.tokenStorage.getUser().roles == "SYSTEM_ADMINISTRATOR") {
          this.router.navigate(['system-admin']);
        } else if (this.tokenStorage.getUser().roles == "REGISTERED_CLIENT"){
          this.router.navigate(['registered-client']);
        }
      },
      (err) => {
        console.log(err);
      }
    );
  }
}
