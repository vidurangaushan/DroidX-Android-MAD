package com.example.mad_project11;

public class MainModel {
    String name, category, city, profileImageURL;

    MainModel()
    {

    }

    public MainModel(String name, String category, String city, String profileImageURL) {
        this.name = name;
        this.category = category;
        this.city = city;

        this.profileImageURL = profileImageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getProfileImageURL() {
        return profileImageURL;
    }

    public void setProfileImageURL(String profileImageURL) {
        this.profileImageURL = profileImageURL;
    }
}
