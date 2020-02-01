package Model;

public class CategoryModel {

    private String Cat_img;
    private String Cat_name;


    public CategoryModel(String cat_img, String cat_name) {
        Cat_img = cat_img;
        Cat_name = cat_name;
    }

    public String getCat_img() {
        return Cat_img;
    }

    public void setCat_img(String cat_img) {
        Cat_img = cat_img;
    }

    public String getCat_name() {
        return Cat_name;
    }

    public void setCat_name(String cat_name) {
        Cat_name = cat_name;
    }
}


