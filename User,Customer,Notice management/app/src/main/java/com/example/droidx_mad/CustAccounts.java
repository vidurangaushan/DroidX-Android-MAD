package com.example.droidx_mad;

public class CustAccounts {
    private String fname;
    private String lname;
    private String email;
    private String address;
    private String phone;

    public CustAccounts() {}
    public CustAccounts(String fname, String lname, String email, String address, String phone){
        this.fname=fname;
        this.lname=lname;
        this.email=email;
        this.address=address;
        this.phone=phone;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
