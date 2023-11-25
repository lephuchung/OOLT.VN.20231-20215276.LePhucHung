package AimsProject.src.hust.soict.hedspi.aims.cart;

import java.util.*;
import AimsProject.src.hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<DigitalVideoDisc> itemOrdered = new ArrayList<DigitalVideoDisc>();
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if(qtyOrdered<MAX_NUMBERS_ORDERED) {
            itemOrdered.add(disc);
            qtyOrdered += 1;
            System.out.println("The disc has been added");
        }
        else {
            System.out.println("The cart is full, can't add");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
        for (DigitalVideoDisc disc: dvdList) {
            addDigitalVideoDisc(disc);
        }
        System.out.println("The list of disc has been added");
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        try {
            itemOrdered.remove(disc);
            qtyOrdered -= 1;
            System.out.println("The disc is removed!");
        }
        catch (Exception e) {
            System.out.println("The disc hasn't been removed yet!");
        }
    }

    public float totalCost() {
        float sum = 0.00f;
        for(int i= 0; i< itemOrdered.size(); i++) {
            sum += itemOrdered.get(i).getCost();
        }
        return (float) Math.round(sum * 100) / 100;
    }

    public void print(){
        System.out.println("***********************CART***********************");
        for (int i = 0; i < this.qtyOrdered; i++ ) {
            System.out.println(i+1 + ". " + itemOrdered.get(i).getTitle()+" - "+itemOrdered.get(i).getCategory()+" - "+itemOrdered.get(i).getDirector()+" - "+itemOrdered.get(i).getLength()+": "+itemOrdered.get(i).getCost()+"$");
        }
        System.out.println("Total cost: " + totalCost() + "$");
        System.out.println("**************************************************");
    }

}
