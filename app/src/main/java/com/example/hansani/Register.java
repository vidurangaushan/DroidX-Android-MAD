package com.example.hansani;

public class Register {

    String name;
    String mail;
    String mob;
    String nc;
    String ct;

    public Register(String s, String name, String mail, String mob, String nc, String ct) {
        this.name = name;
        this.mail = mail;
        this.mob = mob;
        this.nc = nc;
        this.ct = ct;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getMob() {
        return mob;
    }

    public String getNc() {
        return nc;
    }

    public String getCt() {
        return ct;
    }
}
