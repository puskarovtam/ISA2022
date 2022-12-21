import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegisteredClientService } from 'src/app/services/registered-client.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-registered-client-dashboard',
  templateUrl: './registered-client-dashboard.component.html',
  styleUrls: ['./registered-client-dashboard.component.css']
})
export class RegisteredClientDashboardComponent implements OnInit {
  user: any;

  constructor(private clientService: RegisteredClientService,
    private tokenStorage: TokenStorageService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.clientService.findClientById(this.tokenStorage.getUser().id).subscribe((data) => {
      this.user = data;
    });
  }

  logOut() {
    this.tokenStorage.logOut();
    this.router.navigate(['/login']);
  }

}
