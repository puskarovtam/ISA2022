import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const BLOOD_CENTERS_API =
  'http://localhost:8080/api/blood-transfusion-centers/';

@Injectable({
  providedIn: 'root',
})
export class BloodCenterService {
  constructor(private http: HttpClient) {}

  findAll() {
    return this.http.get(BLOOD_CENTERS_API);
  }
}
