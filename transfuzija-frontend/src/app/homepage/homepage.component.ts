import { Component, OnInit } from '@angular/core';
import { BloodTransfusionCenter } from '../model/blood-transfusion-center';
import { Search } from '../model/search';
import { BloodCenterService } from '../services/blood-center.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css'],
})
export class HomepageComponent implements OnInit {
  bloodCenters!: Array<BloodTransfusionCenter>;
  filters: Search = new Search();
  cities: string[] = [];

  constructor(private bloodCenterService: BloodCenterService) {}

  ngOnInit(): void {
    this.bloodCenterService.findAll().subscribe((data) => {
      this.bloodCenters = data;
      for (let i = 0; i < this.bloodCenters.length; i++) {
        if (!this.cities.includes(this.bloodCenters[i].city)) {
          this.cities.push(this.bloodCenters[i].city);
          this.cities.sort((a, b) => (a > b ? 1 : -1));
        }
      }
    });
  }
}
