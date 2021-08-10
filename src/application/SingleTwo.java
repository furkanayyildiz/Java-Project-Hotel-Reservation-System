package application;

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

public class SingleTwo extends SingleOne implements Listing{

	public SingleTwo() {
		single.addAll("Room Service","Boiler","Mirror","Free Cancellation");
	}
	public ObservableList<String> getSingle(){
		return single;
	}
	public void List() {
		Stage stage2 = new Stage();
		stage2.initModality(Modality.APPLICATION_MODAL);
		stage2.setTitle("Single Room,Two Star");
		
		ListView<String> list2 = new ListView<>();
		list2.setItems(single);
		
		VBox layout = new VBox();
		layout.setPadding(new Insets(15,15,15,15));
		layout.getChildren().add(list2);
		
		Scene scene = new Scene(layout,300,250);
		stage2.setScene(scene);
		stage2.showAndWait();
	}
	public void Choose() {
		Stage exc = new Stage();
		exc.setTitle("Extra Chooseing");
		exc.initModality(Modality.APPLICATION_MODAL);
			 c1 = new CheckBox("Free Cancellation");  
		     c2 = new CheckBox("Air Conditioning");  
		     c3 = new CheckBox("Microwave"); 
		    Button choose= new Button("Choose");
		    VBox layout = new VBox(10);
		    layout.setPadding(new Insets(15,15,15,15));
		    
		    choose.setOnAction( e ->{
		    	 mes = "Extra Features:\n";
		    	if(c1.isSelected()) 
		    		mes += "Free Cancellation\n";
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
		 price.setText("Your Price is:" + lk*300);
		 return price;
	}	
}