package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FamilyOne implements Listing {
	
	ObservableList<String> family = FXCollections.observableArrayList();
	
	CheckBox c1;
	CheckBox c2;
	CheckBox c3;
	String mes ;
	Label printResult = new Label();
	
	Stage exc = new Stage();
	static Label aracý = new Label();
	static int lk = new Main().para;
	
	public FamilyOne() {
		family.addAll("Mini Bar","TV","Wifi","Hair dryer","Mirror","Open Buffet","Iron");
		
	}
	
	public void List() {
		Stage stage7 = new Stage();
		stage7.initModality(Modality.APPLICATION_MODAL);
		stage7.setTitle("Family Room,One Star");
		
		ListView<String> list7 = new ListView<>();
		list7.setItems(family);
		
		VBox layout = new VBox();
		layout.setPadding(new Insets(15,15,15,15));
		layout.getChildren().add(list7);
		
		Scene scene = new Scene(layout,300,250);
		stage7.setScene(scene);
		stage7.showAndWait();
	}
	public void Choose() {
		
		exc.setTitle("Extra Chooseing");
		exc.initModality(Modality.APPLICATION_MODAL);
			 c1 = new CheckBox("Pc");  
		     c2 = new CheckBox("Childminder");  
		     c3 = new CheckBox("Microwave"); 
		    Button choose= new Button("Choose");
		    VBox layout = new VBox(10);
		    layout.setPadding(new Insets(15,15,15,15));
		    
		    choose.setOnAction( e ->{
		    	 mes = "Extra Features:\n";
		    	if(c1.isSelected()) 
		    		mes += "Pc\n";
		    	if(c2.isSelected()) 
		    		mes += "Childminder\n";
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
		 price.setText("Your Price is:" + lk*700);
		 return price;
	}
}
