package com.briup.event;
/* *
 * @author: xuchunlin
 * @createTime: 2019/6/21/9:43
 * @description: 事件
 */
public class EmotionEvent {
    private String message;
    private Girl girl;//事件源

    public EmotionEvent(String massage,Girl girl){
        this.girl = girl;
        this.message = massage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }
}