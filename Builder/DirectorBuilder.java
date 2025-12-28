package org.example.Builder;

class DirectorProduct{
    private String productName;
    private String productDescription;
    private String productPrice;
    private String productWeight;

    public void buildProductName(String productName){
        this.productName=productName;
    }

    public void buildProductDescription(String productDescription){
        this.productDescription=productDescription;
    }

    public void buildProductPrice(String productPrice){
        this.productPrice=productPrice;
    }

    public void buildProductWeight(String productWeight){
        this.productWeight=productWeight;
    }

    public void showDetails(){
        System.out.println("Presenting you our first product "+productName+": "+productDescription+" on a discounted price "+productPrice+" and a weight of "+productWeight);
    }
}

interface DirectorProductBuilder{

    void buildName();
    void buildDescription();
    void buildPrice();
    void buildWeight();
    DirectorProduct getResult();
}

class ProductBuilder1 implements DirectorProductBuilder{

    DirectorProduct directorProduct=new DirectorProduct();

    @Override
    public void buildName() {
        directorProduct.buildProductName("BMW 530d");
    }

    @Override
    public void buildDescription() {
        directorProduct.buildProductDescription("The BMW 530d is a popular, powerful, and luxurious diesel variant of the 5 Series executive sedan, known for its strong torque from a 3.0L inline-6 turbo-diesel engine");
    }

    @Override
    public void buildPrice() {
        directorProduct.buildProductPrice("86L");
    }

    @Override
    public void buildWeight() {
        directorProduct.buildProductWeight("1500KG");
    }

    @Override
    public DirectorProduct getResult() {
        return directorProduct;
    }
}

class ProductBuilder2 implements DirectorProductBuilder{

    DirectorProduct directorProduct=new DirectorProduct();

    @Override
    public void buildName() {
        directorProduct.buildProductName("Mercedes-Benz CLK 500");
    }

    @Override
    public void buildDescription() {
        directorProduct.buildProductDescription("The Mercedes-Benz CLK 500 is a luxury coupe/convertible known for blending performance with comfort, typically featuring a powerful V8 engine (around 300-388 hp depending on year/tune), smooth automatic transmission, premium interiors (leather, memory seats, dual-zone climate), and advanced tech for its time");
    }

    @Override
    public void buildPrice() {
        directorProduct.buildProductPrice("84L");
    }

    @Override
    public void buildWeight() {
        directorProduct.buildProductWeight("1700KG");
    }

    @Override
    public DirectorProduct getResult() {
        return directorProduct;
    }
}

class Director{

    private DirectorProductBuilder directorProductBuilder;

    public Director(DirectorProductBuilder directorProductBuilder){
        this.directorProductBuilder = directorProductBuilder;
    }
    public DirectorProduct build(){
        directorProductBuilder.buildName();
        directorProductBuilder.buildDescription();
        directorProductBuilder.buildPrice();
        directorProductBuilder.buildWeight();
        return directorProductBuilder.getResult();
    }
}

public class DirectorBuilder {
    public static void main(String args[]){

        ProductBuilder2 productBuilder2 = new ProductBuilder2();
        Director director=new Director(productBuilder2);
        DirectorProduct product = director.build();
        product.showDetails();

    }
}
