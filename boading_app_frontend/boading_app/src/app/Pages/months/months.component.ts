import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PaymentService } from 'src/app/payment.service';

@Component({
  selector: 'app-months',
  templateUrl: './months.component.html',
  styleUrls: ['./months.component.css']
})
export class MonthsComponent implements OnInit {
  boardingmatepayments:any;
  selectedImage: any;
  selectedPayment: any;
  filteredPayments: any;
  monthName: any;
  employees:any;

  constructor(private route: ActivatedRoute ,private service:PaymentService,private http: HttpClient) {
    // this.route.params.subscribe(params => {
    //   const monthName = params['monthName'];
      
    //   console.log(monthName);
    //   this.filterPaymentsByMonth(this.monthName);
    // });
   }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.monthName = params['monthName'];
      // Now, you have access to the monthName parameter
      console.log(this.monthName);
    this.service.getpayments().subscribe(data=>{this.boardingmatepayments=data;
      this.filterPaymentsByMonth(this.monthName);  });

    });
    this.getEmployees().subscribe(data => {
      this.employees = data;
    });
  }
 getEmployees(){

return this.http.get("http://localhost:8082/api/v1/employee/all");
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
  filterPaymentsByMonth(monthName: string) {
    if (this.boardingmatepayments && monthName) {
      this.filteredPayments = this.boardingmatepayments.filter((payment: { month: string; }) => payment.month === monthName);
    } else {
      this.filteredPayments = []; // Clear the filtered array if no data or monthName
    }
  }
  calculateTotal(): number {
    let total = 0;
    
    for (const payment of this.filteredPayments) {
      total += payment.amount;
    }
    return total;
  }
  calculateArr(): number {
    let arr = 0;
    
    for (const payment of this.filteredPayments) {
      arr+= payment.arrears;
    }
    return arr;
  }
  getEmployeesWithoutPayment() {
    if (!this.employees || !this.filteredPayments) {
      return [];
    }
  
    const employeesWithPayment = this.filteredPayments.map((payment: { name: any; }) => payment.name);
  
    // Filter out employees who didn't make a payment in the specified month
    const employeesWithoutPayment = this.employees.filter((employee: { employeename: any; }) => {
      return !employeesWithPayment.includes(employee.employeename);
    });
  
    return employeesWithoutPayment;
  }
   
}
