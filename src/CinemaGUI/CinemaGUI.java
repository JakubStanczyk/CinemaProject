package CinemaGUI;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class CinemaGUI extends Application {
	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Cinema Booking System");
		Button loginBtn = new Button("Login");
		loginBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.print("Button works");
			}
		});
		StackPane root = new StackPane();
		root.getChildren().add(loginBtn);
		stage.setScene(new Scene(root, 350, 250));
		stage.show();
	}
}
