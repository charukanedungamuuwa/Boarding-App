import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  gotdatas: any;
  status:any;
  p: any = {
    employeeid: 0, // Initialize with a default value
    employeename: '', // Initialize with a default value
     intheboarding: '',
    keyholder: false
  };
  
  constructor(private route: ActivatedRoute, private http: HttpClient) {
    this.route.params.subscribe(params => {
        const userId = params['id'];
        // Fetch user data using the userId
        this.fetchUserData(userId);
        this.getemployee(userId);
        
    });
}
ngOnInit(): void {
 this.fetchUserData(this.route.snapshot.params['id'])
 this.getemployee;
}
fetchUserData(userId: string) {
  // Use userId to fetch user data from the server
  this.http.get(`http://localhost:8082/api/v1/employee/${userId}`).subscribe((userData: any) => {
      // Handle the user data as needed
      this.gotdatas=userData;
     
       console.log(userData);
  });
 

}


getemployee(userid:any){
  this.http.get(`http://localhost:8082/status/${userid}`).subscribe((data)=>{
  this.status=data;
  console.log(data);
  // this.p.intheboarding = this.status.intheboarding;
  this.p.intheboarding = this.status.intheboarding;
this.p.keyholder=this.status.keyholder;  })
}
savekeyholder(){

  this.p.employeeid = this.gotdatas.employeeid;
  this.p.employeename = this.gotdatas.employeename;
  if (!this.p.keyholder) {
    // If intheboarding is true, delete the status
    
    this.p.keyholder = false;
    this.http.post('http://localhost:8082/status/save',this.p).subscribe(()=>{
     
    console.log('Book added to favorites successfully');
   
    });
    
     // Set intheboarding to false
  } else {
    // If intheboarding is false, save the status
    this.p.keyholder = true; // Set intheboarding to true
    this.http.post('http://localhost:8082/status/save',this.p).subscribe(()=>{
     
    console.log('Book added to favorites successfully');
   
    });
  }
 
  


  
}
saveintheboarding(){
  
  
 
  this.p.employeeid = this.gotdatas.employeeid;
  this.p.employeename = this.gotdatas.employeename;
  if (!this.p.intheboarding) {
    // If intheboarding is true, delete the status
    
    // this.deleteintheboarding(this.p.employeeid);
    this.p.intheboarding=false;
    this.http.post('http://localhost:8082/status/save',this.p).subscribe(()=>{
     
    console.log('Book added to favorites successfully');
   
    });
     // Set intheboarding to false
  } else {
    // If intheboarding is false, save the status
    this.p.intheboarding = true; // Set intheboarding to true
    this.http.post('http://localhost:8082/status/save',this.p).subscribe(()=>{
     
    console.log('Book added to favorites successfully');
   
    });
  }
 
  
  
 
 
 
 
}

deleteintheboarding(userid:any){
  this.http.delete(`http://localhost:8082/status/${userid}`).subscribe(()=>{
    console.log(' book deleted successfully.');
  })
}





}
