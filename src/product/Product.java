package product;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private int price;
    private String productCode;
    private String status;
    private String description;



    public Product(String name, int price, String productCode, String status, String description) {
        this.name = name;
        this.price = price;
        this.productCode = productCode;
        this.status=status;
        this.description=description;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString(){
        return "name "+ getName()+", price "+getPrice()+", id "+getProductCode()+",status: "+getStatus()+","+getDescription();
    }

}
