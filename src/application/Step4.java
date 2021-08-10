package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

public class Step4 extends Application {
	Label billLoc = new Main().printCity;
	DatePicker checkInDate2 = new Main().checkInDate;
	DatePicker checkOutDate2 = new Main().checkOutDate;
	Label fiyat = new Label();
	ObservableList<String> extra2 = new Step3().extra;
	ComboBox roomRate2 = new Step3().roomRate;
	Label printEx = null;
	Label type = null;
	int phone = 0;
	boolean bl;
	public void start(Stage billStage) throws Exception {
		billStage.setTitle("F&T HOTEL");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setPadding(new Insets(15,15,15,15));
		grid.setVgap(15);
		grid.setHgap(15);
		
		// Name Label
		Label name = new Label("Name:");
		GridPane.setConstraints(name, 0, 0);
		//Name input
		TextField nameInput = new TextField();
		nameInput.setPromptText("Name");
		GridPane.setConstraints(nameInput, 1, 0);
		
		// SurName Label
		Label surname = new Label("Surname:");
		GridPane.setConstraints(surname, 0, 1);
		//SurName input
		TextField surnameInput = new TextField();
		surnameInput.setPromptText("Surname");
		GridPane.setConstraints(surnameInput, 1, 1);
		//Phone 
		Label phone = new Label("Phone Number:");
		GridPane.setConstraints(phone, 0, 2);
		
		TextField phoneIpt = new TextField();
		GridPane.setConstraints(phoneIpt, 1, 2);
		phoneIpt.setPromptText("Phone Number");
		phoneIpt.textProperty().addListener(new ChangeListener<String>() {

            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,13}([\\.]\\d{0,4})?")) {
                	phoneIpt.setText(oldValue);
                }
            }
        });
		
		//Passport and TC
		Label passTc = new Label("Passport No& TC No:");
		GridPane.setConstraints(passTc, 0, 3);
		TextField tcInput = new TextField();
		GridPane.setConstraints(tcInput, 1, 3);
		tcInput.setPromptText("Passport&Tc");
		tcInput.textProperty().addListener(new ChangeListener<String>() {

            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,11}([\\.]\\d{0,4})?")) {
                	tcInput.setText(oldValue);
                }
            }
        });
		
		//Address
		Label adrs = new Label("Address:");
		GridPane.setConstraints(adrs, 0, 4);
		TextField adrsInput = new TextField();
		adrsInput.setPromptText("Address");
		GridPane.setConstraints(adrsInput, 1, 4);
		
		Button save = new Button("SAVE & PRINT");
		GridPane.setConstraints(save, 1, 5);
		save.getStyleClass().add("button-submitButton");
		
			
		
		save.setOnAction( e -> {
			
			File file = new File("bill.txt");
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				
				writer.write(nameInput.getText());
				writer.newLine();
				writer.write(surnameInput.getText());
				writer.newLine();
				writer.write(phoneIpt.getText());
				writer.newLine();
				writer.write(tcInput.getText());
				writer.newLine();
				writer.write(adrsInput.getText());
				writer.newLine();
			
			
				String city = billLoc.getText();
				writer.write(city);
				writer.newLine();
				grid.add(billLoc, 0, 6);
				Label date = new Label("Check-in date:" + checkInDate2.getValue());
				grid.add(date, 0, 7);
				date.getStyleClass().add("label-date");
				Label date2 = new Label("Check-out date:" + checkOutDate2.getValue());
				grid.add(date2, 0, 8);
				String date3 = "Check-in date:" + checkInDate2.getValue();
				writer.write(date3);
				writer.newLine();
				String date4 = "Check-out date:" + checkOutDate2.getValue();
				writer.write(date4);
				writer.newLine();
				date2.getStyleClass().add("label-date");
			if(roomRate2.getValue().equals(extra2.get(0))) {
				SingleOne pr1 = new SingleOne();
				fiyat = pr1.gettingPrice();
				grid.add(fiyat, 0, 10);
				
				 printEx = new SingleOne().aracý;
				grid.add(printEx, 0, 11);
				
				 type = new Label("Your Room Rate:"+ extra2.get(0));
				grid.add(type, 0, 9);
			}
			else if(roomRate2.getValue().equals(extra2.get(1))) {
				SingleTwo pr2 = new SingleTwo();
				fiyat = pr2.gettingPrice();
				grid.add(fiyat, 0, 10);
				 printEx = new SingleTwo().aracý;
				grid.add(printEx, 0, 11);
				type = new Label("Your Room Rate:"+ extra2.get(1));
				grid.add(type, 0, 9);
			}
			else if(roomRate2.getValue().equals(extra2.get(2))) {
				SingleThree pr3 = new SingleThree();
				fiyat = pr3.gettingPrice();
				grid.add(fiyat, 0, 10);
				 printEx = new SingleThree().aracý;
				grid.add(printEx, 0, 11);
				 type = new Label("Your Room Rate:"+ extra2.get(2));
				grid.add(type, 0, 9);
			}
			else if(roomRate2.getValue().equals(extra2.get(3))) {
				DoubleOne pr4 = new DoubleOne();
				fiyat = pr4.gettingPrice();
				grid.add(fiyat, 0, 10);
				 printEx = new DoubleOne().aracý;
				grid.add(printEx, 0, 11);
				 type = new Label("Your Room Rate:"+ extra2.get(3));
				grid.add(type, 0, 9);
			}
			else if(roomRate2.getValue().equals(extra2.get(4))) {
				DoubleTwo pr5 = new DoubleTwo();
				fiyat = pr5.gettingPrice();
				grid.add(fiyat, 0, 10);
				 printEx = new DoubleTwo().aracý;
				grid.add(printEx, 0, 11);
				type = new Label("Your Room Rate:"+ extra2.get(4));
				grid.add(type, 0, 9);
			}
			else if(roomRate2.getValue().equals(extra2.get(5))) {
				DoubleThree pr6 = new DoubleThree();
				fiyat = pr6.gettingPrice();
				grid.add(fiyat, 0, 10);
				printEx = new DoubleThree().aracý;
				grid.add(printEx, 0, 11);
				 type = new Label("Your Room Rate:"+ extra2.get(5));
				grid.add(type, 0, 9);
			}
			else if(roomRate2.getValue().equals(extra2.get(6))) {
				FamilyOne pr7 = new FamilyOne();
				fiyat = pr7.gettingPrice();
				grid.add(fiyat, 0, 10);
				 printEx = new FamilyOne().aracý;
				grid.add(printEx, 0, 11);
				 type = new Label("Your Room Rate:"+ extra2.get(6));
				grid.add(type, 0, 9);
			}
			else if(roomRate2.getValue().equals(extra2.get(7))) {
				FamilyTwo pr8 = new FamilyTwo();
				fiyat = pr8.gettingPrice();
				grid.add(fiyat, 0, 10);
				 printEx = new FamilyTwo().aracý;
				grid.add(printEx, 0, 11);
				 type = new Label("Your Room Rate:"+ extra2.get(7));
				grid.add(type, 0, 9);
			}
			else if(roomRate2.getValue().equals(extra2.get(8))) {
				FamilyThree pr9 = new FamilyThree();
				fiyat = pr9.gettingPrice();
				grid.add(fiyat, 0, 10);
				
				 printEx = new FamilyThree().aracý;
				grid.add(printEx, 0, 11);
				
				 type = new Label("Your Room Rate:"+ extra2.get(8));
				grid.add(type, 0, 9);
			}
			fiyat.getStyleClass().add("label-price");
			printEx.getStyleClass().add("label-extra");
			type.getStyleClass().add("label-type");
			String tl = fiyat.getText();
			writer.write(tl);
			writer.newLine();
			String ex = printEx.getText();
			writer.write(ex);
			writer.newLine();
			String ty = type.getText();
			writer.write(ty);
			writer.close();
			
			Label lastLbl = new Label("Your Bill Is Printed.You Can Exit.\n\t Have A Good Day...");
			grid.add(lastLbl, 2, 12);
			lastLbl.getStyleClass().add("label-lastlbl");
			}
			catch(IOException f) {
				f.printStackTrace();
			}
		});
		Button backButton = new Button("BACK");
		backButton.getStyleClass().add("button-back");
		backButton.setOnAction(e ->{
			Step3 room = new Step3();
			try {
				room.start(billStage);
			}
			catch(Exception e2) {
				e2.printStackTrace();
			}
		});
		grid.add(backButton, 0, 12);
		
		
		
		
		grid.setAlignment(Pos.TOP_CENTER);
		grid.getChildren().addAll(name,nameInput,surname,surnameInput,phone,phoneIpt,passTc,tcInput,adrs,adrsInput,save);
		
		Text   text4   = createText("Step4");
        Circle circle5 = encircle(text4);

        StackPane stack = new StackPane();
        stack.setPadding(new Insets (15,15,15,15));
        stack.getChildren().addAll(
                circle5,
                text4
        );
		
		BorderPane layout = new BorderPane();
		PictureAndTitle pt3 = new PictureAndTitle();
		layout.setTop(pt3.PictureAndTitle());
		layout.setLeft(stack);
		layout.setCenter(grid);
		
		Scene scene = new Scene(layout,1200,1000);
		scene.getStylesheets().add(Step4.class.getResource("application.css").toExternalForm());
		billStage.setScene(scene);
		billStage.show();
		
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
