package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Step3 extends Application {
	static ObservableList<String> extra = FXCollections.observableArrayList();	
	static ComboBox roomRate = new ComboBox();	
	public void start(Stage roomStage) throws Exception {
		roomStage.setTitle("F&T HOTEL");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setPadding(new Insets(15,15,0,15));
		grid.setVgap(25);
		grid.setHgap(15);
		
		Label lblPrice = new Label("You Can Look Into at Rooms Price: ");
		Button showPrice = new Button("Price List");
		showPrice.getStyleClass().add("button-submitButton");
		grid.add(lblPrice, 0, 0);
		grid.add(showPrice, 1, 0);
		showPrice.setOnAction( e -> {
			TableStage price = new TableStage();
			price.display();
		});
		
		//Single Room Quality
		Label singleRoom = new Label("SINGLE Room Ratings and Qualities");
		grid.add(singleRoom,0, 1);
		Button oneSingle = new Button("One Star");
		grid.add(oneSingle,1, 1);
		oneSingle.setOnAction( e ->{
			SingleOne s1 = new SingleOne();
			s1.List();
		});
		oneSingle.getStyleClass().add("button-single");
		Button twoSingle = new Button("Two Star");
		grid.add(twoSingle,2, 1);
		twoSingle.setOnAction( e ->{
			SingleTwo s2 = new SingleTwo();
			s2.List();
		});
		twoSingle.getStyleClass().add("button-single");
		Button threeSingle = new Button("Three Star");
		grid.add(threeSingle,3, 1);
		threeSingle.setOnAction( e ->{
			SingleThree s3 = new SingleThree();
			s3.List();
		});
		threeSingle.getStyleClass().add("button-single");
		//Double Room Quality
		Label doubleRoom = new Label("DOUBLE Room Ratings and Qualities");
		grid.add(doubleRoom,0, 2);
		Button oneDouble = new Button("One Star");
		grid.add(oneDouble,1, 2);
		oneDouble.setOnAction( e -> {
			DoubleOne d1 = new DoubleOne();
			d1.List();
		});
		oneDouble.getStyleClass().add("button-double");
		Button twoDouble = new Button("Two Star");
		grid.add(twoDouble,2, 2);
		twoDouble.setOnAction( e -> {
			DoubleTwo d2 = new DoubleTwo();
			d2.List();
		});
		twoDouble.getStyleClass().add("button-double");
		Button threeDouble = new Button("Three Star");
		grid.add(threeDouble,3, 2);
		threeDouble.setOnAction( e ->{
			DoubleThree d3 = new DoubleThree();
			d3.List();
		});
		threeDouble.getStyleClass().add("button-double");
		
		//Family Room Quality
		Label familyRoom = new Label("FAMILY Room Ratings and Qualities");
		grid.add(familyRoom,0, 3);
		
		Button oneFamily = new Button("One Star");
		grid.add(oneFamily,1, 3);
		oneFamily.setOnAction( e -> {
			FamilyOne f1 = new FamilyOne();
			f1.List();
		});
		oneFamily.getStyleClass().add("button-three");
		Button twoFamily = new Button("Two Star");
		grid.add(twoFamily,2, 3);
		twoFamily.setOnAction(e -> {
			FamilyTwo f2 = new FamilyTwo();
			f2.List();
		});
		twoFamily.getStyleClass().add("button-three");

		Button threeFamily = new Button("Three Star");
		grid.add(threeFamily,3, 3);
		threeFamily.setOnAction( e -> {
			FamilyThree f3 = new FamilyThree();
			f3.List();
		});
		threeFamily.getStyleClass().add("button-three");
		
		Label roomRatelbl = new Label("You Can Choose Your Room Rate");
		grid.add(roomRatelbl, 0, 6);
														
		roomRate.setPromptText("Please Choose Your Room Rate");
		grid.add(roomRate, 0, 7);
		
			
		extra.addAll("Single Room,One Star","Single Room,Two Star","Single Room,Three Star",
				"Double Room,One Star","Double Room,Two Star","Double Room,Three Star",
				  "Family Room,One Star","Family Room,Two Star","Family Room,Three Star");
		roomRate.getItems().addAll(extra);
		Button seç = new Button("Choose");
		seç.getStyleClass().add("button-submitButton");
		
		seç.setOnAction( e->{
			
		if(roomRate.getValue().equals(extra.get(0))) {
			
				SingleOne ex1 = new SingleOne();
				ex1.Choose();
				Label printEx = new SingleOne().aracý;
				grid.add(printEx, 0, 9);
				
			}
		else if(roomRate.getValue().equals(extra.get(1))) {
			
			SingleTwo ex2 = new SingleTwo();
			ex2.Choose();
			Label printEx = new SingleTwo().aracý;
			grid.add(printEx, 0, 9);
		}
		else if(roomRate.getValue().equals(extra.get(2))) {
			
			SingleThree ex3 = new SingleThree();
			ex3.Choose();
			Label printEx = new SingleThree().aracý;
			grid.add(printEx, 0, 9);
		}
		else if(roomRate.getValue().equals(extra.get(3))) {
			
			DoubleOne ex4 = new DoubleOne();
			ex4.Choose();
			Label printEx = new DoubleOne().aracý;
			grid.add(printEx, 0, 9);
		}
		else if(roomRate.getValue().equals(extra.get(4))) {
			
			DoubleTwo ex5 = new DoubleTwo();
			ex5.Choose();
			Label printEx = new DoubleTwo().aracý;
			grid.add(printEx, 0, 9);
		}
		else if(roomRate.getValue().equals(extra.get(5))) {
			
			DoubleThree ex6 = new DoubleThree();
			ex6.Choose();
			Label printEx = new DoubleThree().aracý;
			grid.add(printEx, 0, 9);
		}
		else if(roomRate.getValue().equals(extra.get(6))) {
			
			FamilyOne ex7 = new FamilyOne();
			ex7.Choose();
			Label printEx = new FamilyOne().aracý;
			grid.add(printEx, 0, 9);
		}
		else if(roomRate.getValue().equals(extra.get(7))) {
			
			FamilyTwo ex8 = new FamilyTwo();
			ex8.Choose();
			Label printEx = new FamilyTwo().aracý;
			grid.add(printEx, 0, 9);
		}
		else if(roomRate.getValue().equals(extra.get(8))) {
			
			FamilyThree ex9 = new FamilyThree();
			ex9.Choose();
			Label printEx = new FamilyThree().aracý;
			grid.add(printEx, 0, 9);
		}
		
		});
		
		
		Label exlbl = new Label("You Can Choose Extra Property:");
		grid.add(exlbl, 0, 8);
		grid.add(seç, 1, 8);
		
				
		Text   text4   = createText("Step3");
        Circle circle5 = encircle(text4);

        StackPane stack = new StackPane();
        stack.getChildren().addAll(
                circle5,
                text4
        );
        Button conButton = new Button("Continue");
        conButton.getStyleClass().add("button-continue");
		conButton.setOnAction( e ->{
			Step4 room = new Step4();
			try {
				room.start(roomStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		grid.add(conButton, 10, 12);
        
		Button backButton = new Button("BACK");
		backButton.getStyleClass().add("button-back");
		backButton.setOnAction(e ->{
			Main loc = new Main();
			try {
				loc.start(roomStage);
			}
			catch(Exception e2) {
				e2.printStackTrace();
			}
		});
		grid.add(backButton, 0, 12);
		BorderPane layout = new BorderPane();
		PictureAndTitle pt2 = new PictureAndTitle();
		layout.setTop(pt2.PictureAndTitle());
		layout.setCenter(grid);
		layout.setLeft(stack);
		
        layout.setPadding(new Insets(20));
		Scene scene = new Scene(layout,1200,1000);
		scene.getStylesheets().add(Step3.class.getResource("application.css").toExternalForm());
		roomStage.setScene(scene);
		roomStage.show();
	}
	
	 private Text createText(String string) {
	        Text text = new Text(string);
	        text.setBoundsType(TextBoundsType.VISUAL);
	        text.setStyle(
	                "-fx-font-family: \"Times New Roman\";" +
	                "-fx-font-style: italic;" +
	                "-fx-font-size: 48px;"
	        );

	        return text;
	    }

	    private Circle encircle(Text text) {
	        Circle circle = new Circle();
	        circle.setFill(Color.ORCHID);
	        final double PADDING = 10;
	        circle.setRadius(getWidth(text) / 2 + PADDING);

	        return circle;
	    }

	    private double getWidth(Text text) {
	        new Scene(new Group(text));
	        text.applyCss();

	        return text.getLayoutBounds().getWidth();
	    }
		
	}
	
	
