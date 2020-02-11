package Model;

public class CartModel {

private String usercart;
private String product;

    public CartModel(String usercart, String product) {
        this.usercart = usercart;
        this.product = product;
    }

    public String getUsercart() {
        return usercart;
    }

    public void setUsercart(String usercart) {
        this.usercart = usercart;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
