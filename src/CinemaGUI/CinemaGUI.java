package CinemaGUI;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.TilePane;

public class CinemaGUI extends Application {
	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		// set title
		stage.setTitle("Login");
		
		// set layout, padding, and orientation
		TilePane tilePane = new TilePane();
		tilePane.setHgap(10);
		tilePane.setOrientation(Orientation.VERTICAL);

		// create scene and add layout
		Scene scene = new Scene(tilePane, 350, 250);
		
		// make labels and textfields
		Label userLbl = new Label("username");
		TextField userTxtF = new TextField();
		Label passwordLbl = new Label("password");
		TextField passwordTxtF = new TextField();
		
		// make login button and set action
		Button loginBtn = new Button("Login");
		loginBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			// button returns value of userTxtF when pressed
			public void handle(ActionEvent event) {
				System.out.print(userTxtF.getText());
			}
		});
		
		// add elements to layout
		tilePane.getChildren().add(userLbl);
		tilePane.getChildren().add(userTxtF);
		tilePane.getChildren().add(passwordLbl);
		tilePane.getChildren().add(passwordTxtF);
		tilePane.getChildren().add(loginBtn);
		
		// set and show scenes
		stage.setScene(scene);
		stage.show();
	}
}
