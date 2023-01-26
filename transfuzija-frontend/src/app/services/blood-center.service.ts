import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BloodTransfusionCenter } from '../model/blood-transfusion-center';
import { TokenStorageService } from './token-storage.service';

const BLOOD_CENTERS_API =
  'http://localhost:8080/api/blood-transfusion-centers/';

@Injectable({
  providedIn: 'root',
})
export class BloodCenterService {
  constructor(private http: HttpClient,
    private tokenStorage: TokenStorageService
  ) { }

  findAll() {
    return this.http.get<BloodTransfusionCenter[]>(BLOOD_CENTERS_API);
  }

  findOne(id: number) {
    const headers = this.tokenStorage.getHeaders();
    return this.http.get(`${BLOOD_CENTERS_API} + ${id}`, { headers: headers });
  }
}
