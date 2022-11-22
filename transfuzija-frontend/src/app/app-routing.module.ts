import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BloodCenterAdminDashboardComponent } from './blood-center-admin/blood-center-admin-dashboard/blood-center-admin-dashboard.component';
import { BloodCenterAdminProfileComponent } from './blood-center-admin/blood-center-admin-profile/blood-center-admin-profile.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { RegisteredClientCentersHistoryComponent } from './registered-client/registered-client-centers-history/registered-client-centers-history.component';
import { RegisteredClientCentersComponent } from './registered-client/registered-client-centers/registered-client-centers.component';
import { RegisteredClientComplainsComponent } from './registered-client/registered-client-complains/registered-client-complains.component';
import { RegisteredClientDashboardComponent } from './registered-client/registered-client-dashboard/registered-client-dashboard.component';
import { RegisteredClientProfileComponent } from './registered-client/registered-client-profile/registered-client-profile.component';
import { RegisteredClientQuestionnaireComponent } from './registered-client/registered-client-questionnaire/registered-client-questionnaire.component';
import { RegisteredClientReservationsComponent } from './registered-client/registered-client-reservations/registered-client-reservations.component';
import { SystemAdminDashboardComponent } from './system-admin/system-admin-dashboard/system-admin-dashboard.component';
import { SystemAdminProfileComponent } from './system-admin/system-admin-profile/system-admin-profile.component';

const routes: Routes = [
  { path: '', component: HomepageComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  {
    path: 'registered-client',
    component: RegisteredClientDashboardComponent,
    children: [
      { path: 'centers', component: RegisteredClientCentersComponent },
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
export class AppRoutingModule {}
