import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BloodCenterService } from 'src/app/services/blood-center.service';

@Component({
  selector: 'app-registered-client-center-page',
  templateUrl: './registered-client-center-page.component.html',
  styleUrls: ['./registered-client-center-page.component.css']
})
export class RegisteredClientCenterPageComponent implements OnInit {
  id!: number;
  bloodCenter: any;

  constructor(
    private bloodService: BloodCenterService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.id = +this.route.snapshot.paramMap.get('id')!;
    this.bloodService.findOne(this.id).subscribe((data) => {
      this.bloodCenter = data;
    })
  }

  scheduleAppointment(center_id: any){
    console.log("Kliknut sam u zakazivanju");
    this.router.navigate([`registered-client/center/appointment-list/${center_id}`]);
  }

}
