package com.company;

public class Time {

    int hour;
    int minute;

    public Time(int hour, int minute) {

        this.hour = hour;
        this.minute = minute;
    }

    // מחשבת את ההפרש בין 2 זמנים ומחזירה עצם מסוג זמן עם הערכים
    public Time difference(Time t) {

        int hour = this.hour - t.hour;
        int minute = this.minute - t.minute;

        if (minute < 0 && hour > 0) {
            hour--;
            minute += 60;
        }

        return new Time(Math.abs(hour), Math.abs(minute));
    }

    // מחשבת את הזמן הנוכחי כמספר עשרוני של שעות
    public double inHours() {

        return (hour + minute / 60);
    }

}
