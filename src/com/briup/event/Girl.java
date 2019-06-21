package com.briup.event;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/21/9:43
 * @description: 事件源产生事件，并将事件对象推送给事件监听器
 */

import java.util.HashSet;
import java.util.Set;

public class Girl {
    private String name;
    private Set<EmotionListener> listeners;//事件监听器列表

    public Girl(){}
    public Girl(String name){
        this.name = name;
        listeners = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //添加事件监听器
    public void addEmotionListener(EmotionListener e){
        listeners.add(e);
    }

    public void removeEmotionListener(EmotionListener e){
        listeners.remove(e);
    }
    //产生事件并推送给事件监听器
    public void laugh(){
        EmotionEvent event = new EmotionEvent("哈哈大笑",this);
        for (EmotionListener boy:listeners){
            boy.happy(event);
        }
    }
    public void cry(){
        EmotionEvent event = new EmotionEvent("伤心大哭",this);
        for (EmotionListener boy:listeners){
            boy.sad(event);
        }
    }

}
