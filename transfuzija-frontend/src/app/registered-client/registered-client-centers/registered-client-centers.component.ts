import { Component, OnInit } from '@angular/core';
import { BloodTransfusionCenter } from 'src/app/model/blood-transfusion-center';
import { Search } from 'src/app/model/search';
import { BloodCenterService } from 'src/app/services/blood-center.service';

@Component({
  selector: 'app-registered-client-centers',
  templateUrl: './registered-client-centers.component.html',
  styleUrls: ['./registered-client-centers.component.css']
})
export class RegisteredClientCentersComponent implements OnInit {
  bloodCenters!: Array<BloodTransfusionCenter>;
  filters: Search = new Search();
  cities: string[] = [];

  constructor(private bloodCenterService: BloodCenterService) { }

  ngOnInit(): void {
    this.bloodCenterService.findAll().subscribe((data) => {
      this.bloodCenters = data;
      console.table(this.bloodCenters)
      for (let i = 0; i < this.bloodCenters.length; i++) {
        if (!this.cities.includes(this.bloodCenters[i].city)) {
          this.cities.push(this.bloodCenters[i].city);
          this.cities.sort((a, b) => (a > b ? 1 : -1));
        }
      }
    });
  }

}
