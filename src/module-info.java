module paper_Genorat {
	requires javafx.controls;
	requires javafx.fxml;
	requires tess4j;
	requires javafx.swing;
	
	opens application to javafx.graphics, javafx.fxml;
}
