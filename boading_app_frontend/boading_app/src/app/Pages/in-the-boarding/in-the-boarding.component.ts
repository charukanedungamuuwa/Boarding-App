import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-in-the-boarding',
  templateUrl: './in-the-boarding.component.html',
  styleUrls: ['./in-the-boarding.component.css']
})
export class InTheBoardingComponent implements OnInit {
status:any;
  constructor(private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit(): void {
    this.getemployee();
  }
  getemployee(){
    this.http.get("http://localhost:8082/status/available/true").subscribe((data)=>{
    this.status=data;
    console.log(data);
    })
  }
}
