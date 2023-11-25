package AimsProject.src.hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class Media {

    int id;
    String title;
    String category;
    float cost;

    public Media() {
        // TODO Auto-generated constructor stub
    }

    public Media(int id, String title, String category, float cost) {
        this(category, title, cost);
        this.setId(id);
    }

    public Media(String title){
        this.setTitle(title);
    }

    public Media(String title, String category, float cost){
        this(title);
        this.setCategory(category);
        this.setCost(cost);
    }


    @Override
    public boolean equals(Object object) {
        if(object instanceof Media) {
            Media media = (Media) object;
            return media.getTitle().equals(this.getTitle());
        }
        return false;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }

}