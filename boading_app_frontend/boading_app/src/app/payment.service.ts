import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  name:any;
  date:any;
  amount:any;
  arrears:any;
  slip:any;
  
 
  constructor(private http:HttpClient) { }
  getpayments(){
   return this.http.get("http://localhost:8082/api/get");

  }

   savepayments(paymentdata:any){
   
    return this.http.post("http://localhost:8082/api/save",paymentdata);
}
saveownerpayments(paymentdata:any){
   
  return this.http.post("http://localhost:8082/api/saveowner",paymentdata);
}

deletepayments( id:any){
  return this.http.delete(`http://localhost:8082/api/delete/${id}`);
}
updatepayment(payment: any) {
  return this.http.put(`http://localhost:8082/api/update/${payment.id}`, payment);
}
//admin
adminaccount(){
  return this.http.get("http://localhost:8082/admin/getall");
}
owneraccount(){
  return this.http.get("http://localhost:8082/owner/getowner");
}

adminaccountupdate(adminaccount:any)
{
  return this.http.put(`http://localhost:8082/admin/update/${adminaccount.id}`,adminaccount);
}
owneraccountupdate(owneraccount:any)
{
  return this.http.put(`http://localhost:8082/owner/updateowner/${owneraccount.id}`,owneraccount);
}
saveadminaccount(p:any){
   
  return this.http.post("http://localhost:8082/admin/save",p);
}



}
