package org.example.Builder;

class OptionalStepProduct {
    private String productName;
    private String productDescription;
    private String productPrice;
    private String productDiscount;
    private String productWeight;

    private OptionalStepProduct(OptionalStepProductBuilder optionalStepBuilder){
        this.productName = optionalStepBuilder.productName;
        this.productDescription = optionalStepBuilder.productDescription;
        this.productPrice = optionalStepBuilder.productPrice;
        this.productDiscount = productDiscount;
        this.productWeight = optionalStepBuilder.productWeight;
    }

    public void showDetails(){
        System.out.println("Presenting you our first product "+productName+": "+productDescription+" on a discounted price "+productPrice+" and a weight of "+productWeight);
    }

    public interface OptionalProductName{
        //Perform checks and throw exceptions
        OptionalProductDescription setOptionProductionName(String productName);
    }

    public interface OptionalProductDescription{
        //Perform checks and throw exceptions
        OptionalStep setOptionalProductionDescription(String productDescription);
    }

    public interface OptionalStep{
        //Perform checks and throw exceptions
        OptionalStep setOptionalProductionPrice(String productPrice);
        OptionalStep setOptionalProductionDiscount(String productDiscount);
        OptionalStep setOptionalProductionWeight(String productWeight);
        OptionalStepProduct build();
    }
    public interface Build{
        OptionalStepProduct build();
    }

    public static class OptionalStepProductBuilder implements OptionalProductName, OptionalProductDescription, OptionalStep, Build{
        private String productName;
        private String productDescription;
        private String productPrice;
        private String productDiscount;
        private String productWeight;

        public static OptionalStepProductBuilder start(){
            return new OptionalStepProductBuilder();
        }
        @Override
        public OptionalProductDescription setOptionProductionName(String productName) {
            this.productName = productName;
            return this;
        }

        @Override
        public OptionalStep setOptionalProductionDescription(String productDescription) {
            this.productDescription = productDescription;
            return this;
        }

        @Override
        public OptionalStep setOptionalProductionPrice(String productPrice) {
            this.productPrice=productPrice;
            return this;
        }

        @Override
        public OptionalStep setOptionalProductionDiscount(String productDiscount) {
            this.productDiscount=productDiscount;
            return this;
        }

        @Override
        public OptionalStep setOptionalProductionWeight(String productWeight) {
            this.productWeight=productWeight;
            return this;
        }

        @Override
        public OptionalStepProduct build() {
            return new OptionalStepProduct(this);
        }
    }
}

public class OptionalStepBuilder{
    public static void main(String args[]){
        OptionalStepProduct optionalStepProduct = OptionalStepProduct.OptionalStepProductBuilder.start().setOptionProductionName("Mercedes-Benz CLK 500").setOptionalProductionDescription("The Mercedes-Benz CLK 500 is a luxury coupe/convertible known for blending performance with comfort, typically featuring a powerful V8 engine (around 300-388 hp depending on year/tune), smooth automatic transmission, premium interiors (leather, memory seats, dual-zone climate), and advanced tech for its time").setOptionalProductionPrice("84L").build();

        optionalStepProduct.showDetails();
    }
}
