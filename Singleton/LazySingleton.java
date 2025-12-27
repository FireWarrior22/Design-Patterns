package org.example.Singleton;

class LazySingletonImpl{
    private static LazySingletonImpl lazySingletonImpl;

    private LazySingletonImpl(){}

    public static LazySingletonImpl getInstance(){
        if(lazySingletonImpl==null){
            lazySingletonImpl = new LazySingletonImpl();
        }
        return lazySingletonImpl;
    }
}

public class LazySingleton {
    public static void main(String args[]){

        LazySingletonImpl classicSingleton1 = LazySingletonImpl.getInstance();
        LazySingletonImpl classicSingleton2 = LazySingletonImpl.getInstance();
        System.out.println(classicSingleton1 == classicSingleton2);

    }
}
