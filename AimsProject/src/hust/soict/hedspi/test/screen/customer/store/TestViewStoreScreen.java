package AimsProject.src.hust.soict.hedspi.test.screen.customer.store;

import AimsProject.src.hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import AimsProject.src.hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;

    public void start(Stage primaryStage) throws Exception{
        final String STORE_FXML_FILE_PATH = "/AimsProject/src/hust/soict/hedspi/aims/screen/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        launch(args);
    }

}
