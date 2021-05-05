package com.iyang.boot.redission.async;

/**
 * @author : luohong
 * @desc :
 * @since : 2021/4/15 / 下午5:42
 */
public class SmsEvent {

    private Long smsId;
    private String telphone;
    private String content;

    public SmsEvent() {
    }

    public SmsEvent(Long smsId, String telphone, String content) {
        this.smsId = smsId;
        this.telphone = telphone;
        this.content = content;
    }


    public Long getSmsId() {
        return smsId;
    }

    public void setSmsId(Long smsId) {
        this.smsId = smsId;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
