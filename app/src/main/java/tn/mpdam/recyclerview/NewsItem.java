package tn.mpdam.recyclerview;

public class NewsItem {
    private String title;
    private String description;
    private int imageResource;


    public NewsItem(String title, String description,int imageResource) {
        this.title = title;
        this.description = description;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }
}
