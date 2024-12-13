import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
basesurl:string='http://localhost:8080/project/';
  constructor(private http:HttpClient) { }

  getAllEmployee(){
   return (this.http.get(`${this.basesurl}getAllEmp`));
  }

  getEmpById(id:any){
   return (this.http.get(`${this.basesurl}getEmployeeById/${id}`));
  }

  getAllCountry(){
    return (this.http.get(`${this.basesurl}getAllCountry`));
  }

  addEmpRecord(obj:any){
    return (this.http.post(`${this.basesurl}addEmp`,obj,{
      responseType:'text'
    
    }));
  }
  updateEmployee(obj:any){
     return (this.http.put(`${this.basesurl}updateEmployee/${obj.id}`,obj,{
      responseType:'text'
    }));
  }

  deleteEmp(id:any){
   return (this.http.delete(`${this.basesurl}deleteEmp/${id}`,{
   responseType:'text'
    }));
  }
}
