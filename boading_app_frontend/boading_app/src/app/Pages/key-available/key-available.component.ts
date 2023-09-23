import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-key-available',
  templateUrl: './key-available.component.html',
  styleUrls: ['./key-available.component.css']
})
export class KeyAvailableComponent implements OnInit {
status:any;
  constructor(private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit(): void {
    this.getemployee();
  }
  getemployee(){
    this.http.get("http://localhost:8082/status/key/true").subscribe((data)=>{
    this.status=data;
    console.log(data);
    })
  }
}
