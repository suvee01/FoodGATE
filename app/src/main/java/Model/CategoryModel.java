package Model;

public class CategoryModel {

    private int Cat_img;
    private String Cat_name;

    public CategoryModel(int cat_img, String cat_name) {
        Cat_img = cat_img;
        Cat_name = cat_name;
    }

    public int getCat_img() {
        return Cat_img;
    }

    public void setCat_img(int cat_img) {
        Cat_img = cat_img;
    }

    public String getCat_name() {
        return Cat_name;
    }

    public void setCat_name(String cat_name) {
        Cat_name = cat_name;
    }
}


