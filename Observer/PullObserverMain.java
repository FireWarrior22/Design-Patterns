package org.example.Observer;

import java.util.ArrayList;
import java.util.List;

interface PullObserver{
    void update();
}

interface PullSubject{
    void addObserver(PullObserver observer);
    void removeObserver(PullObserver observer);
    void notifyObserver();
}

class ConcretePullSubject implements PullSubject{
    private List<PullObserver> observers = new ArrayList<>();
    String data;

    @Override
    public void addObserver(PullObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(PullObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(PullObserver observers:observers){
            observers.update();
        }
    }

    public String getdata(){
        return data;
    }

    public void setData(String newData){
        this.data=newData;
        notifyObserver();
    }
}

class ConcretePullObserver implements PullObserver{
    private String data;
    private final ConcretePullSubject concretePullSubject = new ConcretePullSubject();
    @Override
    public void update() {
        data = concretePullSubject.getdata();
        printData(data);
    }

    public void printData(String data){
        System.out.println("We have got new data: "+data);
    }
}

public class PullObserverMain {

 public static void main(String args[]){
     PullObserver observer=new ConcretePullObserver();
     ConcretePullSubject subject = new ConcretePullSubject();
      subject.addObserver(observer);
      subject.setData("New Data");
 }

}
