package com.example.himashiyan.road_vehicle_assistance.Location;

public class Garages {

    public String user_id;
    public String ownerName;
    public String garageName;
    public String password;
    public String address;
    public String email;
    public String contact;
    public String latitude;
    public String longitude;


    public Garages() {
    }


    public Garages(String user_id, String ownerName, String garageName, String password, String address, String email, String contact, String latitude, String longitude) {
        this.user_id = user_id;
        this.ownerName = ownerName;
        this.garageName = garageName;
        this.password = password;
        this.address = address;
        this.email = email;
        this.contact = contact;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getGarageName() {
        return garageName;
    }

    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
