import { Component, OnInit } from '@angular/core';
import { RegisteredClientService } from 'src/app/services/registered-client.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-registered-client-reservations',
  templateUrl: './registered-client-reservations.component.html',
  styleUrls: ['./registered-client-reservations.component.css']
})
export class RegisteredClientReservationsComponent implements OnInit {
  appointments: any;

  constructor(private tokenStorage: TokenStorageService,
    private clientService: RegisteredClientService) { }

  ngOnInit(): void {
    this.clientService.findUpcomingAppointments(this.tokenStorage.getUser().id).subscribe((data) => {
      this.appointments = data;
    });
  }
}
