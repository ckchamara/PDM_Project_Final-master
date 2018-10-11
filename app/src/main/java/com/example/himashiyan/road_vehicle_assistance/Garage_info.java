package com.example.himashiyan.road_vehicle_assistance;
//class implementation
public  class Garage_info {

    // variable declaration
    private String garagename;

    private String contact;
    private String curruntcity;
    private String city;
    private  String description;


    // Default constructor
   public Garage_info(){}

   //Parameterised constructor
   public Garage_info(String name, String contact, String city, String Address, String description)
   {

       this.garagename=name;
       this.contact=contact;
       this.city=city;
       this.curruntcity =Address;
       this.description=description;


   }
   // Getters implementation



    public String getContact() {
        return contact;
    }

    public String getGaragename() {
        return garagename;
    }

    public String getCurruntcity() {
        return curruntcity;
    }

    public String getCity() {
        return city;
    }

    public   String getDescription() {
        return description;
    }


}


