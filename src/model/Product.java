package model;

public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String category;

    public Product(String id, String name, double price, int quantity, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public Product(String p001, String laptop, int i, double d) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        return id + "," + name + "," + price + "," + quantity + "," + category;
    }
}
