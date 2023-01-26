import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TokenStorageService } from './token-storage.service';

const QUESTIONNAIRE_API = 'http://localhost:8080/api/questionnaires/';

@Injectable({
  providedIn: 'root'
})
export class QuestionnaireService {

  constructor(private http: HttpClient,
    private tokenStorage: TokenStorageService
  ) { }

  findQuestionnaireById(id: number) {
    const headers = this.tokenStorage.getHeaders();
    return this.http.get(`${QUESTIONNAIRE_API}` + `${id}`, { headers: headers });
  }
}
