package org.example.Singleton;

enum ENUMSingletonImpl{
    INSTANCE;
}
public class ENUMSingleton {

    public static void main(String args[]){
        ENUMSingletonImpl classicSingleton1 = ENUMSingletonImpl.INSTANCE;
        ENUMSingletonImpl classicSingleton2 = ENUMSingletonImpl.INSTANCE;


        System.out.println(classicSingleton1 == classicSingleton2);

    }
}
