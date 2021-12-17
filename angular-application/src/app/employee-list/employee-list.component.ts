import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  
  employees: Employee[] = [];
  
  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit(): void {
    this.getEmployees();
  }

  private getEmployees() {
    this.employeeService.getEmployeeList().subscribe( resp => {   // we get resp in an array Employee[]
        this.employees = resp;                                    // Employee[] response is assigning to local employees variable
    });
  }

  updateEmployee(id: any) {
    this.router.navigate(['updateEmployee', id]);
  }

  deleteEmployee(id: any) {
    if(confirm("Are you sure to delete " +id)) {
      this.employeeService.deleteEmployee(id).subscribe( resp => {
        console.log(resp);
        this.getEmployees();
      });
    }
  }

}