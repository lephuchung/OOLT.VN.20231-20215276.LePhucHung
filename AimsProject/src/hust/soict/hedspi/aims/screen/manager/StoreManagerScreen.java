package AimsProject.src.hust.soict.hedspi.aims.screen.manager;


import java.util.ArrayList;
import AimsProject.src.hust.soict.hedspi.aims.store.Store;
import AimsProject.src.hust.soict.hedspi.aims.cart.Cart;
import AimsProject.src.hust.soict.hedspi.aims.media.*;

import java.awt.*;

import javax.swing.*;

public class StoreManagerScreen extends JFrame {
    private static Store store;
    private Cart cart;

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        menu.add(new JMenuItem("View Store"));

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3,2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i=0; i<9; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }
        return center;
    }

    public StoreManagerScreen(Store store) {

        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {

        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Harry Potter 1", "Roger Aliers", "Animation", 87, (float) 3.0);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Harry Potter 2", "Roger Aliers", "Animation", 87, (float) 3.5);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Harry Potter 3", "Roger Aliers", "Animation", 87, (float) 5);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Harry Potter 4", "Roger Aliers", "Animation", 87, (float) 4.5);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Fetch the Bolt Cutters", "Roger Aliers", "Animation", 87, (float) 10.39);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Future Nostalgia", "Roger Aliers", "Animation", 87, (float) 9.6);
        Book book1 = new Book("Mockingjay", "Funny", (float) 5.1);
        Book book2 = new Book("Catching Fire", "Funny", (float) 4.9);
        Book book3 = new Book("The Hunger Games", "Funny", (float) 5.5);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(dvd5);
        store.addMedia(dvd6);
        store.addMedia(book3);
        store.addMedia(book2);
        store.addMedia(book1);

        StoreManagerScreen scr = new StoreManagerScreen(store);
    }

}