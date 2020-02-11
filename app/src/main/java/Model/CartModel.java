package Model;

import Adapter.ProductAdapter;

public class CartModel {
    private User usercart;
    private ProductModel productcart;
    private int quantity;

    public CartModel(User usercart, ProductModel productcart, int quantity) {
        this.usercart = usercart;
        this.productcart = productcart;
        this.quantity = quantity;
    }

    public User getUsercart() {
        return usercart;
    }

    public void setUsercart(User usercart) {
        this.usercart = usercart;
    }

    public ProductModel getProductcart() {
        return productcart;
    }

    public void setProductcart(ProductModel productcart) {
        this.productcart = productcart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
