package org.example.Builder;

class StepProduct {
    private String productName;
    private String productDescription;
    private String productPrice;
    private String productWeight;

    private StepProduct(StepProductBuilder stepProductBuilder){
        this.productName = stepProductBuilder.productName;
        this.productDescription = stepProductBuilder.productDescription;
        this.productPrice = stepProductBuilder.productPrice;
        this.productWeight = stepProductBuilder.productWeight;
    }

    public void showDetails(){
        System.out.println("Presenting you our first product "+productName+": "+productDescription+" on a discounted price "+productPrice+" and a weight of "+productWeight);
    }

    public interface ProductName{
        //Perform checks and throw exceptions
        ProductDescription setProductName(String productName);
    }

    public interface ProductDescription{
        //Perform checks and throw exceptions
        ProductPrice setProductDescription(String productDescription);
    }

    public interface ProductPrice{
        //Perform checks and throw exceptions
        ProductWeight  setProductPrice(String productPrice);
    }

    public interface ProductWeight{
        //Perform checks and throw exceptions
        Build setProductWeight(String productWeight);
    }

    public interface Build{
        //Perform checks and throw exceptions
        StepProduct build();
    }


    public static class StepProductBuilder implements ProductName, ProductDescription, ProductPrice, ProductWeight, Build{
        private String productName;
        private String productDescription;
        private String productPrice;
        private String productWeight;

        public static StepProductBuilder start(){
            return new StepProductBuilder();
        }

        @Override
        public ProductDescription setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        @Override
        public ProductPrice setProductDescription(String productDescription) {
            this.productDescription = productDescription;
            return this;
        }

        @Override
        public ProductWeight setProductPrice(String productPrice) {
            this.productPrice = productPrice;
            return this;
        }

        @Override
        public Build setProductWeight(String productWeight) {
            this.productWeight = productWeight;
            return this;
        }

        @Override
        public StepProduct build() {
            return new StepProduct(this);
        }
    }
}

public class StepBuilder {
    public static void main(String args[]){

        StepProduct stepProduct = StepProduct.StepProductBuilder.start().setProductName("Mercedes-Benz CLK 500").setProductDescription("The Mercedes-Benz CLK 500 is a luxury coupe/convertible known for blending performance with comfort, typically featuring a powerful V8 engine (around 300-388 hp depending on year/tune), smooth automatic transmission, premium interiors (leather, memory seats, dual-zone climate), and advanced tech for its time").setProductPrice("84L").setProductWeight("1700KG").build();

        stepProduct.showDetails();

    }
}
