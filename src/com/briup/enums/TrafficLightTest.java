package com.briup.enums;

/* *
 * @author: xuchunlin
 * @createTime: 2019/6/18/14:18
 * @description: TODO
 */

public class TrafficLightTest {
    public static void main(String[] args) {
        TrafficLight[] trafficLights = TrafficLight.values();
        for (TrafficLight t:trafficLights){
            System.out.println(t+"亮了"+t.getTime()+"秒后"+t.next()+"亮");
            String n = t.name();
            int o = t.ordinal();
            System.out.println(n+" "+o);
        }
    }
}
