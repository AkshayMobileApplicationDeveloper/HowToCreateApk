package com.example.howtocreateapk.Model;

public class ContactModel {
    int idImageViewPro;
    String idTextViewName;
    String idTextViewContact;
    String idTextViewMsg;
    String idTextTiming;


    public ContactModel(int idImageViewPro, String idTextViewName, String idTextViewContact, String idTextViewMsg, String idTextTiming) {
        this.idImageViewPro = idImageViewPro;
        this.idTextViewName = idTextViewName;
        this.idTextViewContact = idTextViewContact;
        this.idTextViewMsg = idTextViewMsg;
        this.idTextTiming = idTextTiming;
    }


    public int getIdImageViewPro() {
        return idImageViewPro;
    }

    public void setIdImageViewPro(int idImageViewPro) {
        this.idImageViewPro = idImageViewPro;
    }

    public String getIdTextViewName() {
        return idTextViewName;
    }

    public void setIdTextViewName(String idTextViewName) {
        this.idTextViewName = idTextViewName;
    }

    public String getIdTextViewContact() {
        return idTextViewContact;
    }

    public void setIdTextViewContact(String idTextViewContact) {
        this.idTextViewContact = idTextViewContact;
    }

    public String getIdTextViewMsg() {
        return idTextViewMsg;
    }

    public void setIdTextViewMsg(String idTextViewMsg) {
        this.idTextViewMsg = idTextViewMsg;
    }

    public String getIdTextTiming() {
        return idTextTiming;
    }

    public void setIdTextTiming(String idTextTiming) {
        this.idTextTiming = idTextTiming;
    }
}
