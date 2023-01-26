import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { BloodCenterAdminService } from 'src/app/services/blood-center-admin.service';
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
    private tokenStorage: TokenStorageService,
    private adminService: BloodCenterAdminService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.tokenUser = this.tokenStorage.getUser();
    this.adminService.findByAdminId(this.tokenUser.id).subscribe((data) => {
      this.user = data;
      console.table(this.user);
    });
  }

  logOut() {
    this.tokenStorage.logOut();
    this.router.navigate(['/']);
  }
}
