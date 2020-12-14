package CinemaGUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmWindow {
	public static void display() {
		Stage window = new Stage();
		window.setTitle("Delete Account");
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setMaxWidth(300);
		
		Label confirmLbl = new Label("Are you sure you want to delete your account?");
		Button yesBtn = new Button("Yes, Delete my Account");
		yesBtn.setOnAction(e -> {
			System.out.println("TODO implement delete account");
			AlertWindow.display("Success", "Account Successfully Deleted");
			window.close();
		});
		Button noBtn = new Button("No, Keep my Account");
		noBtn.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(10,10,10,10));
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(confirmLbl, yesBtn, noBtn);
		
		Scene confirmScene = new Scene(layout, 300, 200);
		window.setScene(confirmScene);
		window.showAndWait();
	}
}