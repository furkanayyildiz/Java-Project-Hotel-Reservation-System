package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DoubleThree extends DoubleTwo implements Listing{

	public DoubleThree() {
		doble.addAll("Free Breakfast","Microwave","Iron","Free Cancellation","Spa");
	}
	
	public void List() {
		Stage stage5 = new Stage();
		stage5.initModality(Modality.APPLICATION_MODAL);
		stage5.setTitle("Double Room,Three Star");
		
		ListView<String> list5 = new ListView<>();
		list5.setItems(doble);
		
		VBox layout = new VBox();
		layout.setPadding(new Insets(15,15,15,15));
		layout.getChildren().add(list5);
		
		Scene scene = new Scene(layout,300,250);
		stage5.setScene(scene);
		stage5.showAndWait();
	}
	public void Choose() {
		
		exc.setTitle("Extra Chooseing");
		exc.initModality(Modality.APPLICATION_MODAL);
			 c1 = new CheckBox("Pc");  
		     c2 = new CheckBox("Safe");  
		     c3 = new CheckBox("Microwave"); 
		    Button choose= new Button("Choose");
		    VBox layout = new VBox(10);
		    layout.setPadding(new Insets(15,15,15,15));
		    
		    choose.setOnAction( e ->{
		    	 mes = "Extra Features:\n";
		    	if(c1.isSelected()) 
		    		mes += "Pc\n";
		    	if(c2.isSelected()) 
		    		mes += "Safe\n";
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
		 price.setText("Your Price is:" + lk*800);
		 return price;
	}
}
