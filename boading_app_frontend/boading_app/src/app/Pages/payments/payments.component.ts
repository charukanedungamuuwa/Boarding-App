import { DatePipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

import { PaymentService } from 'src/app/payment.service';

@Component({
  selector: 'app-payments',
  templateUrl: './payments.component.html',
  styleUrls: ['./payments.component.css']
})
export class PaymentsComponent implements OnInit {
  gotdatas:any;
  boardingmatepayments:any;
  name:any;
  // date=new Date();
  amount:any;
  arrears:any;
  slip:any;
  isFetching:boolean=false;
  id:any;
  paymentToUpdate: any = {};
  admindetails:any;
  Account_Number:any;
  adminAccountToUpdate:any={};
  monthly_Payment:any;
  accountName:any;
  // currentDateTime = new Date();
  date:any;
  options: string[] = ['One', 'Two', 'Three'];
  myControl = new FormControl('');
  month:any;
  selectedImage: File | undefined;
  selectedPayment: any;
  // isButtonDisabled: any;
  
  
  

 allMonths:String[]=[
  "January", "February", "March", "April", "May", "June",
  "July", "August", "September", "October", "November", "December"
 ]
  q: any = {};
message:any;
 
  constructor(private service:PaymentService,private datePipe: DatePipe,private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit(): void {   
    this.isFetching=true;
   this.service.getpayments().subscribe(data=>this.boardingmatepayments=data);
   this.isFetching=false;
   this.getadmindetails();
   this.date = this.datePipe.transform(new Date(), 'yyyy-MM-dd HH:mm');
   
    const userId = this.route.snapshot.params['userId'];
    this.fetchUserData(userId);
  // this.service.adminaccount().subscribe(data=>this.admindetails=data);
   
   
  }


  calculateTotal(): number {
    let total = 0;
    
    for (const payment of this.boardingmatepayments) {
      total += payment.amount;
    }
    return total;
  }
  
  public addPayments(){
    let payment={ 
      "name":this.name,
    "date":this.date,
    "amount":this.amount,
    "arrears":this.arrears,
    "slip":this.slip,
    "month":this.month
  }
    // this.service.savepayments(payment).subscribe((data)=>{
    //   alert('book added');
    //   location.reload();
    // });
    const formData = new FormData();
    formData.append('payment', JSON.stringify(payment));
    if (this.selectedImage) {
      formData.append('image', this.selectedImage);
    }
  
    this.service.savepayments(formData).subscribe((data) => {
      alert('Payment added');
      location.reload();
    });

  }

  public addadminaccount(){
    let p={ 
      "account_Number":this.Account_Number,
    "account_Name":this.accountName,
    "bank":this.bank,
    "branch":this.branch,
    "monthly_Payment":this.monthly_Payment
  }
    this.service.saveadminaccount(p).subscribe((data)=>{
      alert('book added');
      location.reload();
    });
    

  }

  public removepayments(j:any){
    this.service.deletepayments(j).subscribe((data)=>{
      location.reload();
      alert('book is deleted');
    })
  }
  public updatePayment() {
    this.service.updatepayment(this.paymentToUpdate).subscribe(() => {
      alert('Payment updated successfully');
       // Refresh the payment list after updating
      // Optionally, you can close the modal after updating
      // const modal = new bootstrap.Modal(document.getElementById('exampleModal3'));
      // modal.hide();
    });
  }
  public updateadminaccountdetails(){
    this.service.adminaccountupdate(this.adminAccountToUpdate).subscribe(()=>{
      alert(' updated successfully');
    })
  }
















































  
  public getadmindetails(){
    this.service.adminaccount().subscribe((data)=>{
      this.admindetails=data;
    })
  }

  public edit(id: number) {
    this.paymentToUpdate = this.boardingmatepayments.find((payment: { id: number; }) => payment.id === id);
}
  public editAdminDetail(id:number){
    this.adminAccountToUpdate = this.admindetails.find((adminaccount: { id: number; }) => adminaccount.id === id);
  }
  onImageSelected(event: any) {
    this.selectedImage = event.target.files[0];
  }
  getImageUrl(paymentId: number): string {
    return `http://localhost:8082/api/image/${paymentId}`;
  }
  viewImage(payment: any) {
    this.selectedPayment = payment;
  }
  clearSelectedPayment() {
    this.selectedPayment = null;
  }
   
accnum=299999999
accname='Kithmal G.G.B'
bank='boc'
branch='piliyandala'
monthlypayment='5500'


fetchUserData(userId: string) {
  // Use userId to fetch user data from the server
  this.http.get(`http://localhost:8082/api/v1/employee/${userId}`).subscribe((userData: any) => {
      // Handle the user data as needed
     
      this.name = userData.employeename;
       console.log("this is",userData);

      //  if (userData.employeename === this.boardingmatepayments.name) {
      //   this.isButtonDisabled = true;
      // } else {
      //   this.isButtonDisabled = false;
      // }
  },(error) => {
    console.error("Error fetching user data:", error);
  }
);
  

}

openMonthModal(monthName: string) {
  // // Fetch data for the selected month using your API service
  // this.apiService.getDataForMonth(monthName).subscribe((data) => {
  //   // Open the modal with the fetched data
  //   const modalRef = this.modalService.open(ModalComponent, { size: 'lg' }); // Specify modal size
  //   modalRef.componentInstance.monthData = data; // Pass the data to the modal component
  // });
}
}





