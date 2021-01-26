package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Company {
    String name;
    ArrayList<Worker> allWorkers;
    ArrayList<Integer> sales;
    //constructor
    public Company(String name) {
        this.name = name;
        allWorkers = new ArrayList<Worker>();
        sales = new ArrayList<Integer>();
    }

    //method 1
    public int totalPayments() {
        int sum = 0;
        for(Worker alpha:allWorkers){
            sum += alpha.salary();
        }
        return sum;
    }

    //method 2
    public int totalEarnings() {
        int sum = 0;
        for(Integer alpha:sales){
            sum += alpha;
        }
        return sum;
    }

    //method 3
    Worker workedMost() {
        Worker most = allWorkers.get(0).getWorkdays().w;
        for(Worker alpha:allWorkers){
            int sum = 0;
            for(Workday day:alpha.getWorkdays()) {
                sum += day.workTime();
            }
            if(alpha.workingDays()> most.workingDays()) {
                most = alpha;
            }
        }
        return most;
    }

    //method 4
    void addWorker(Worker w) { allWorkers.add(w); }

    //method 5
//    void crisis() {
//        ArrayList<Worker> highestPayed= allWorkers;
//        ArrayList<Worker> mostOvertime= allWorkers;
//        Comparator<Worker> compareByPay = new Comparator<Worker>() {
//            @Override
//            public int compare(Worker o1, Worker o2) {
//                return o1.getPay().compareTo(o2.getPay());
//            }
//        };
//
//
//
//
//
//        Collections.sort(highestPayed);
//        for (int i = 0;i<allWorkers.size();i++){
//            if (highestPayed.size()<= allWorkers.size()/4){
//                highestPayed.add(allWorkers.get(i));
//                else{
//
//                }
//            }
//        }
//    }
}
