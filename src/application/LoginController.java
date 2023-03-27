package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LoginController {

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Text txtError;

    @FXML
    void handleLogin() {
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        // TODO: Add code to validate username and password

        if (username.equals(" ") && password.equals(" ")) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("app.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

                // Close the login window
                Stage loginStage = (Stage) btnLogin.getScene().getWindow();
                loginStage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            txtError.setText("Invalid username or password");
        }
    }
    @FXML
    void handleKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            handleLogin();
        }
    }
}
