package org.example.Observer;

import java.util.ArrayList;
import java.util.List;

interface PushObserver{
    void update(String newData);
}

interface Subject{
    void addObserver(PushObserver Observer);
    void removeObserver(PushObserver observer);
    void notifyObserver();
}

class ConcreteSubject implements Subject{

    private List<PushObserver> subscriptions = new ArrayList<>();
    String data;

    @Override
    public void addObserver(PushObserver observer) {
        subscriptions.add(observer);
    }

    @Override
    public void removeObserver(PushObserver observer) {
        subscriptions.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(PushObserver PushObserver:subscriptions){
            PushObserver.update(data);
        }
    }

    public void setNewData(String newData){
        this.data=newData;
        notifyObserver();
    }
}

class ConcretePushObserver implements PushObserver{
    private String data;

    @Override
    public void update(String newData) {
        data=newData;
        printData();
    }
    public void printData(){
        System.out.println("We have got new data: "+data);
    }
}

public class PushObserverMain {

   public static void main(String args[]){
       PushObserver observer=new ConcretePushObserver();
       ConcreteSubject subject = new ConcreteSubject();

       subject.addObserver(observer);
       subject.setNewData("New Data");
   }

}
