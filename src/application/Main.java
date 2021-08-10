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

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Main extends Application  {
	
	Stage mainWindow;
	Location sehir = new Location();
	static Label printCity = new Label();
	static int para;
	static DatePicker checkInDate;
	static DatePicker checkOutDate;
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);    
		Application.launch(args);
	}
	public void start(Stage mainWindow) {
		mainWindow.setTitle("F&T HOTEL");
		BorderPane layout = new BorderPane();
		
		
		GridPane grid = new GridPane();
		 grid.setHgap(10);
		 grid.setVgap(15);
	     // LOCATION PART 
	     //submitButton
		Button submitButton = new Button();
		submitButton.setText("Submit");
		submitButton.getStyleClass().add("button-submitButton");
		GridPane.setConstraints(submitButton, 0,6);
		
		//ComboBox
		ComboBox<String> loc = new ComboBox(FXCollections.observableArrayList(sehir.getLocation()));
		loc.setPromptText("Please Choose Your Hotel Location");
		GridPane.setConstraints(loc, 0,5);
		
		//Print location with label
		
		GridPane.setConstraints(printCity, 0,7);
		printCity.getStyleClass().add("label-printCity");
		submitButton.setOnAction(e -> {
			
			 Location sehir2 = new Location();
			printCity.equals((sehir2.submitButton(loc, printCity)));
				
	});
		
        checkInDate = new DatePicker();
        checkOutDate = new DatePicker(); 
        checkInDate.setValue(LocalDate.now());
        
        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
                
                public DateCell call(final DatePicker datePicker) {
                    return new DateCell() {
                       
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);
                            if (item.isBefore( checkInDate.getValue().plusDays(1))) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                            }
                           long p = ChronoUnit.DAYS.between(checkInDate.getValue(), item);
                            setTooltip(new Tooltip( "You're about to stay for " + p + " days"));
                         
                           
                    }
                };
            }
        };
        
        checkOutDate.setDayCellFactory(dayCellFactory);
        checkOutDate.setValue(checkInDate.getValue().plusDays(1));
        
        Button bt = new Button("Submit");
        bt.getStyleClass().add("button-submitButton");
        
        bt.setOnAction( e -> {
        	LocalDate ilkGün = checkInDate.getValue();
        	LocalDate sonGün = checkOutDate.getValue();
             
        	 Label lb = new Label();
            
             grid.add(lb, 0, 15); 
            
            
            if(sonGün.getMonthValue() == ilkGün.getMonthValue()) {
            	para = sonGün.getDayOfMonth() - ilkGün.getDayOfMonth();
            	 lb.setText("You're about to stay for " + para + " days");
            }
            else if(sonGün.getYear() == ilkGün.getYear()){
            	para = sonGün.getDayOfYear() - ilkGün.getDayOfYear();
            	 lb.setText("You're about to stay for " + para + " days");
            }
            else if(ilkGün.getYear()%4 == 0) {
            	 para = 366- ilkGün.getDayOfYear() + sonGün.getDayOfYear();
            	 lb.setText("You're about to stay for " + para + " days");
            }
            else {
            	para = 365 - ilkGün.getDayOfYear() + sonGün.getDayOfYear();
            	 lb.setText("You're about to stay for " + para + " days");
            }
            
        });
       grid.add(bt, 0, 13);
      
        Label checkInlabel = new Label("Check-In Date:");
        grid.add(checkInlabel, 0, 8);
        grid.add(checkInDate, 0, 9);
        Label checkOutlabel = new Label("Check-Out Date:");
        grid.add(checkOutlabel, 0, 10);
        grid.add(checkOutDate, 0, 11);
        
		
        mainWindow.setOnCloseRequest(e -> {
			e.consume();
			ConfirmBox furkan = new ConfirmBox();
			boolean answer = furkan.display("EXIT", "\tDo You Want to EXIT?\n "
					+ " Informations Will be DELETED !!!");
			if(answer == true) 
				mainWindow.close();
			
		});
        Text   text   = createText("Step 1");
        Circle circle = encircle(text);
        
        Text   text2   = createText("Step 2");
        Circle circle2 = encircle(text2);
        
       StackPane sp = new StackPane();
       sp.setPadding(new Insets(20));
       
       
        sp.getChildren().addAll(
                circle,
                text
        );
        StackPane ps= new StackPane();
        ps.setPadding(new Insets(30));
        
        ps.getChildren().addAll(
                circle2,
                text2
        );
        VBox circles = new VBox(5);
        circles.getChildren().addAll(sp,ps);
        Button conButton = new Button("Continue");
		conButton.getStyleClass().add("button-continue");
		conButton.setOnAction( e ->{
			Step3 room = new Step3();
			try {
				room.start(mainWindow);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		grid.add(conButton, 18, 18);
		
		grid.setAlignment(Pos.TOP_CENTER);
		layout.setCenter(grid);
		PictureAndTitle pt = new PictureAndTitle();
		layout.setTop(pt.PictureAndTitle());
		layout.setLeft(circles);
		grid.getChildren().addAll(loc,submitButton,printCity);
		
	Scene scene = new Scene(layout,1200,1100);
		scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
		mainWindow.setScene(scene);
		mainWindow.setResizable(false);
		mainWindow.show();
		
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