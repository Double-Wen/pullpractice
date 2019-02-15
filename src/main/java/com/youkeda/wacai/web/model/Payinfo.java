package com.youkeda.wacai.web.model;

public class Payinfo {
    private PayType payType;
    private int billingDate;
    private int dueDate;
    private double amont;
    private int stagesCount;

    public PayType getPayType() {
        return payType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    public int getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(int billingDate) {
        this.billingDate = billingDate;
    }

    public int getDueDate() {
        return dueDate;
    }

    public void setDueDate(int dueDate) {
        this.dueDate = dueDate;
    }

    public double getAmont() {
        return amont;
    }

    public void setAmont(double amont) {
        this.amont = amont;
    }

    public int getStagesCount() {
        return stagesCount;
    }

    public void setStagesCount(int stagesCount) {
        this.stagesCount = stagesCount;
    }
}
