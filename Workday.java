package com.company;

public class Workday {
    private Date date;
    private Time start;
    private Time end;
    //constructor
    public Workday(Date date) {
        this.date = date;
        this.start = new Time(9,0);
        this.end = new Time(17,0);
    }
    //getters and setters
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }
    //method 1
    public double workTime(){
        return this.end.hour - this.start.hour + (this.end.minute - this.start.minute)/60;
    }
    //method 2
    public boolean isExtra(){
        if(this.workTime()>8)return true;
        else return false;
    }

}
