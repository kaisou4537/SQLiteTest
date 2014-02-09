package com.example.app;

/**
 * Created by kaisou4537 on 2014/02/09.
 */
public class DBData {
    private int id;
    private String memo;
    private int priority;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getMemo(){
        return memo;
    }

    public void setMemo(String memo){
        this.memo = memo;
    }

    public int getPriority(){
        return priority;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }

}
