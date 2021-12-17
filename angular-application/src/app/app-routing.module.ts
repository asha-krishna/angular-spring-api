import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { EmployeePostComponent } from './employee-post/employee-post.component';
import { EmployeeUpdateComponent } from './employee-update/employee-update.component';

const routes: Routes = [
  {path:'employee', component: EmployeeListComponent},
  {path:'addEmployee', component: EmployeePostComponent},
  {path:'updateEmployee/:id', component: EmployeeUpdateComponent},
  {path:'', redirectTo: 'employee', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
