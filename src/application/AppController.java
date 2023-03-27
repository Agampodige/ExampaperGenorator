package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AppController implements Initializable {

    @FXML
    private AnchorPane anchorPane; // Assuming the main UI container is an AnchorPane

    @FXML
    private Button homeButton;

    @FXML
    private AnchorPane viewer;

    @FXML
    private Label titleLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialization logic goes here
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Text_Extract.fxml"));
            AnchorPane root = loader.load();
            AnchorPane.setTopAnchor(root, 0.0);
            AnchorPane.setRightAnchor(root, 0.0);
            AnchorPane.setBottomAnchor(root, 0.0);
            AnchorPane.setLeftAnchor(root, 0.0);
            viewer.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleButtonAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
            AnchorPane root = loader.load();
            AnchorPane.setTopAnchor(root, 0.0);
            AnchorPane.setRightAnchor(root, 0.0);
            AnchorPane.setBottomAnchor(root, 0.0);
            AnchorPane.setLeftAnchor(root, 0.0);
            viewer.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void handle_Text_Extract_ButtonAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Text_Extract.fxml"));
            AnchorPane root = loader.load();
            AnchorPane.setTopAnchor(root, 0.0);
            AnchorPane.setRightAnchor(root, 0.0);
            AnchorPane.setBottomAnchor(root, 0.0);
            AnchorPane.setLeftAnchor(root, 0.0);
            viewer.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
