import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-registered-client-dashboard',
  templateUrl: './registered-client-dashboard.component.html',
  styleUrls: ['./registered-client-dashboard.component.css']
})
export class RegisteredClientDashboardComponent implements OnInit {
  user: any;

  constructor(private authService: AuthService,
    private tokenStorage: TokenStorageService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.authService.find(this.tokenStorage.getUser().id).subscribe((data) => {
      this.user = data;
    });
  }

  logOut() {
    this.tokenStorage.logOut();
    this.router.navigate(['/login']);
  }

}
