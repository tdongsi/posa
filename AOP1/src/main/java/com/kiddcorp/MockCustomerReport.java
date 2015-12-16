package com.kiddcorp;



public class MockCustomerReport implements CustomerReport{

  private CustomerQuery query;
  
  public MockCustomerReport(CustomerQuery query){
    this.query = query;
  }
  
  public String getReport(String customerName){
   Customer customer = this.query.getCustomerByName(customerName);
   return customer != null ? customer.toString() : null;
  }
  
}
