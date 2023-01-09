import { Component, OnInit } from '@angular/core';
import { RegisteredClientService } from 'src/app/services/registered-client.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-registered-client-centers-history',
  templateUrl: './registered-client-centers-history.component.html',
  styleUrls: ['./registered-client-centers-history.component.css']
})
export class RegisteredClientCentersHistoryComponent implements OnInit {
  appointments: any;
  sort: string = 'NO_SORT';

  constructor(private tokenStorage: TokenStorageService,
    private clientService: RegisteredClientService
  ) { }

  ngOnInit(): void {
    this.clientService.findPastAppointments(this.tokenStorage.getUser().id).subscribe((data) => {
      this.appointments = data;
    });
  }

}
