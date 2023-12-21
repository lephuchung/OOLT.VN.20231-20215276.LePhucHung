package AimsProject.src.hust.soict.hedspi.aims.cart;

import java.util.ArrayList;

import AimsProject.src.hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    private ObservableList<Media> viewFilter;
    public void addMedia(Media d) {
        itemsOrdered.add(d);
        System.out.println("The media has been added!");
    }
    public void addMedia(Media [] dList) {
        for (Media disc: dList) {
            addMedia(disc);
        }
    }
    public void addMedia(Media d1,Media d2) {
        addMedia(d1);
        addMedia(d2);
    }

    public void removeMedia (Media d) {
        try {
            itemsOrdered.remove(d);
            System.out.println("The media is removed!");
        }
        catch (Exception e) {
            System.out.println("Media has not been added yet!");
            return ;
        }
    }
    public float totalCost() {
        float total = 0;
        for(int i= 0; i< itemsOrdered.size(); i++) {
            total += itemsOrdered.get(i).getCost();
        }
        return total;
    }
    public void print() {
        System.out.println("***********************CART***********************");
        for (int i = 0; i < this.itemsOrdered.size(); i++ ) {
            System.out.println(i+1 + ". " + itemsOrdered.get(i));
        }
        System.out.println("Total cost: " + totalCost() + "$");
        System.out.println("**************************************************");
    }
    public ObservableList<Media> getItemsOrdered() {
        return (ObservableList<Media>) itemsOrdered;
    }

    public void searchId(int id) {
        for(Media item: itemsOrdered) {
            if(item.getId() == id) {
                System.out.println(item);
                return ;
            }
        }
        System.out.println("No media is matched!");
    }
    public void searchTitle(String title) {
        for(Media item: itemsOrdered) {
            if(item.getTitle().equals(title)) {
                System.out.println(item);
                return ;
            }
        }
        System.out.println("No media is matched!");
    }

    public ObservableList<Media> filterId(String str) {
        viewFilter = FXCollections.observableArrayList();
        for (int i = 0; i < this.itemsOrdered.size(); i++) {
            if (str.length() > String.valueOf(this.itemsOrdered.get(i).getId()).length()) {
                continue;
            } else if (String.valueOf(this.itemsOrdered.get(i).getId()).substring(0, str.length()).equals(str)) {
                viewFilter.add(this.itemsOrdered.get(i));
            }
        }
        return viewFilter;
    }

    public ObservableList<Media> filterTitle(String str) {
        viewFilter = FXCollections.observableArrayList();
        for (int i = 0; i < this.itemsOrdered.size(); i++) {
            if (str.length() > String.valueOf(this.itemsOrdered.get(i).getTitle()).length()) {
                continue;
            } else if (this.itemsOrdered.get(i).getTitle().substring(0, str.length()).equals(str)) {
                viewFilter.add(this.itemsOrdered.get(i));
            }
        }
        return viewFilter;
    }
}