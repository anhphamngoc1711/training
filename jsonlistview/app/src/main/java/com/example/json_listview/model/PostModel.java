package com.example.json_listview.model;

public class PostModel {
    private String date;
    private TitleModel title;
    private Excerpt excerpt;
    private ImageModel better_featured_image;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public TitleModel getTitle() {
        return title;
    }

    public void setTitle(TitleModel title) {
        this.title = title;
    }

    public Excerpt getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(Excerpt excerpt) {
        this.excerpt = excerpt;
    }

    public ImageModel getBetter_featured_image() {
        return better_featured_image;
    }

    public void setBetter_featured_image(ImageModel better_featured_image) {
        this.better_featured_image = better_featured_image;
    }
}
