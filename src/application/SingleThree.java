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

public class SingleThree extends SingleTwo implements Listing {

	public SingleThree() {
		single.addAll("Free Breakfast","Mikrowave","Iron");
	}
	public void List() {
	Stage stage3 = new Stage();
	stage3.initModality(Modality.APPLICATION_MODAL);
	stage3.setTitle("Single Room,Three Star");
	
	ListView<String> list3 = new ListView<>();
	list3.setItems(single);
	
	VBox layout = new VBox();
	layout.setPadding(new Insets(15,15,15,15));
	layout.getChildren().add(list3);
	
	Scene scene = new Scene(layout,300,250);
	stage3.setScene(scene);
	stage3.showAndWait();
	}
	public void Choose() {
		Stage exc = new Stage();
		exc.setTitle("Extra Chooseing");
		exc.initModality(Modality.APPLICATION_MODAL);
			 c1 = new CheckBox("Pc");  
		     c2 = new CheckBox("Spa");  
		     c3 = new CheckBox("Microwave"); 
		    Button choose= new Button("Choose");
		    VBox layout = new VBox(10);
		    layout.setPadding(new Insets(15,15,15,15));
		    
		    choose.setOnAction( e ->{
		    	 mes = "Extra Features:\n";
		    	if(c1.isSelected()) 
		    		mes += "Pc\n";
		    	if(c2.isSelected()) 
		    		mes += "Spa\n";
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
		 price.setText("Your Price is:" + lk*500);
		 return price;
	}
}