package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
public class ConfirmBox {
	
	static boolean answer;
	public static boolean display(String title,String message) {
		
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		Label label = new Label();
		label.setText(message);
		
		//Create two button
		
		Button yesButton = new Button("Yes");
		yesButton.getStyleClass().add("button-yes");
		Button noButton = new Button("No");
		noButton.getStyleClass().add("button-no");
		
		yesButton.setOnAction(e -> {
			answer = true;
			window.close();
		});
		noButton.setOnAction(e -> {
			answer = false;
			window.close();
		});
		
		GridPane layout = new GridPane();
		GridPane.setConstraints(label, 0, 0);
		layout.getChildren().add(label);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(30));
		HBox hbox = new HBox(35);
		hbox.setPadding(new Insets(15,35,15,75));
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(yesButton,noButton);
		BorderPane border = new BorderPane();
		border.setTop(layout);
		border.setLeft(hbox);
		
		Scene scene = new Scene(border,350,300);
		scene.getStylesheets().add(ConfirmBox.class.getResource("application.css").toExternalForm());
		window.setScene(scene);
		window.showAndWait();	
		
		return answer;
	}
	

}
