package com.example.droidx_mad;

public class ServiceAll {

    private String Name;
    private String Email;
    private String telephone;
    private String city;
    private String category;

    public ServiceAll() {
    }

    public ServiceAll(String name, String email, String telephone, String city, String category) {
        Name = name;
        Email = email;
        this.telephone = telephone;
        this.city = city;
        this.category = category;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
