package com.example.droidx_mad;

public class AllNotices {
    private String notititle;
    private String description;

    public AllNotices() {}

    public AllNotices(String notititle, String description) {
        this.notititle = notititle;
        this.description = description;
    }

    public String getNotitile() {
        return notititle;
    }

    public void setNotitile(String notitile) {
        this.notititle = notititle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
