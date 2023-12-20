package GUIProject.hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    @FXML
    void clearButtonPressed(ActionEvent e) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent e) {
        Circle newCircle = new Circle(e.getX(), e.getY(), 4, Color.BLACK);
        drawingAreaPane.getChildren().add(newCircle);
    }

}