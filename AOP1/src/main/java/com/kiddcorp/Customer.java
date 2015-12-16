package com.kiddcorp;

public class Customer {
  
  private String id;
  
  private String name;

  public Customer() {
    super();
  }

  public Customer(String id, String name){
    this.id = id;
    this.name = name;
  }
  
  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }
  
  public String toString(){
    return getClass().getSimpleName() 
      + " id=" + this.id + ", name=" + this.name;
  }
}
