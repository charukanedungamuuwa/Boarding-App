import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-boarding-mates',
  templateUrl: './boarding-mates.component.html',
  styleUrls: ['./boarding-mates.component.css']
})
export class BoardingMatesComponent implements OnInit {
  books = [
    {
      id: 1,
      empImage:"/assets/images/bills.png" ,
      name: 'kusal perera',
      mobilenumber: '077-4674870',
      address: 'rathnapura'
    
      
    },
    {
      id: 2,
      empImage: '\assets\Images\sinna.jpg',
      name: 'kusal perera',
      mobilenumber: '077-4674870',
      address: 'balangoda'
    },{
      id: 2,
      empImage: '\assets\Images\sinna.jpg',
      name: 'kusal perera',
      mobilenumber: '077-4674870',
      address: 'balangoda'
    },{
      id: 2,
      empImage: '\assets\Images\sinna.jpg',
      name: 'kusal perera',
      mobilenumber: '077-4674870',
      address: 'balangoda'
    },{
      id: 2,
      empImage: '\assets\Images\sinna.jpg',
      name: 'kusal perera',
      mobilenumber: '077-4674870',
      address: 'balangoda'
    },{
      id: 2,
      empImage: '\assets\Images\sinna.jpg',
      name: 'kusal perera',
      mobilenumber: '077-4674870',
      address: 'balangoda'
    },{
      id: 2,
      empImage: '\assets\Images\sinna.jpg',
      name: 'kusal perera',
      mobilenumber: '077-4674870',
      address: 'balangoda'
    },{
      id: 2,
      empImage: '\assets\Images\sinna.jpg',
      name: 'kusal perera',
      mobilenumber: '077-4674870',
      address: 'balangoda'
    },{
      id: 2,
      empImage: '\assets\Images\s.jpg',
          
      name: 'kusal perera',
      mobilenumber: '077-4674870',
      address: 'balangoda'
    },{
      id: 2,
      empImage: '\assets\Images\sinna.jpg',
      name: 'kusal perera',
      mobilenumber: '077-4674870',
      address: 'balangoda'
    },
    // Add more book entries here...
  ];
  constructor() { }

  ngOnInit(): void {
  }

}
