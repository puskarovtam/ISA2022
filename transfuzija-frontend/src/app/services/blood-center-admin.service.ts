import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TokenStorageService } from './token-storage.service';

const CENTER_ADMINS_API =
  'http://localhost:8080/api/center-admins/';

@Injectable({
  providedIn: 'root'
})
export class BloodCenterAdminService {

  constructor(private http: HttpClient,
    private tokenStorage: TokenStorageService
  ) { }

  findAllAdmins(id: number) {
    const headers = this.tokenStorage.getHeaders();
    return this.http.get(`${CENTER_ADMINS_API} + ${id}`, { headers: headers });
  }

  findByAdminId(id: number) {
    const headers = this.tokenStorage.getHeaders();
    return this.http.get(`${CENTER_ADMINS_API}` + `admin/${id}`, { headers: headers });
  }

  editAdmin(admin: any) {
    const headers = this.tokenStorage.getHeaders();
    return this.http.put(`${CENTER_ADMINS_API}`, admin, { headers: headers });
  }
}
