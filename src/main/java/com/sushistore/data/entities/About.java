/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sushistore.data.entities;


/**
 *
 * @author P5
 */
public class About {
    private String title;
    private String msgTtitle;
    private String msgText;
    private String servicePhone;

    public String getServicePhone() {
        return servicePhone;
    }

    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsgTtitle() {
        return msgTtitle;
    }

    public void setMsgTtitle(String msgTtitle) {
        this.msgTtitle = msgTtitle;
    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }
    
}
