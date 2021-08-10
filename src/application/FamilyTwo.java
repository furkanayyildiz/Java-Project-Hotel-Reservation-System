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

public class FamilyTwo extends FamilyOne implements Listing{

	public FamilyTwo() {
		family.addAll("Air Conditioning","Boilder","Microwave","Concert Discount");
	}
	public void List() {
		Stage stage8 = new Stage();
		stage8.initModality(Modality.APPLICATION_MODAL);
		stage8.setTitle("Family Room,Two Star");
		
		ListView<String> list8 = new ListView<>();
		list8.setItems(family);
		
		VBox layout = new VBox();
		layout.setPadding(new Insets(15,15,15,15));
		layout.getChildren().add(list8);
		
		Scene scene = new Scene(layout,300,250);
		stage8.setScene(scene);
		stage8.showAndWait();
	}
	public void Choose() {
		
		exc.setTitle("Extra Chooseing");
		exc.initModality(Modality.APPLICATION_MODAL);
			 c1 = new CheckBox("Pc");  
		     c2 = new CheckBox("Childminder");  
		     c3 = new CheckBox("Spa"); 
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
		    		mes += "Spa";
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
		 price.setText("Your Price is:" + lk*1000);
		 return price;
	}
}
