package be.evoliris.formation.demo_fragment.models;

public class Product {

    private long id;
    private String name;
    private String category;
    private int resImage;

    public Product(long id, String name, String category, int resImage) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.resImage = resImage;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getResImage() {
        return resImage;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setResImage(int resImage) {
        this.resImage = resImage;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", getCategory().toUpperCase(), getName());
    }
}
