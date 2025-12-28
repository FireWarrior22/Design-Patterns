package org.example.Builder;

class FluentProduct{
    private String productName;
    private String productDescription;
    private  String productPrice;
    private String productWeight;

    private FluentProduct(FluentProductBuilder productBuilder){
        this.productName = productBuilder.productName;
        this.productDescription = productBuilder.productDescription;
        this.productPrice = productBuilder.productPrice;
        this.productWeight = productBuilder.productWeight;
    }

    public void showDetails(){
        System.out.println("Presenting you our first product "+productName+": "+productDescription+" on a discounted price "+productPrice+" and a weight of "+productWeight);
    }

    public static class FluentProductBuilder{
        String productName;
        String productDescription;
        String productPrice;
        String productWeight;

        public FluentProductBuilder setProductName(String productName){
            //Perform checks and throw exceptions
            this.productName = productName;
            return this;
        }

        public FluentProductBuilder setProductNDescription(String productDescription){
            //Perform checks and throw exceptions
            this.productDescription = productDescription;
            return this;
        }

        public FluentProductBuilder setproductPrice(String productPrice){
            //Perform checks and throw exceptions
            this.productPrice = productPrice;
            return this;
        }

        public FluentProductBuilder setproductWeight(String productWeight){
            //Perform checks and throw exceptions
            this.productWeight = productWeight;
            return this;
        }

        public FluentProduct build(){
            //Perform checks and throw exceptions
            return new FluentProduct(this);
        }

    }
}

public class FluentBuilder {

   public static void main(String args[]){
       FluentProduct product = new FluentProduct.FluentProductBuilder().setProductName("BMW 530d").setProductNDescription("The BMW 530d is a popular, powerful, and luxurious diesel variant of the 5 Series executive sedan, known for its strong torque from a 3.0L inline-6 turbo-diesel engine").setproductPrice("86L").setproductWeight("1500KG").build();

       product.showDetails();
   }


}
