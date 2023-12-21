package AimsProject.src.hust.soict.hedspi.aims;

import AimsProject.src.hust.soict.hedspi.aims.exception.DataConstraintsException;
import AimsProject.src.hust.soict.hedspi.aims.exception.LimitException;
import AimsProject.src.hust.soict.hedspi.aims.exception.PlayerException;
import AimsProject.src.hust.soict.hedspi.aims.media.Media;
import AimsProject.src.hust.soict.hedspi.aims.media.CompactDisc;
import AimsProject.src.hust.soict.hedspi.aims.media.DigitalVideoDisc;
import AimsProject.src.hust.soict.hedspi.aims.media.Book;
import AimsProject.src.hust.soict.hedspi.aims.cart.Cart;
import AimsProject.src.hust.soict.hedspi.aims.store.Store;

import java.util.Collections;
import java.util.Scanner;

public class Aims{

    private static Cart cart = new Cart();
    private static Store store = new Store();
    private static Scanner input = new Scanner(System.in);

    public static void showMenu() throws DataConstraintsException, PlayerException, LimitException {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See the current cart");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");

        int n = input.nextInt();
        input.nextLine();
        if(n == 1) {
            storeMenu();
        }
        else if (n == 2) {
            updateStore();
        }
        else if (n == 3) {
            cartMenu();
        }
        else if (n == 0) {
            System.out.println("Exit successfully!");
        }
        else {
            System.out.println("Error!");
            showMenu();
        }
    }
    public static void updateStore() throws DataConstraintsException, PlayerException, LimitException {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add media");
        System.out.println("2. Remove media");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        int n = input.nextInt();
        input.nextLine();
        if(n == 1) {
            updateStore1();
        }
        else if(n == 2) {
            updateStore2();
        }
        else if (n == 0) {
            System.out.println("Exit successfully!");
            showMenu();
        }
        else {
            System.out.println("Error!");
            showMenu();
        }
    }
    public static void updateStore1() throws DataConstraintsException, PlayerException, LimitException {
        System.out.print("Enter title of the media: ");
        String title = input.nextLine();
        System.out.print("Enter category of the media: ");
        String category = input.nextLine();
        System.out.print("Enter cost of the media: ");
        float cost = input.nextFloat();
        input.nextLine();

        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. DigitalVideoDisc");
        System.out.println("2. CompactDisc");
        System.out.println("3. Book");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");

        int n = input.nextInt();
        if (n == 1) {
            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost);
            store.addMedia(dvd);
            updateStore();
        }
        else if (n == 2) {
            CompactDisc cd = new CompactDisc(title, category, cost);
            store.addMedia(cd);
            updateStore();
        }
        else if (n == 3) {
            Book book = new Book(title, category, cost);
            store.addMedia(book);
            updateStore();
        }
        else if (n == 0) {
            System.out.println("Exit successfully!");
            updateStore();
        }
        else {
            System.out.println("Error!");
            showMenu();
        }
    }
    public static void updateStore2() throws DataConstraintsException, PlayerException, LimitException {
        System.out.print("Enter the title of the media:");
        String title = input.nextLine();
        for(Media media: store.getItemsInStore()) {
            if(media.getTitle().equals(title)) {
                store.removeMedia(media);
                updateStore();
                return ;
            }
        }
        System.out.println("Media does not exist!");
        updateStore();
    }

    public static void storeMenu() throws DataConstraintsException, PlayerException, LimitException {
        store.print();
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

        int n = input.nextInt();
        input.nextLine();
        if (n == 1) {
            storeMenu1();
        }
        else if (n == 2) {
            storeMenu2();
        }
        else if (n == 3) {
            storeMenu3();
        }
        else if (n == 4) {
            cartMenu();
        }
        else if (n == 0) {
            showMenu();
        }
        else {
            System.out.println("Error!");
            showMenu();
        }
    }

    public static void storeMenu1() throws DataConstraintsException, PlayerException, LimitException {
        System.out.println("Enter the title of the media");
        String title = input.nextLine();
        for(Media media: store.getItemsInStore()) {
            if(media.getTitle().equals(title)) {
                media.toString();
                mediaDetailsMenu(media);
                return ;
            }
        }
        System.out.println("Media does not exist!");
        storeMenu();
    }
    
    public static void mediaDetailsMenu(Media media) throws DataConstraintsException, PlayerException, LimitException {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int n = input.nextInt();
        input.nextLine();
        if (n == 1) {
            cart.addMedia(media);
            storeMenu();
        }
        else if (n == 2) {
            if (media instanceof DigitalVideoDisc) {
                DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                dvd.play();
            }
            else if (media instanceof CompactDisc) {
                CompactDisc cd = (CompactDisc) media;
                cd.play();
            }
            else if (media instanceof Book) {
                System.out.println("Can not be played!");
            }
            System.out.println("Do you want to add to cart?");
            System.out.println("1. Yes");
            System.out.println("0. No");
            int opt = input.nextInt();
            input.nextLine();
            if(opt == 1) {
                cart.addMedia(media);
                storeMenu();
            }
            else if(opt == 0) {
                storeMenu();
            }
            else {
                System.out.println("Error!");
                showMenu();
            }
        }
        else if (n == 0) {
            storeMenu();
        }
        else {
            System.out.println("Error!");
            showMenu();
        }
    }

    public static void storeMenu2() throws PlayerException, DataConstraintsException, LimitException {
        System.out.print("Enter the title of the media: ");
        String title = input.nextLine();
        for(Media media: store.getItemsInStore()) {
            if(media.getTitle().equals(title)) {
                cart.addMedia(media);
                storeMenu();
                return ;
            }
        }
        System.out.println("Media does not exist!");
        storeMenu();
    }
    public static void storeMenu3() throws PlayerException, DataConstraintsException, LimitException {
        System.out.print("Enter the title of the media: ");
        String title = input.nextLine();
        for(Media media: store.getItemsInStore()) {
            if(media.getTitle().equals(title)) {
                if (media instanceof DigitalVideoDisc) {
                    DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                    dvd.play();
                }
                else if (media instanceof CompactDisc) {
                    CompactDisc cd = (CompactDisc) media;
                    cd.play();
                }
                else if (media instanceof Book) {
                    System.out.println("Can not be played!");
                }
                storeMenu();
                return ;
            }
        }
        System.out.println("Media does not exist!");
        storeMenu();
    }

    public static void cartMenu() throws DataConstraintsException, PlayerException, LimitException {
        cart.print();
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Play order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
        int n = input.nextInt();
        input.nextLine();
        if (n == 1) {
            cartMenu1();
        }
        else if (n == 2) {
            cartMenu2();
        }
        else if (n == 3) {
            cartMenu3();
        }
        else if (n == 4) {
            cartMenu4();
        }
        else if (n == 5) {
            System.out.println("Order is placed!");
            cart.getItemsOrdered().clear();
            cart.print();
        }
        else if (n == 0) {
            showMenu();
        }
        else {
            System.out.println("Error!");
            showMenu();
        }
    }

    public static void cartMenu1() throws DataConstraintsException, PlayerException, LimitException {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by id");
        System.out.println("2. Filter by title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        int n = input.nextInt();
        input.nextLine();
        if(n == 1) {
            System.out.print("Enter id: ");
            int id = input.nextInt();
            input.nextLine();
            cart.searchId(id);
            cartMenu();
        }
        else if(n == 2) {
            System.out.print("Enter title: ");
            String title = input.nextLine();
            cart.searchTitle(title);
            cartMenu();
        }
        else if(n == 0) {
            cartMenu();
        }
        else {
            System.out.println("Error!");
            cartMenu();
        }
    }
    public static void cartMenu2() throws DataConstraintsException, PlayerException, LimitException {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        int n = input.nextInt();
        input.nextLine();
        if (n == 1) {
            Collections.sort(cart.getItemsOrdered(),Media.COMPARE_BY_TITLE_COST);
            cart.print();
            cartMenu();
        }
        if (n == 2) {
            Collections.sort(cart.getItemsOrdered(),Media.COMPARE_BY_COST_TITLE);
            cart.print();
            cartMenu();
        }
        if (n == 0) {
            cartMenu();
        }
        else {
            System.out.println("Error!");
            cartMenu();
        }
    }
    public static void cartMenu3() throws DataConstraintsException, PlayerException, LimitException {
        System.out.print("Enter the title of the media to remove: ");
        String title = input.nextLine();
        for(Media media: cart.getItemsOrdered()) {
            if(media.getTitle().equals(title)) {
                cart.removeMedia(media);
                cartMenu();
                return ;
            }
        }
        System.out.println("Media does not exist!");
        cartMenu();
    }
    public static void cartMenu4() throws PlayerException, DataConstraintsException, LimitException {
        System.out.print("Enter the title of the media to play: ");
        String title = input.nextLine();
        for (Media media: store.getItemsInStore()) {
            if (media.getTitle().equals(title)) {
                if (media instanceof CompactDisc){
                    CompactDisc cd = (CompactDisc) media;
                    cd.play();
                    cartMenu();
                    return;
                } else if (media instanceof DigitalVideoDisc){
                    DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                    dvd.play();
                    cartMenu();
                    return;
                } else if (media instanceof Book) {
                    System.out.println("Cannot play a book");
                    cartMenu();
                    return ;
                }
            }
        }
        System.out.println("Media does not exist!");
        cartMenu();
    }
    public static void main(String[] args) throws DataConstraintsException, PlayerException, LimitException {

        showMenu();
    }
}
