package AimsProject.src.hust.soict.hedspi.test.screen.customer.store;

import AimsProject.src.hust.soict.hedspi.aims.cart.Cart;
import AimsProject.src.hust.soict.hedspi.aims.media.DigitalVideoDisc;
import AimsProject.src.hust.soict.hedspi.aims.media.CompactDisc;
import AimsProject.src.hust.soict.hedspi.aims.media.Book;
import AimsProject.src.hust.soict.hedspi.aims.media.Track;
import AimsProject.src.hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import AimsProject.src.hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart;

    public void start(Stage primaryStage) throws Exception{
        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, this.cart);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        // cart = new Cart();

        // Create Media
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Star Wars 2", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Star Wars 3", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Aladin2", "Animation", 18.99f);

        CompactDisc cd1 = new CompactDisc("Allstars", "Smash Mouth", "Dunno", 69.420f);
        CompactDisc cd2 = new CompactDisc("Allstars 2", "Smash Mouth", "Dunno", 69.420f);
        Track track1 = new Track("Allstars", 4);
        Track track2 = new Track("Allstars 2", 5);
        Book book = new Book("Harry Potter", "Fantasy", 30.00f);

        // Try adding Media
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(dvd5);
        store.addMedia(dvd6);
        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(book);
        cd1.addTrack(track1);
        cd2.addTrack(track2);

        launch(args);
    }

}
