package com.portfolio.api.data.v1.dto.mail;

public class MailDTO {
    private String senderName;
    private String senderMail;
    private String message;

    public MailDTO() {}

    public MailDTO(String senderName, String senderMail, String message) {
        this.senderName = senderName;
        this.senderMail = senderMail;
        this.message = message;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderMail() {
        return senderMail;
    }

    public void setSenderMail(String senderMail) {
        this.senderMail = senderMail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
