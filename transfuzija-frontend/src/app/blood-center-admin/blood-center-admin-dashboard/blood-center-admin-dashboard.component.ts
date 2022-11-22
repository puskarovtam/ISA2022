import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-blood-center-admin-dashboard',
  templateUrl: './blood-center-admin-dashboard.component.html',
  styleUrls: ['./blood-center-admin-dashboard.component.css'],
})
export class BloodCenterAdminDashboardComponent implements OnInit {
  tokenUser: any;
  user: any;

  constructor(
    private authService: AuthService,
    private tokenStorage: TokenStorageService
  ) {}

  ngOnInit(): void {
    this.tokenUser = this.tokenStorage.getUser();
    this.authService.find(this.tokenUser.id).subscribe((data) => {
      this.user = data;
    });
  }
}
