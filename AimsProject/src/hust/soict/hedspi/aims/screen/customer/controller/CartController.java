package AimsProject.src.hust.soict.hedspi.aims.screen.customer.controller;

import AimsProject.src.hust.soict.hedspi.aims.cart.Cart;
import AimsProject.src.hust.soict.hedspi.aims.exception.PlayerException;
import AimsProject.src.hust.soict.hedspi.aims.media.Media;
import AimsProject.src.hust.soict.hedspi.aims.media.Playable;

import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;

import AimsProject.src.hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Node;

public class CartController {
    private Cart cart;
    private Store store;
    private boolean filterByID = true;

    public CartController(Store store, Cart cart2) {
        this.cart = cart2;
        this.store = store;
    }

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Label costLabel;

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        setCost();
    }

    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        JDialog dialog = new JDialog();
        dialog.setTitle("Play");
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        String[] playList = ((Playable) media).play();
        for (int i = 0; i < playList.length; i++) {
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            gbc.gridy = i;
            panel.add(new JLabel(playList[i]), gbc);
        }
        dialog.add(panel);
        dialog.setSize(300, 300);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            fxmlLoader.setController(new ViewStoreController(store, cart));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        if (cart == null) {
            cart = new Cart();
        }
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        if (cart.getItemsOrdered() != null) {
            tblMedia.setItems(cart.getItemsOrdered());
        }
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends Media> observable, Media oldValue, Media newValue) -> {
                    updateButtonBar(newValue);
                });
        tfFilter.textProperty()
                .addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                    showFilteredMedia(newValue);
                });
        setCost();
    }

    void showFilteredMedia(String str) {
        if (str.strip().equals("")) {
            tblMedia.setItems(cart.getItemsOrdered());
        } else {
            ObservableList<Media> viewFilter;
            if (radioBtnFilterId.isSelected()) {
                viewFilter = cart.filterId(str);
            } else {
                viewFilter = cart.filterTitle(str);
            }
            if (viewFilter != null) {
                tblMedia.setItems(viewFilter);
            }
        }
    }

    void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            if (media instanceof Playable) {
                btnPlay.setVisible(true);
            } else {
                btnPlay.setVisible(false);
            }
        }
    }

    void setCost() {
        costLabel.setText(cart.totalCost() + " $");
    }

    @FXML
    private Button btnPlayOrder;

    @FXML
    void placeOrderClicked(ActionEvent event) {
        cart = new Cart();
        tblMedia.setItems(cart.getItemsOrdered());
        setCost();
        JDialog dialog = new JDialog();
        dialog.setTitle("S.O.S");
        JPanel panel = new JPanel();
        FlowLayout boxlayout = new FlowLayout(FlowLayout.CENTER, 75, 75);
        panel.setLayout(boxlayout);
        panel.add(new JLabel("Place order successfully"));
        dialog.add(panel);
        dialog.setSize(200, 200);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    @FXML
    void filterByIDChosen(ActionEvent event) {
        filterByID = true;
    }

    @FXML
    void filterByTitleChosen(ActionEvent event) {
        filterByID = false;
    }
}