package org.example.Singleton;

class ThreadSafeSingletonImpl{
    private static ThreadSafeSingletonImpl threadSafeSingleton;

    private ThreadSafeSingletonImpl(){}

    public static synchronized ThreadSafeSingletonImpl getInstance(){
        if(threadSafeSingleton == null){
            threadSafeSingleton = new ThreadSafeSingletonImpl();
            System.out.println("Thread "+Thread.currentThread().getName()+" created the singleton instance");        }
        return threadSafeSingleton;
    }
}

class MyRunnable implements Runnable{
    ThreadSafeSingletonImpl threadSafeSingleton;
    @Override
    public void run(){
        threadSafeSingleton = ThreadSafeSingletonImpl.getInstance();
    }
}
public class ThreadSafeSingleton {
    public static void main(String args[]) throws InterruptedException{

        MyRunnable myRunnable1 = new MyRunnable();
        MyRunnable myRunnable2 = new MyRunnable();

        Thread thread1 = new Thread(myRunnable1,"Thread1");
        Thread thread2 = new Thread(myRunnable2,"Thread2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.print("Both instances are same:");
        System.out.println( myRunnable2.threadSafeSingleton.hashCode() == myRunnable1.threadSafeSingleton.hashCode());

    }
}
