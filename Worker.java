package com.company;

import java.util.ArrayList;

public class Worker {
    private String name;
    private ArrayList<Workday> workdays;
    private Integer pay;

    //constructor
    public Worker(String name, int pay) {
        this.name = name;
        this.pay = pay;
        this.workdays = new ArrayList<Workday>();
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Workday> getWorkdays() {
        return workdays;
    }

    public void setWorkdays(ArrayList<Workday> workdays) {
        this.workdays = workdays;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }
    //method 1
    public int workingDays(){
        int days = 0;
        for(Workday day:workdays){
            if(day.workTime()>0)days++;
        }
        return days;
    }
    //method 2
    public int salary(){
        int sum = 0;
        for(Workday day:workdays){
            if (day.isExtra()){
                sum += (day.workTime()-8)*(pay*1.25)+(8*pay);
            }
             else sum += day.workTime()*pay;
        }
        return sum;
    }
    //method 3
    public Worker diligent(Worker other){
        int sumThis = 0;
        int sumOther =0;
        for(Workday day:this.workdays){
            sumThis += day.workTime();
        }
        for(Workday day:other.workdays){
            sumOther += day.workTime();
        }
        if(sumThis> sumOther)return this;
        else return other;
    }
    //amount of extra hours worked total
    public Integer overtimeHours(){
        int sum = 0;
        for(Workday day:workdays){
            if(day.isExtra()){
                sum+=day.workTime()-8;
            }
        }
        return sum;
    }
}
