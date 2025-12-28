package org.example.Factory;
import java.util.HashMap;
import java.util.Map;

interface RegistryProduct{
void getDescription();
}

class RegistryConcreteProduct1 implements RegistryProduct{
    @Override
    public void getDescription() {
        System.out.println("Hi This is Product 1");
    }
}

class RegistryConcreteProduct2 implements RegistryProduct{
    @Override
    public void getDescription() {
        System.out.println("Hi This is Product 2");
    }
}

abstract class RegistryCreator{
    abstract RegistryProduct createProduct();
}

class RegistryConcreteCreator1 extends RegistryCreator{

    static{
        RegistryFactoryImpl.register("one", new RegistryConcreteCreator1());
    }

    @Override
    RegistryProduct createProduct() {
        System.out.println("Hi, this is creator 1");
        return new RegistryConcreteProduct1();
    }
}

class RegistryConcreteCreator2 extends RegistryCreator{

    static{
        RegistryFactoryImpl.register("two", new RegistryConcreteCreator2());
    }

    @Override
    RegistryProduct createProduct() {
        System.out.println("Hi, this is creator 2");
        return new RegistryConcreteProduct2();
    }
}

class RegistryFactoryImpl{
    private final static Map<String,RegistryCreator> registry = new HashMap<>();

    public static void register(String type, RegistryCreator registryCreator){
        registry.put(type,registryCreator);
    }

    public static RegistryCreator getCreator(String type){
        RegistryCreator registryCreator = registry.get(type.toLowerCase());

        if(registryCreator==null)
            throw new IllegalArgumentException("No such type found: "+ type);

        return registryCreator;
    }
}

public class RegistryFactory {
  public static void main(String args[]){
      String type = "one";
      RegistryCreator registryCreator = RegistryFactoryImpl.getCreator(type);
      RegistryProduct registryProduct = registryCreator.createProduct();
      registryProduct.getDescription();
  }

}
