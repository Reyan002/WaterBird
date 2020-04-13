package com.practiceandroid.waterbird.Classes;

public class ChemicalUsed {
    private String productName;
    private String presenteDosage;
    private String revisedDosage;
    private String stock;

    public ChemicalUsed(String productName, String presenteDosage, String revisedDosage, String stock) {
        this.productName = productName;
        this.presenteDosage = presenteDosage;
        this.revisedDosage = revisedDosage;
        this.stock = stock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPresenteDosage() {
        return presenteDosage;
    }

    public void setPresenteDosage(String presenteDosage) {
        this.presenteDosage = presenteDosage;
    }

    public String getRevisedDosage() {
        return revisedDosage;
    }

    public void setRevisedDosage(String revisedDosage) {
        this.revisedDosage = revisedDosage;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}
