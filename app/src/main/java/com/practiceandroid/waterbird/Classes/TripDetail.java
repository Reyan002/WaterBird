package com.practiceandroid.waterbird.Classes;

public class TripDetail {
   private String dateAndTime;
   private String CompanyName;
   private String Status;

    public TripDetail(String dateAndTime, String companyName, String status) {
        this.dateAndTime = dateAndTime;
        CompanyName = companyName;
        Status = status;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
