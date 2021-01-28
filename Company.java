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
        Worker most = allWorkers.get(0);
        int mostHours = 0;
        for(Worker alpha:allWorkers){
            int sum = 0;
            for(Workday day:alpha.getWorkdays()) {
                sum += day.workTime();
            }
            if(sum > mostHours) {
                most = alpha;
                mostHours = sum;
            }
        }
        return most;
    }

    //method 4
    void addWorker(Worker w) { allWorkers.add(w); }

    //method 5
    void crisis() {
        ArrayList<Worker> mostOvertime = new ArrayList<>();
        ArrayList<Worker> highestPayed = new ArrayList<>();
        //sorting workers by most overtime
        Collections.sort(allWorkers, new Comparator<Worker>() {
            @Override
            public int compare(Worker o1, Worker o2) {return o1.overtimeHours().compareTo(o2.overtimeHours());}
        });
        //adding the highest 25% to mostOvertime
        for (int i = allWorkers.size()-1;i>= (allWorkers.size()*0.75);i--) {
            mostOvertime.add(allWorkers.get(i));
        }
        //sorting workers by highest pay
        Collections.sort(allWorkers,((o1, o2) -> o1.getPay().compareTo(o2.getPay())));
        //adding the highest 25% to highestPayed
        for (int i = allWorkers.size()-1;i>= allWorkers.size()*0.75;i--) {
            highestPayed.add(allWorkers.get(i));
        }
        //remove most overtime
        for (Worker hoursWorker:mostOvertime){
            if(allWorkers.contains(hoursWorker)){
                allWorkers.remove(hoursWorker);
            }
        }
        //remove highest payed
        for (Worker payedWorker : highestPayed){
            if(allWorkers.contains(payedWorker)){
                allWorkers.remove(payedWorker);
            }
        }
    }
}
