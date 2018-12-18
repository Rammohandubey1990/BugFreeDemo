package com.example.bugfreeram.samyak.Models;

public class TransData {

    private int transId;
    private String transTitle;
    private String tranShortdesc;
    private int tranImage;

    public TransData(int transId, String transTitle, String tranShortdesc, int tranImage) {
        this.transId = transId;
        this.transTitle = transTitle;
        this.tranShortdesc = tranShortdesc;
        this.tranImage = tranImage;


    }

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public String getTransTitle() {
        return transTitle;
    }

    public void setTransTitle(String transTitle) {
        this.transTitle = transTitle;
    }

    public String getTranShortdesc() {
        return tranShortdesc;
    }

    public void setTranShortdesc(String tranShortdesc) {
        this.tranShortdesc = tranShortdesc;
    }

    public int getTranImage() {
        return tranImage;
    }

    public void setTranImage(int tranImage) {
        this.tranImage = tranImage;
    }
}
