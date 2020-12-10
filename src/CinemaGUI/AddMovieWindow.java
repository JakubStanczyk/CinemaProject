package CinemaGUI;

import Movie.Movie;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddMovieWindow {
	public static void display(TableView<Movie> movieList) {
		Stage window = new Stage();
		window.setTitle("Add Movie");
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setMaxWidth(300);
		
		TextField movieNameTxtF = new TextField();
		movieNameTxtF.setPromptText("Title");
		TextField movieDateTxtF = new TextField();
		movieNameTxtF.setPromptText("Date");
		TextField movieTimeTxtF = new TextField();
		movieNameTxtF.setPromptText("Time");
		TextField moviePriceTxtF = new TextField();
		movieNameTxtF.setPromptText("Price");
		
		Button submitBtn = new Button("Submit");
		submitBtn.setOnAction(e -> {
			Movie newMovie = new Movie(movieNameTxtF.getText(), movieDateTxtF.getText(),
					movieTimeTxtF.getText(), moviePriceTxtF.getText());
			addMovie(movieList, newMovie);
			window.close();
		});
		Button cancelBtn = new Button("Cancel");
		cancelBtn.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(10,10,10,10));
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(movieNameTxtF, movieDateTxtF,
				movieTimeTxtF, moviePriceTxtF, submitBtn, cancelBtn);
		
		Scene confirmScene = new Scene(layout, 300, 200);
		window.setScene(confirmScene);
		window.showAndWait();
	}
	
	public static void addMovie(TableView<Movie> movieList, Movie movie) {
		movieList.getItems().add(movie);
	}
}
