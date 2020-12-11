package CinemaGUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertWindow {
	public static void display(String title, String message) {
		Stage window = new Stage();
		window.setTitle(title);
		window.initModality(Modality.APPLICATION_MODAL);
		
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(10,10,10,10));
		layout.setAlignment(Pos.CENTER);
		
		Label messageLbl = new Label(message);
		layout.getChildren().addAll(messageLbl);
		
		Scene alertScene = new Scene(layout, 200, 100);
		window.setScene(alertScene);
		window.showAndWait();
	}
}
