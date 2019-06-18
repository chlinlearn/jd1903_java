package com.briup.enums;
/* *
 *@author:xuchunlin
 *@createTime:2019/6/18/14:14
 */

interface Info{
    public void test();
}

public enum TrafficLight implements Info{
    Red(60){
        @Override
        public TrafficLight next() {
            return Green;
        }
    },Yellow(3){
        @Override
        public TrafficLight next() {
            return Red;
        }
    },Green(12){
        @Override
        public TrafficLight next() {
            return Yellow;
        }
    };


    private int time;

    private TrafficLight(int time){
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    public abstract TrafficLight next();


    @Override
    public void test() {

    }
}
