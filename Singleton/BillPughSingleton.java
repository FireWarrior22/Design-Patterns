package org.example.Singleton;

class BillPughSingletonImpl{

    private BillPughSingletonImpl(){}

    private static class Inner{
        private static final BillPughSingletonImpl billPughSingleton = new BillPughSingletonImpl();
    }

    public static BillPughSingletonImpl getInstance(){
        return Inner.billPughSingleton;
    }
}

public class BillPughSingleton {

    public static void main(String args[]){
        BillPughSingletonImpl classicSingleton1 = BillPughSingletonImpl.getInstance();
        BillPughSingletonImpl classicSingleton2 = BillPughSingletonImpl.getInstance();
        System.out.println(classicSingleton1 == classicSingleton2);
    }
}
