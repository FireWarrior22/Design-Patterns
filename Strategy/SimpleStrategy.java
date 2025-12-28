package org.example.Strategy;

interface StrategyType{
    void doWork();
}
class StrategyType1 implements StrategyType{
    @Override
    public void doWork() {
        System.out.println("Type 1 is being used");
    }
}
class StrategyType2 implements StrategyType{
    @Override
    public void doWork() {
        System.out.println("Type 2 is being used");
    }
}
class StrategyType3 implements StrategyType{
    @Override
    public void doWork() {
        System.out.println("Type 3 is being used");
    }
}

class ActualWork{
    private StrategyType strategyType;

    public ActualWork(StrategyType strategyType){
        this.strategyType=strategyType;
    }

    public void doWork(){
        strategyType.doWork();
    }
}
public class SimpleStrategy {
    public static void main(String args[]){
        StrategyType strategyType = new StrategyType1();
        ActualWork actualWork=new ActualWork(strategyType);
        actualWork.doWork();
    }
}
