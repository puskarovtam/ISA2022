import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActivateEmailComponent } from './activate-email/activate-email.component';
import { BloodCenterAdminDashboardComponent } from './blood-center-admin/blood-center-admin-dashboard/blood-center-admin-dashboard.component';
import { BloodCenterAdminProfileComponent } from './blood-center-admin/blood-center-admin-profile/blood-center-admin-profile.component';
import { BloodCenterAppointmentAddComponent } from './blood-center-admin/blood-center-appointment-add/blood-center-appointment-add.component';
import { BloodCenterAppointmentListComponent } from './blood-center-admin/blood-center-appointment-list/blood-center-appointment-list.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { RegisteredClientAppointmentsComponent } from './registered-client/registered-client-appointments/registered-client-appointments.component';
import { RegisteredClientCenterPageComponent } from './registered-client/registered-client-center-page/registered-client-center-page.component';
import { RegisteredClientCentersHistoryComponent } from './registered-client/registered-client-centers-history/registered-client-centers-history.component';
import { RegisteredClientCentersComponent } from './registered-client/registered-client-centers/registered-client-centers.component';
import { RegisteredClientComplainsComponent } from './registered-client/registered-client-complains/registered-client-complains.component';
import { RegisteredClientDashboardComponent } from './registered-client/registered-client-dashboard/registered-client-dashboard.component';
import { RegisteredClientProfileComponent } from './registered-client/registered-client-profile/registered-client-profile.component';
import { RegisteredClientQuestionnaireComponent } from './registered-client/registered-client-questionnaire/registered-client-questionnaire.component';
import { RegisteredClientReservationsComponent } from './registered-client/registered-client-reservations/registered-client-reservations.component';
import { RegistrationSuccessComponent } from './registration-success/registration-success.component';
import { SystemAdminDashboardComponent } from './system-admin/system-admin-dashboard/system-admin-dashboard.component';
import { SystemAdminProfileComponent } from './system-admin/system-admin-profile/system-admin-profile.component';

const routes: Routes = [
  { path: '', component: HomepageComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'registration-success', component: RegistrationSuccessComponent },
  { path: 'activate/:verificationToken', component: ActivateEmailComponent },
  { path: 'login', component: LoginComponent },
  {
    path: 'registered-client',
    component: RegisteredClientDashboardComponent,
    children: [
      { path: 'centers', component: RegisteredClientCentersComponent },
      { path: 'center/:id', component: RegisteredClientCenterPageComponent },
      { path: 'center/appointment-list/:id', component: RegisteredClientAppointmentsComponent },
      { path: 'history', component: RegisteredClientCentersHistoryComponent },
      {
        path: 'reservations',
        component: RegisteredClientReservationsComponent,
      },
      {
        path: 'questionnaire',
        component: RegisteredClientQuestionnaireComponent,
      },
      { path: 'complains', component: RegisteredClientComplainsComponent },
      { path: 'profile', component: RegisteredClientProfileComponent },
    ],
  },
  {
    path: 'system-admin',
    component: SystemAdminDashboardComponent,
    children: [{ path: 'profile', component: SystemAdminProfileComponent }],
  },
  {
    path: 'blood-center-admin',
    component: BloodCenterAdminDashboardComponent,
    children: [
      {
        path: 'available-appointments',
        component: BloodCenterAppointmentListComponent,
      },
      {
        path: 'new-appointment',
        component: BloodCenterAppointmentAddComponent,
      },
      {
        path: 'profile',
        component: BloodCenterAdminProfileComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
