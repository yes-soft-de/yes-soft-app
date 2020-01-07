import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AuthComponent} from './component/auth/auth.component';
import {HttpClientModule} from '@angular/common/http';
import {DashboardComponent} from './component/dashboard/dashboard.component';
import {ServicesComponent} from './component/services/services.component';
import {EmployeeComponent} from './component/employee/employee.component';
import {
  MatButtonModule, MatCardModule, MatDatepickerModule, MatDialogModule, MatFormFieldModule,
  MatGridListModule,
  MatIconModule, MatInputModule,
  MatListModule, MatNativeDateModule,
  MatSidenavModule, MatTabsModule,
  MatToolbarModule,
  MatTreeModule
} from '@angular/material';
import {FaIconLibrary, FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {
  MdcButtonModule,
  MdcChipsModule,
  MdcFabModule,
  MdcIconModule,
  MdcImageListModule,
  MdcTextFieldModule,
  MdcTopAppBarModule
} from '@angular-mdc/web';
import {EditEmployeeComponent} from './component/edit-employee/edit-employee/edit-employee.component';
import {AddEmployeeComponent} from './component/add-employee/add-employee/add-employee.component';
import {AddServiceComponent} from './component/add-service/add-service/add-service.component';
import {EditServiceComponent} from './component/edit-service/edit-service/edit-service.component';
import {ReactiveFormsModule} from '@angular/forms';
import { EditProjectComponent } from './component/edit-project/edit-project/edit-project.component';
import { EditBlogComponent } from './component/edit-blog/edit-blog/edit-blog.component';

@NgModule({
  declarations: [
    AppComponent,
    AuthComponent,
    DashboardComponent,
    ServicesComponent,
    EmployeeComponent,
    EditEmployeeComponent,
    AddEmployeeComponent,
    AddServiceComponent,
    EditServiceComponent,
    EditProjectComponent,
    EditBlogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatTreeModule,
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatButtonModule,
    MatGridListModule,
    MatCardModule,
    MatDialogModule,
    FontAwesomeModule,
    MdcImageListModule,
    MdcIconModule,
    MatButtonModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MdcFabModule,
    MdcTopAppBarModule,
    MatTabsModule,
    ReactiveFormsModule,
    MdcTextFieldModule,
    MdcButtonModule,
    MdcChipsModule,
    MatDatepickerModule,
    MatInputModule
  ],
  providers: [],
  entryComponents: [
    EditEmployeeComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
