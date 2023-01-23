import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { QuestionnaireService } from 'src/app/services/questionnaire.service';
import { RegisteredClientService } from 'src/app/services/registered-client.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-registered-client-questionnaire',
  templateUrl: './registered-client-questionnaire.component.html',
  styleUrls: ['./registered-client-questionnaire.component.css']
})
export class RegisteredClientQuestionnaireComponent implements OnInit {
  questionnaireForm!: FormGroup;
  submitted = false;
  change: boolean = false;
  id: any;
  korisnik: any;

  constructor(private clientService: RegisteredClientService,
    private tokenStorage: TokenStorageService,
    private questionnaireService: QuestionnaireService,
    private formBuilder: FormBuilder,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.clientService.findClientById(this.tokenStorage.getUser().id).subscribe((data) => {
      this.korisnik = data;

      this.questionnaireForm = this.formBuilder.group({
        question1: [],
        question2: [],
        question3: [],
        question4: [],
        question5: [],
        question6: [],
        question7: [],
        question8: [],
        question9: [],
        question10: [],
        question11: [],
        question12: [],
        question13: [],
        question14: [],
      });

      if (this.korisnik.questionnaireCompleted) {
        console.log("ULAZIMMMMM")
        this.change = !this.change;
        this.questionnaireService.findQuestionnaireById(this.korisnik.questionnaireId).subscribe((data) => {
          this.questionnaireForm.patchValue(data);
        });
      }
    });
  }

  get f() { return this.questionnaireForm.controls; }

  onSubmit() {
    var questionnaireDTO = {
      question1: this.questionnaireForm.controls.question1.value,
      question2: this.questionnaireForm.controls.question2.value,
      question3: this.questionnaireForm.controls.question3.value,
      question4: this.questionnaireForm.controls.question4.value,
      question5: this.questionnaireForm.controls.question5.value,
      question6: this.questionnaireForm.controls.question6.value,
      question7: this.questionnaireForm.controls.question7.value,
      question8: this.questionnaireForm.controls.question8.value,
      question9: this.questionnaireForm.controls.question9.value,
      question10: this.questionnaireForm.controls.question10.value,
      question11: this.questionnaireForm.controls.question11.value,
      question12: this.questionnaireForm.controls.question12.value,
      question13: this.questionnaireForm.controls.question13.value,
      question14: this.questionnaireForm.controls.question14.value,
    };

    this.id = this.tokenStorage.getUser().id;

    this.clientService.saveQuestionnaire(this.id, questionnaireDTO).subscribe((data) => {
      this.router.navigate(['registered-client']);
    });
  }

}
