import { Component, OnInit } from '@angular/core';
import { BloodCenterService } from '../services/blood-center.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css'],
})
export class HomepageComponent implements OnInit {
  bloodCenters: any;

  constructor(private bloodCenterService: BloodCenterService) {}

  ngOnInit(): void {
    this.bloodCenterService.findAll().subscribe(
      data => {
        console.log(data);
        this.bloodCenters = data;
      }
    )
  }
}
