package CinemaGUI;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class CinemaGUI extends Application {
	
	Stage window;
	Scene loginScene, registerScene, welcomeScene, movieScene, 
			concessionScene, bookingScene, accountScene;
	
	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Movie Times");
		
		// Login Page
		
		Label loginUserLbl = new Label("username");
		TextField loginUserTxtF = new TextField();
		Label loginPasswordLbl = new Label("password");
		TextField loginPasswordTxtF = new TextField();
		
		Button loginBtn = new Button("Login");
		//loginBtn.setOnAction(e -> System.out.print(loginUserTxtF.getText()));
		loginBtn.setOnAction(e -> window.setScene(welcomeScene));
		
		Button createBtn = new Button("Create Account");
		createBtn.setOnAction(e -> window.setScene(registerScene));
		
		VBox loginLayout = new VBox(10);
		loginLayout.getChildren().addAll(loginUserLbl, loginUserTxtF, 
				loginPasswordLbl, loginPasswordTxtF, loginBtn, createBtn);
		loginScene = new Scene(loginLayout, 200, 250);
		
		// New Account Page
		
		Label registerUserLbl = new Label("username");
		TextField registerUserTxtF = new TextField();
		Label registerPasswordLbl = new Label("password");
		TextField registerPasswordTxtF = new TextField();
		
		Button registerBtn = new Button("Register");
		registerBtn.setOnAction(e -> System.out.print(
				"User " + registerUserTxtF.getText() + " created"));
		
		Button backLoginBtn = new Button("Back");
		backLoginBtn.setOnAction(e -> window.setScene(loginScene));
		
		VBox registerLayout = new VBox(10);
		registerLayout.getChildren().addAll(registerUserLbl, registerUserTxtF, 
				registerPasswordLbl, registerPasswordTxtF, registerBtn, backLoginBtn);
		registerScene = new Scene(registerLayout, 200, 250);
		
		window.setScene(loginScene);
		window.show();
		
		// Welcome Page
		
		Label welcomeLbl = new Label("Welcome");
		
		Button viewMoviesBtn = new Button("View Movies");
		viewMoviesBtn.setOnAction(e -> window.setScene(movieScene));
		
		Button concessionBtn = new Button("Concessions");
		concessionBtn.setOnAction(e -> window.setScene(concessionScene));
		
		Button viewBookingsBtn = new Button("Your Bookings");
		viewBookingsBtn.setOnAction(e -> window.setScene(bookingScene));
		
		Button accountBtn = new Button("Your Account");
		accountBtn.setOnAction(e -> window.setScene(accountScene));
		
		VBox welcomeLayout = new VBox(10);
		welcomeLayout.getChildren().addAll(welcomeLbl, viewMoviesBtn,
				concessionBtn, viewBookingsBtn, accountBtn);
		welcomeScene = new Scene(welcomeLayout, 200, 250);
		
		// Movies Page
		
		Label movieLbl = new Label("move times page");
		Button backMovieBtn = new Button("Back");
		backMovieBtn.setOnAction(e -> window.setScene(welcomeScene));
		
		VBox movieLayout = new VBox(10);
		movieLayout.getChildren().addAll(movieLbl, backMovieBtn);
		movieScene = new Scene(movieLayout, 200, 250);
		
		// Concessions Page
		
		Label concessionLbl = new Label("concessions page");
		Button backConBtn = new Button("Back");	
		backConBtn.setOnAction(e -> window.setScene(welcomeScene));
		
		VBox concessionLayout = new VBox(10);
		concessionLayout.getChildren().addAll(concessionLbl, backConBtn);
		concessionScene = new Scene(concessionLayout, 200, 250);
		
		// Bookings Page
		
		Label bookingLbl = new Label("bookings page");
		Button backBookingBtn = new Button("Back");	
		backBookingBtn.setOnAction(e -> window.setScene(welcomeScene));
		
		VBox bookingLayout = new VBox(10);
		bookingLayout.getChildren().addAll(bookingLbl, backBookingBtn);
		bookingScene = new Scene(bookingLayout, 200, 250);
		
		// Account Page
		
		Label accountLbl = new Label("account page");
		Button backAccountBtn = new Button("Back");	
		backAccountBtn.setOnAction(e -> window.setScene(welcomeScene));
		
		VBox accountLayout = new VBox(10);
		accountLayout.getChildren().addAll(accountLbl, backAccountBtn);
		accountScene = new Scene(accountLayout, 200, 250);
	}
}
