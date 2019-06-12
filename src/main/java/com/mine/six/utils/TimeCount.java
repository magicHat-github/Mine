package com.mine.six.utils;

/**
 * currentTimeMillis()粒度与OS有关，精度不够
 * @author xiaoyouming
 */
public class TimeCount {
    private static long startTime;
    private static long endTime;
    private static long time;
    public static long Start(){
        return startTime=System.nanoTime();
    }
    public static long End(){
        return endTime=System.nanoTime();
    }
    public static void getMillisTime(){
        System.out.println("运行时间为"+(endTime-startTime)/1000000+"ms");
    }
    public static void getNanoTime(){
        System.out.println("运行时间为"+(endTime-startTime)+"ns");
    }
    public static long getStartTime(){return startTime;}
    public static long getEndTime(){return endTime;}
    public static long getSecondTime(){
        return (endTime-startTime)/1000000000;
    }
}
