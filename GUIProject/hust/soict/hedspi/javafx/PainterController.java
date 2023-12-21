package GUIProject.hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.control.RadioButton;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    private String tool = "";

    @FXML
    void clearButtonPressed(ActionEvent e) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent e) {
        Circle newCircle = new Circle();
        if(tool.equals("Pen")) {
            newCircle = new Circle(e.getX(),
                    e.getY(), 4, Color.BLACK);
        }
        else if (tool.equals("Eraser")) {
            newCircle = new Circle(e.getX(),
                    e.getY(), 4, Color.WHITE);
        }
        if (e.getX()>=0 && e.getX()<=drawingAreaPane.getWidth()
                && e.getY()>=0 && e.getY()<=drawingAreaPane.getHeight()) {
            drawingAreaPane.getChildren().add(newCircle);
        }
    }

    @FXML
    void toolButtonPressed(ActionEvent e) {
        tool = ((RadioButton) e.getSource()).getText();
    }
}