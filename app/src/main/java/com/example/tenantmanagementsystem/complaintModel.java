package com.example.tenantmanagementsystem;

public class complaintModel {
    private String comp;

    private complaintModel() {}

    private complaintModel(String comp) {
        this.comp = comp;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }
}
