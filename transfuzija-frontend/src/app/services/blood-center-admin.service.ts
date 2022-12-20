import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const CENTER_ADMINS_API =
  'http://localhost:8080/api/center-admins/';

@Injectable({
  providedIn: 'root'
})
export class BloodCenterAdminService {

  constructor(private http: HttpClient) { }

  findAllAdmins(id: any) {
    return this.http.get(`${CENTER_ADMINS_API} + ${id}`);
  }

  findByAdminId(id: any) {
    return this.http.get(`${CENTER_ADMINS_API}` + `admin/${id}`);
  }
}
