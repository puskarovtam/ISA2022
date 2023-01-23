import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const QUESTIONNAIRE_API = 'http://localhost:8080/api/questionnaires/';

@Injectable({
  providedIn: 'root'
})
export class QuestionnaireService {

  constructor(private http: HttpClient) { }

  findQuestionnaireById(id: any) {
    return this.http.get(`${QUESTIONNAIRE_API}` + `${id}`);
  }
}
