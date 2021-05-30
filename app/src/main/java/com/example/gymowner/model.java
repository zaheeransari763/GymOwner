package com.example.gymowner;

public class model {

    private int image;
    private String description;
    private String title;

    public model(int image, String description, String title) {
        this.image = image;
        this.description = description;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
