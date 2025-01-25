package model;

public class Category {
    private String id;
    private String name;

    // Constructor
    public Category(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString Method (For Saving to File)
    @Override
    public String toString() {
        return id + "," + name; // Save as "ID,Name" format
    }

    // Static Method to Create a Categories Object from a File String
    public static Category fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 2) {
            return new Category(parts[0], parts[1]);
        } else {
            throw new IllegalArgumentException("Invalid category format: " + line);
        }
    }
}
