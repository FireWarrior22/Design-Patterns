package org.example.Singleton;

class ClassicSingletonImpl{
    private final static ClassicSingletonImpl singleton = new ClassicSingletonImpl();

    private ClassicSingletonImpl(){}

    public static ClassicSingletonImpl getInstance(){
        return singleton;
    }
}

public class ClassicSingleton {
    public static void main(String args[]){

        ClassicSingletonImpl classicSingleton1 = ClassicSingletonImpl.getInstance();
        ClassicSingletonImpl classicSingleton2 = ClassicSingletonImpl.getInstance();


        System.out.println(classicSingleton1 == classicSingleton2);
    }
}
