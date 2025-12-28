package org.example.Factory;

interface GOFProduct{
    void getDescription();
}

class GOFConcreteProduct1 implements GOFProduct{
    @Override
    public void getDescription(){
        System.out.println("Hi I am Concrete Product 1");
    }
}

class GOFConcreteProduct2 implements GOFProduct{
    @Override
    public void getDescription(){
        System.out.println("Hi I am Concrete Product 2");
    }
}

abstract class GOFCreator{
    abstract GOFProduct createProduct();
}

class GOFConcreteCreator1 extends GOFCreator{
    @Override
    public GOFProduct createProduct(){
        System.out.println("Hi, this is creator 1");
        return new GOFConcreteProduct1();
    }
}

class GOFConcreteCreator2 extends GOFCreator{
    @Override
    public GOFProduct createProduct(){
        System.out.println("Hi, this is creator 2");
        return new GOFConcreteProduct2();
    }
}

public class GOFFactory {
    public static void main(String args[]){
        String type = "TWO";
        GOFCreator gofCreator = getCreator(type);
        GOFProduct gofProduct = gofCreator.createProduct();
        gofProduct.getDescription();
    }
    public static GOFCreator getCreator(String type){
        return switch(type.toLowerCase()){
            case "one"-> new GOFConcreteCreator1();
            case "two"-> new GOFConcreteCreator2();
            default -> throw new IllegalArgumentException("No such type found: "+type);
            };
        }
    }
