package org.example.Factory;

import java.util.HashMap;
import java.util.Map;

interface ConfigProduct{
    void getDescription();
}

class ConfigProduct1 implements ConfigProduct{
    @Override
    public void getDescription() {
       System.out.println("Hi, this is config product 1");
    }
}

class ConfigProduct2 implements ConfigProduct{
    @Override
    public void getDescription() {
        System.out.println("Hi, this is config product 2");
    }
}

abstract class ConfigCreator{
    abstract ConfigProduct createProduct();
}

class ConfigConcreteCreator1 extends ConfigCreator{

    @Override
    public ConfigProduct createProduct(){
        System.out.println("Hi, this is creator 1");
        return new ConfigProduct1();
    }
}

class ConfigConcreteCreator2 extends ConfigCreator{
    @Override
    public ConfigProduct createProduct(){
        System.out.println("Hi, this is creator 2");
        return new ConfigProduct1();
    }
}

class ConfigFactoryImpl{
    private final static Map<String,ConfigCreator> map = new HashMap<>();

    static{
        map.put("one", new ConfigConcreteCreator1());
        map.put("two", new ConfigConcreteCreator2());
    }

    public static ConfigCreator getCreator(String type){
        return switch(type.toLowerCase()){
            case "one"-> new ConfigConcreteCreator1();
            case "two"-> new ConfigConcreteCreator2();
            default -> throw new IllegalArgumentException("No such type found: "+type);
        };
    }

}
public class ConfigFactory {
    public static void main(String args[]){

        String type="one";
        ConfigCreator configCreator = ConfigFactoryImpl.getCreator(type);
        ConfigProduct configProduct = configCreator.createProduct();
        configProduct.getDescription();

    }
}
