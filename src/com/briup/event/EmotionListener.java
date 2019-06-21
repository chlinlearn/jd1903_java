package com.briup.event;
/* *
 * @author: xuchunlin
 * @createTime: 2019/6/21/9:43
 * @description: 事件监听器
 */
public interface EmotionListener{
    public void sad(EmotionEvent e);
    public void happy(EmotionEvent e);
}