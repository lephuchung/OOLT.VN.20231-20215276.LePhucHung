package AimsProject.src.hust.soict.hedspi.aims.screen.manager;

import AimsProject.src.hust.soict.hedspi.aims.cart.Cart;
import AimsProject.src.hust.soict.hedspi.aims.store.Store;

import javax.swing.JFrame;

public abstract class AddItemToStoreScreen extends JFrame {
    private Store store;

    public Store getStore() {
        return this.store;
    }

    public AddItemToStoreScreen(Store store) {
        this.store = store;
    }

}