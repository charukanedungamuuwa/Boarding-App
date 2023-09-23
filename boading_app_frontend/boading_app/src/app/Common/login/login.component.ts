import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
 

  email: string ="";
  password: string ="";
  empinfo: any;
  
  


  constructor(private router: Router,private http: HttpClient) {}
  ngOnInit(): void {
    this.getall();
  }
 
getall(){
  this.http.get("http://localhost:8082/api/v1/employee/all").subscribe((data)=>{
      this.empinfo=data;
  })
}

  Login() {
    console.log(this.email);
    console.log(this.password);
    
 
    let bodyData = {
      email: this.email,
      password: this.password,
      
    };
 
        this.http.post("http://localhost:8082/api/v1/employee/login", bodyData).subscribe(  (resultData: any) => {
        console.log(resultData);
 
        if (resultData.message == "Email not exits")
        {
      
          alert("Email not exits");
    
 
        }
        else if(resultData.message == "Login Success")
    
         {
          // this.router.navigateByUrl(`/home/${this.empinfo.id}`);
          // this.router.navigateByUrl(`/home/${resultData.id}`);
          const userId = resultData.userId; // Extract the user's ID
          this.router.navigateByUrl(`/home/${userId}`);
         
        }
        else
        {
          alert("Incorrect Email and Password not match");
        }

      });
    }

}