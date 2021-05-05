package com.iyang.boot.redission.async;

/**
 * @author : luohong
 * @desc :
 * @since : 2021/4/15 / 下午5:42
 */
public class NoticeSmsEvent extends SmsEvent {

    public NoticeSmsEvent(Long smsId, String telphone, String content) {
        super(smsId, telphone, content);
    }

}
