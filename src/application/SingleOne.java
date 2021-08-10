package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
public class SingleOne implements Listing{
	
	ObservableList<String> single = FXCollections.observableArrayList();
	CheckBox c1;
	CheckBox c2;
	CheckBox c3;
	String mes ;
	Label printResult = new Label();
	
	Stage exc = new Stage();
	static Label aracý = new Label();
	static int lk = new Main().para;
	
	public SingleOne() {
		single.addAll("Mini Bar","Open Buffet","Wifi","TV","Hair dryer");
		
	}
	public ObservableList<String> getSingle(){
		return single;
	}
	
	public void List() {
		Stage stage1 = new Stage();
		stage1.initModality(Modality.APPLICATION_MODAL);
		stage1.setTitle("Single Room,One Star");
		
		ListView<String> list1 = new ListView<>();
		list1.setItems(single);
		
		VBox layout = new VBox();
		layout.setPadding(new Insets(15,15,15,15));
		layout.getChildren().add(list1);
		
		Scene scene = new Scene(layout,300,250);
		stage1.setScene(scene);
		stage1.showAndWait();
		
	
	}
	public void Choose() {
		
		exc.setTitle("Extra Chooseing");
		exc.initModality(Modality.APPLICATION_MODAL);
			 c1 = new CheckBox("Boilder");  
		     c2 = new CheckBox("Air Conditioning");  
		     c3 = new CheckBox("Microwave"); 
		    Button choose= new Button("Choose");
		    VBox layout = new VBox(10);
		    layout.setPadding(new Insets(15,15,15,15));
		    
		    choose.setOnAction( e ->{
		    	 mes = "Extra Features:\n";
		    	if(c1.isSelected()) 
		    		mes += "Boilder\n";
		    	if(c2.isSelected()) 
		    		mes += "Air Conditioning\n";
		    	if(c3.isSelected()) 
		    		mes += "Microwave";
		    	Label result = new Label(mes);
		    	layout.getChildren().add(result);
		    	printResult = result;
		    });
		    exc.setOnCloseRequest(e-> {
				aracý = printResult;				
			});
		   
		    layout.getChildren().addAll(c1,c2,c3,choose);
		    
		    Scene scene = new Scene(layout,300,250);
		    exc.setScene(scene);
		    exc.showAndWait();
	}
	public Label gettingPrice() {
		
		Label price = new Label();
		 price.setText("Your Price is:" + lk*100);
		 return price;
	}
	
	
	
}
	

