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

public class FamilyThree extends FamilyTwo implements Listing {

	public FamilyThree() {
		family.addAll("Room Service","Free Breakfast","Spa","Free Cancellation","Concert Discoun");
		
	}
	public void List() {
		Stage stage9 = new Stage();
		stage9.initModality(Modality.APPLICATION_MODAL);
		stage9.setTitle("Family Room,ThreeStar");
		
		ListView<String> list9 = new ListView<>();
		list9.setItems(family);
		
		VBox layout = new VBox();
		layout.setPadding(new Insets(15,15,15,15));
		layout.getChildren().add(list9);
		
		Scene scene = new Scene(layout,300,250);
		stage9.setScene(scene);
		stage9.showAndWait();
	}
	public void Choose() {
		
		exc.setTitle("Extra Chooseing");
		exc.initModality(Modality.APPLICATION_MODAL);
			 c1 = new CheckBox("Spa");  
		     c2 = new CheckBox("Childminder");  
		     c3 = new CheckBox("Free Concert"); 
		    Button choose= new Button("Choose");
		    VBox layout = new VBox(10);
		    layout.setPadding(new Insets(15,15,15,15));
		    
		    choose.setOnAction( e ->{
		    	 mes = "Extra Features:\n";
		    	if(c1.isSelected()) 
		    		mes += "Spa\n";
		    	if(c2.isSelected()) 
		    		mes += "Childminder\n";
		    	if(c3.isSelected()) 
		    		mes += "Free Concert";
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
		 price.setText("Your Price is:" + lk*1300);
		 return price;
	}
}
