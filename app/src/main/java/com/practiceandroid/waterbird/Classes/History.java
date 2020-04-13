package com.practiceandroid.waterbird.Classes;

public class History {
    private String reportId;
    private String clientName;
    private String date;

    public History(String reportId, String clientName, String date) {
        this.reportId = reportId;
        this.clientName = clientName;
        this.date = date;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
