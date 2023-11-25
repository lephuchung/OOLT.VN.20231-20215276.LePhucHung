package AimsProject.src.hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import AimsProject.src.hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Store {
    private ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();
    private int numItems = 0;
    public void addDVD(DigitalVideoDisc dvd) {
        itemsInStore.add(dvd);
        numItems++;
        System.out.println("The disc is added to store!");
    }
    public void removeDVD(DigitalVideoDisc dvd) {
        try {
            itemsInStore.remove(dvd);
            numItems--;
            System.out.println("The disc is removed from store!");
        }
        catch (Exception e) {
            System.out.println("Disc doesn't exist!");
        }
    }
    public int getNumItems() {
        return numItems;
    }
}
