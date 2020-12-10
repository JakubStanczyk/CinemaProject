package CinemaGUI;
import javafx.stage.Stage;
import a.Account;
import Control.authorisation;
import java.sql.SQLException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class cinemaGUI {
	static Scene loginScene, registerScene, welcomeScene, movieScene, 
	concessionScene, bookingScene, accountScene;
	
	public static void display() {
		Stage window = new Stage();
		window.setTitle("Movie Times");
		
		// Login Page
		
		Label loginUserLbl = new Label("username");
		TextField loginUserTxtF = new TextField();
		Label loginPasswordLbl = new Label("password");
		PasswordField loginPasswordPassF = new PasswordField();
		
		Button loginBtn = new Button("Login");
		
		//loginBtn.setOnAction(e -> System.out.print(loginUserTxtF.getText()));
		loginBtn.setOnAction(e -> window.setScene(welcomeScene));
		
		Button createBtn = new Button("Create Account");
		createBtn.setOnAction(e -> window.setScene(registerScene));
		
		VBox loginLayout = new VBox(10);
		loginLayout.setAlignment(Pos.CENTER);
		loginLayout.getChildren().addAll(loginUserLbl, loginUserTxtF, 
				loginPasswordLbl, loginPasswordPassF, loginBtn, createBtn);
		loginScene = new Scene(loginLayout, 200, 250);
		
		// New Account Page
		
		Label registerUserLbl = new Label("username");
		TextField registerUserTxtF = new TextField();
		Label nameLbl = new Label("name");
		TextField nameTxtF = new TextField();
		Label registerPasswordLbl = new Label("password");
		PasswordField registerPasswordTxtF = new PasswordField();
		
		Button registerBtn = new Button("Register");
		registerBtn.setOnAction(e ->
			{	
				if(authorisation.authorisationRegister(registerUserTxtF.getText(),registerPasswordTxtF.getText(),nameTxtF.getText())){
					
				
				try {
					//TODO control method that will check if the password is in the right format and username and name is not null
					// try and catch will catch duplicates in username 
					
				
					
					Account.addNewAccountToDB(registerUserTxtF.getText(),nameTxtF.getText(),registerPasswordTxtF.getText());
					window.setScene(loginScene);
				} catch (SQLException e1) {
					// TODO Window that will say this user is already being used and after you press ok and  it reverts back to the screen
					System.out.println(e1);
					alertWindow.display("Error","username already in use");
				}
				
				}
				else {
					alertWindow.display("Error","fields null or password is in the wrong format");
				}
			}
				);
		
		
		
		
		
		
		
		
		Button backLoginBtn = new Button("Back");
		backLoginBtn.setOnAction(e -> window.setScene(loginScene));
		
		VBox registerLayout = new VBox(10);
		registerLayout.setAlignment(Pos.CENTER);
		registerLayout.getChildren().addAll(nameLbl,nameTxtF,registerUserLbl, registerUserTxtF, 
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
		welcomeLayout.setAlignment(Pos.CENTER);
		welcomeLayout.getChildren().addAll(welcomeLbl, viewMoviesBtn,
				concessionBtn, viewBookingsBtn, accountBtn);
		welcomeScene = new Scene(welcomeLayout, 200, 250);
		
		// Movies Page
		
		Label movieLbl = new Label("move times page");
		Button backMovieBtn = new Button("Back");
		backMovieBtn.setOnAction(e -> window.setScene(welcomeScene));
		
		Button nextMovieBtn = new Button("Next");
		nextMovieBtn.setOnAction(e -> window.setScene(concessionScene));
		
		VBox movieLayout = new VBox(10);
		movieLayout.setAlignment(Pos.CENTER);
		
		movieLayout.getChildren().addAll(movieLbl, nextMovieBtn, backMovieBtn);
		movieScene = new Scene(movieLayout, 200, 250);
		
		// Concessions Page
		
			// concession top menu
		Label concessionLbl = new Label("concessions page");
		
		VBox concessionTopLayout = new VBox(10);
		concessionTopLayout.setAlignment(Pos.CENTER);
		concessionTopLayout.getChildren().add(concessionLbl);
		
			// concession left menu
		ComboBox<String> orderComboBox = new ComboBox<>();
		orderComboBox.getItems().addAll("popcorn", "drink", "candy");
		
		Button addItemBtn = new Button("Add to Order");
		addItemBtn.setOnAction(e -> addItemtoOrder());
		
		VBox concessionLeftLayout = new VBox(10);
		concessionLeftLayout.setAlignment(Pos.CENTER);
		concessionLeftLayout.getChildren().addAll(orderComboBox, addItemBtn);
		
			// concession right menu
		Label orderLbl = new Label("order items go here");
		
		VBox concessionRightLayout = new VBox(10);
		concessionRightLayout.setAlignment(Pos.CENTER);
		concessionRightLayout.getChildren().addAll(orderLbl);
		
			// concession bottom menu
		Button backConBtn = new Button("Back");	
		backConBtn.setOnAction(e -> window.setScene(welcomeScene));
		
		VBox concessionBottomLayout = new VBox(10);
		concessionBottomLayout.setAlignment(Pos.CENTER);
		concessionBottomLayout.getChildren().add(backConBtn);
		
		BorderPane concessionLayout = new BorderPane();
		concessionLayout.setTop(concessionTopLayout);
		concessionLayout.setLeft(concessionLeftLayout);
		concessionLayout.setRight(concessionRightLayout);
		concessionLayout.setBottom(concessionBottomLayout);
		concessionScene = new Scene(concessionLayout, 200, 250);
		
		// Bookings Page
		
		Label bookingLbl = new Label("bookings page");
		Button backBookingBtn = new Button("Back");	
		backBookingBtn.setOnAction(e -> window.setScene(welcomeScene));
		
		VBox bookingLayout = new VBox(10);
		bookingLayout.setAlignment(Pos.CENTER);
		bookingLayout.getChildren().addAll(bookingLbl, backBookingBtn);
		bookingScene = new Scene(bookingLayout, 200, 250);
		
		// Account Page
		
		Label accountLbl = new Label("account page");
	
		Button changePassButton = new Button("Change Password");
		changePassButton.setOnAction(e -> {
			changePasswordWindow.display();
		});
		Button deleteButton = new Button("Delete Account");
		deleteButton.setOnAction(e -> confirmWindow.display());
		
		Button backAccountBtn = new Button("Back");	
		backAccountBtn.setOnAction(e -> window.setScene(welcomeScene));
		
		VBox accountLayout = new VBox(10);
		accountLayout.setAlignment(Pos.CENTER);
		accountLayout.getChildren().addAll(accountLbl, changePassButton, 
				deleteButton, backAccountBtn);
		accountScene = new Scene(accountLayout, 200, 250);
	}

	private static void addItemtoOrder() {
		System.out.println("TODO implement add item to order");
	}
}