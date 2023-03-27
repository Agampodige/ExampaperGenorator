
package application;


import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import com.jfoenix.controls.JFXTextArea;

public class TextExtractController {

    @FXML
    private AnchorPane Dragbox;

    @FXML
    private Label extractedText;

    public void initialize() {
        // Add event handler for DRAG_OVER event
        Dragbox.setOnDragOver(event -> {
            // Check if the dragged object is an image
            if (event.getDragboard().hasImage()) {
                // Accept the drag
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            event.consume();
        });

        // Add event handler for DRAG_DROPPED event
        Dragbox.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasImage()) {
                success = true;
                // Set the dropped image as the background image of the Dragbox
                Image image = db.getImage();
                BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Dragbox.setBackground(new Background(backgroundImage));

                // Extract text from the dropped image using Tesseract
                Tesseract tesseract = new Tesseract();
                tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
                try {
                    String text = tesseract.doOCR(SwingFXUtils.fromFXImage(image, null));
                    extractedText.setText(text);
                } catch (TesseractException e) {
                    Alert alert = new Alert(AlertType.ERROR, "Error extracting text from image.");
                    alert.showAndWait();
                    e.printStackTrace();
                }
            }
            event.setDropCompleted(success);
            event.consume();
        });
    }
}
