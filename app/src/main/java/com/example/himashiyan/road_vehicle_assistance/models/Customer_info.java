package com.example.himashiyan.road_vehicle_assistance.models;
//class implementation
public  class Customer_info {

    // variable declaration
    private String name;

    private  String fname;
    private String lname;
    private String nic;
    private String contact;



    // Default constructor
   public Customer_info(){}

   //Parameterised constructor
   public Customer_info(String fname,String lname,String nic, String contact)
   {

       this.fname=fname;
       this.lname=lname;
       this.nic=nic;
       this.contact=contact;



   }
   // Getters implementation


    public String getName() {
        return name;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getNic() {
        return nic;
    }

    public String getContact() {
        return contact;
    }
}


