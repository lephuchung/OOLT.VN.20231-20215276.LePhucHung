package AimsProject.src.hust.soict.hedspi.aims.cart;

import java.util.ArrayList;

import AimsProject.src.hust.soict.hedspi.aims.media.CompactDisc;
import AimsProject.src.hust.soict.hedspi.aims.media.DigitalVideoDisc;
import AimsProject.src.hust.soict.hedspi.aims.media.Media;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
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
            if (itemsOrdered.get(i) instanceof DigitalVideoDisc){
                System.out.println(i+1 + ". " + "DVD" + ". " + itemsOrdered.get(i).getTitle() +" - "+ itemsOrdered.get(i).getCategory() +" - "+ ((DigitalVideoDisc) itemsOrdered.get(i)).getDirector() +" - "+ ((DigitalVideoDisc) itemsOrdered.get(i)).getLength()+": "+itemsOrdered.get(i).getCost()+"$");
            } else if (itemsOrdered.get(i) instanceof CompactDisc) {
                System.out.println(i+1 + ". " + "CD" + ". " + itemsOrdered.get(i).getTitle() +" - "+ itemsOrdered.get(i).getCategory() +" - "+ ((CompactDisc) itemsOrdered.get(i)).getDirector() +" - "+ ((CompactDisc) itemsOrdered.get(i)).getArtist() +" - "+ ((CompactDisc) itemsOrdered.get(i)).getLength()+": "+itemsOrdered.get(i).getCost()+"$");
            } else {
                System.out.println(i+1 + ". " + "Book" + ". " + itemsOrdered.get(i).getTitle() +" - "+ itemsOrdered.get(i).getCategory() +": "+itemsOrdered.get(i).getCost()+"$");
            }

        }
        System.out.println("Total cost: " + totalCost() + "$");
        System.out.println("**************************************************");
    }
    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}