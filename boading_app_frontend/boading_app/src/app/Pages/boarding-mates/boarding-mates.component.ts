import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-boarding-mates',
  templateUrl: './boarding-mates.component.html',
  styleUrls: ['./boarding-mates.component.css']
})
export class BoardingMatesComponent implements OnInit {

  employees:any;
 
  constructor(private http: HttpClient,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getEmployees().subscribe(data => {
      this.employees = data;
      console.log(this.employees);
    });
  }




  getEmployees(){

    return this.http.get("http://localhost:8082/api/v1/employee/all");
     }
}
