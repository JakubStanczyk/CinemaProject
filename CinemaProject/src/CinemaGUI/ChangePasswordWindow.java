package CinemaGUI;

import java.sql.SQLException;

import Account.Account;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChangePasswordWindow {
	public static void display(String username) {
		Stage window = new Stage();
		window.setTitle("Delete Account");

		window.initModality(Modality.APPLICATION_MODAL);
		window.setMaxWidth(300);

		Label newPassLabl = new Label("New Password");
		PasswordField newPasswordF = new PasswordField();
		Label confirmPassLbl = new Label("Confirm Password");
		PasswordField confirmPasswordF = new PasswordField();

		Button changePassBtn = new Button("Change Password");
		changePassBtn.setOnAction(e -> {
			if (newPasswordF.getText().equals(confirmPasswordF.getText())) {

				try {
					Account.changeAccountPassword(username, confirmPasswordF.getText());
				} catch (SQLException e1) {
				}

				window.close();
				AlertWindow.display("Success", "Passsword successfully changed");
			} else {
				AlertWindow.display("Error", "Passwords don't match");
			}
		});

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(10, 10, 10, 10));
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(newPassLabl, newPasswordF, confirmPassLbl, confirmPasswordF, changePassBtn);
		Scene confirmScene = new Scene(layout, 300, 200);
		window.setScene(confirmScene);
		window.showAndWait();
	}
}
