package org.example.Builder;

class ImmutableProduct{
    private final String productName;
    private final String productDescription;
    private final String productPrice;
    private final String productWeight;

    private ImmutableProduct(ImmutableProductBuilder productBuilder){
        this.productName = productBuilder.productName;
        this.productDescription = productBuilder.productDescription;
        this.productPrice = productBuilder.productPrice;
        this.productWeight = productBuilder.productWeight;
    }

    //getters only (no setters)
    public String getProductName() {
        return productName;
    }

    public String getProductWeight() {
        return productWeight;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void showDetails(){
        System.out.println("Presenting you our first product "+productName+": "+productDescription+" on a discounted price "+productPrice+" and a weight of "+productWeight);
    }

    public static class ImmutableProductBuilder{
        String productName;
        String productDescription;
        String productPrice;
        String productWeight;

        public ImmutableProductBuilder setProductName(String productName){
            //Perform checks and throw exceptions
            this.productName = productName;
            return this;
        }

        public ImmutableProductBuilder setProductNDescription(String productDescription){
            //Perform checks and throw exceptions
            this.productDescription = productDescription;
            return this;
        }

        public ImmutableProductBuilder setproductPrice(String productPrice){
            //Perform checks and throw exceptions
            this.productPrice = productPrice;
            return this;
        }

        public ImmutableProductBuilder setproductWeight(String productWeight){
            //Perform checks and throw exceptions
            this.productWeight = productWeight;
            return this;
        }

        public void validate(ImmutableProductBuilder immutableProductBuilder){

            if(immutableProductBuilder.productName.isBlank())
                throw new IllegalStateException("Name cannot be empty");
            if(immutableProductBuilder.productDescription.isBlank())
                throw new IllegalStateException("Description cannot be empty");
            if(immutableProductBuilder.productPrice.isBlank())
                throw new IllegalStateException("Price cannot be empty");
            if(immutableProductBuilder.productWeight.isBlank())
                throw new IllegalStateException("Weight cannot be empty");
        }
        public ImmutableProduct build(){
            //Perform checks and throw exceptions
            validate(this);
            return new ImmutableProduct(this);
        }
    }
}

public class ImmutableProductBuilder {

    public static void main(String args[]){
        FluentProduct product = new FluentProduct.FluentProductBuilder().setProductName("BMW 530d").setProductNDescription("The BMW 530d is a popular, powerful, and luxurious diesel variant of the 5 Series executive sedan, known for its strong torque from a 3.0L inline-6 turbo-diesel engine").setproductPrice("86L").setproductWeight("1500KG").build();

        product.showDetails();
    }


}
