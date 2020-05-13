package id.corp.examplerabbitmqconsumer.model;

import java.io.Serializable;

public class ProductDetails implements Serializable {

    private int productId;
    private String productName;
    private String categoryId;
    private String categoryName;

    public ProductDetails(){}

//    public ProductDetails(int productId, String productName, String categoryId, String categoryName){
//        this.productId = productId;
//        this.productName = productName;
//        this.categoryId = categoryId;
//        this.categoryName = categoryName;
//    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
