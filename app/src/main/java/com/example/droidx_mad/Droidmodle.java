package com.example.droidx_mad;

public class Droidmodle {
    private  int id;
    private String name, amount;
    private long started, finished;

    public Droidmodle(){

    }

    public Droidmodle(int id, String name, String amount, long started, long finished) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.started = started;
        this.finished = finished;
    }

    public Droidmodle(String name, String amount, long started, long finished) {
        this.name = name;
        this.amount = amount;
        this.started = started;
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public long getStarted() {
        return started;
    }

    public void setStarted(long started) {
        this.started = started;
    }

    public long getFinished() {
        return finished;
    }

    public void setFinished(long finished) {
        this.finished = finished;
    }
}
