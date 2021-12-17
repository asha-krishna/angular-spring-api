import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({             // it can be injected into different components
  providedIn: 'root'
})
export class EmployeeService {

  private apiUrl = "http://localhost:8080/employee";

  constructor(private httpClient: HttpClient) { }

  getEmployeeList(): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(`${this.apiUrl}/findAll`);
  }

  getEmployeeById(id: number): Observable<Employee> {
    return this.httpClient.get<Employee>(`${this.apiUrl}/find/${id}`);
  } 

  addEmployee(employee: Employee): Observable<any> {
    return this.httpClient.post(`${this.apiUrl}/addEmployee`, employee);
  }

  updateEmployee(id: number, employee: Employee): Observable<Employee> {
    return this.httpClient.put<Employee>(`${this.apiUrl}/updateEmployee/${id}`, employee);
  }

  deleteEmployee(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.apiUrl}/deleteEmployee/${id}`);
  }
 
}
