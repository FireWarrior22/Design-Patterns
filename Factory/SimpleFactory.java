package org.example.Factory;

interface SimpleProduct{
    void getDescription();
}

class SimpleConcreteProduct1 implements SimpleProduct{
    @Override
    public void getDescription(){
        System.out.println("Hi I am Concrete Product 1");
    }
}

class SimpleConcreteProduct2 implements SimpleProduct{
    @Override
    public void getDescription(){
        System.out.println("Hi I am Concrete Product 2");
    }
}

class SimpleConcreteProduct3 implements SimpleProduct{
    @Override
    public void getDescription(){
        System.out.println("Hi I am Concrete Product 3");
    }
}


class SimpleFactoryImpl{
    public static SimpleProduct getProduct(String type){
        return switch (type.toLowerCase()) {
            case "one" -> new SimpleConcreteProduct1();
            case "two" -> new SimpleConcreteProduct2();
            case "three" -> new SimpleConcreteProduct3();
            default -> throw new IllegalArgumentException("No product type found");
        };
    }

}

public class SimpleFactory {
    public static void main(String args[]){

        String type = "one";
        SimpleProduct product = SimpleFactoryImpl.getProduct("one");
        product.getDescription();

    }
}
