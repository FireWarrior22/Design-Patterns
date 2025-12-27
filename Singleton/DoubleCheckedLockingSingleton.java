package org.example.Singleton;

class DoubleCheckedLockingSingletonImpl{
    private static volatile DoubleCheckedLockingSingletonImpl doubleCheckedLockingSingleton;

    private DoubleCheckedLockingSingletonImpl(){}

    public static DoubleCheckedLockingSingletonImpl getInstance(){
        if(doubleCheckedLockingSingleton==null){
            synchronized(DoubleCheckedLockingSingletonImpl.class){
                if(doubleCheckedLockingSingleton==null){
                    doubleCheckedLockingSingleton=new DoubleCheckedLockingSingletonImpl();
                }
            }
        }
        return doubleCheckedLockingSingleton;
    }
}
class MyDCLRunnable implements Runnable{
    ThreadSafeSingletonImpl threadSafeSingleton;
    @Override
    public void run(){
        threadSafeSingleton = ThreadSafeSingletonImpl.getInstance();
    }
}

public class DoubleCheckedLockingSingleton {

    public static void main(String args[]) throws InterruptedException{
        MyDCLRunnable myDCLRunnable1 = new MyDCLRunnable();
        MyDCLRunnable myDCLRunnable2 = new MyDCLRunnable();

        Thread thread1=new Thread(myDCLRunnable1,"Thread1");
        Thread thread2=new Thread(myDCLRunnable2,"Thread2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.print("Both instances are same:");
        System.out.println( myDCLRunnable2.threadSafeSingleton.hashCode() == myDCLRunnable1.threadSafeSingleton.hashCode());
    }
}
