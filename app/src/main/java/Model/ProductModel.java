package Model;

public class ProductModel {
private String productname;
private String productdesc;
private String productimg;
public int rate;
public int amount;

    public ProductModel(String productname, String productdesc, String productimg, int rate) {
        this.productname = productname;
        this.productdesc = productdesc;
        this.productimg = productimg;
        this.rate = rate;
    }

    public ProductModel(String productname, String productdesc, String productimg, int rate, int amount) {
        this.productname = productname;
        this.productdesc = productdesc;
        this.productimg = productimg;
        this.rate = rate;
        this.amount = amount;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdesc() {
        return productdesc;
    }

    public void setProductdesc(String productdesc) {
        this.productdesc = productdesc;
    }

    public String getProductimg() {
        return productimg;
    }

    public void setProductimg(String productimg) {
        this.productimg = productimg;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
