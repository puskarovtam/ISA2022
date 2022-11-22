import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BloodCenterAdminDashboardComponent } from './blood-center-admin/blood-center-admin-dashboard/blood-center-admin-dashboard.component';
import { BloodCenterAdminProfileComponent } from './blood-center-admin/blood-center-admin-profile/blood-center-admin-profile.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
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

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomepageComponent,
    RegisterComponent,
    LoginComponent,
    RegisteredClientDashboardComponent,
    RegisteredClientProfileComponent,
    RegisteredClientQuestionnaireComponent,
    RegisteredClientCentersComponent,
    RegisteredClientCentersHistoryComponent,
    RegisteredClientReservationsComponent,
    RegisteredClientComplainsComponent,
    SystemAdminDashboardComponent,
    SystemAdminProfileComponent,
    BloodCenterAdminDashboardComponent,
    BloodCenterAdminProfileComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
