package com.company;

public class Date {

    int day;
    int month;
    int year;

    public Date(int day,int month,int year) {

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date earilerDate(Date other) {

        if (year < other.year) return this;
        else if (year > other.year) return other;

        if (month < other.month) return this;
        else if (month > other.month) return other;

        if (day < other.day) return this;
        else if (day > other.day) return other;

        return null;
    }

    public void printDate() {

        System.out.println(day + "/" + month + "/" + year);
    }

    public boolean isLegal() {

        // basic check
        if (day < 1 || day > 31) return false;
        if (month < 1 || month > 12) return false;

        // day to month check
        if (day == 31) {
            if (month == 4 || month == 6 || month == 9 || month == 11) return false;
        }

        // leap year
        if (month == 2) {

            if (day > 28 && day != 29) return false;

            if (year % 4 != 0) return false;
            if (year % 100 == 0 && year % 400 != 0) return false;
        }

        return true;
    }
}
