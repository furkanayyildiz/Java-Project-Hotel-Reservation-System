package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;


public class Location  {
	
	
	ArrayList<String> location= new ArrayList<String>();
	public Location(){
	 
	 	location.add("Ýstanbul");
		location.add("Çeþme");
		location.add("Bodrum");
		location.add("Londra");
		location.add("Paris");
		location.add("Dubai");
		location.add("Tokyo");
		location.add("New York");
	}
	public  ArrayList<String> getLocation(){
	 return location;
	}
	public  Label submitButton(ComboBox<String> loc, Label printResult) {
		
		if(loc.getValue().equals(location.get(0))) {
			printResult.setText("Your location is:"+ location.get(0));	
		}
		else if(loc.getValue().equals(location.get(1))) {
			printResult.setText("Your location is:"+ location.get(1));
		}
		else if(loc.getValue().equals(location.get(2))) {
			printResult.setText("Your location is:"+ location.get(2));
		}
		else if(loc.getValue().equals(location.get(3))) {
			printResult.setText("Your location is:"+ location.get(3));
		}
		else if(loc.getValue().equals(location.get(4))) {
			printResult.setText("Your location is:"+ location.get(4));
		}
		else if(loc.getValue().equals(location.get(5))) {
			printResult.setText("Your location is:"+ location.get(5));
		}
		else if(loc.getValue().equals(location.get(6))) {
			printResult.setText("Your location is:"+ location.get(6));
		}
		else if(loc.getValue().equals(location.get(7))) {
			printResult.setText("Your location is:"+ location.get(7));
		}
		return printResult;
		
		
		
	}

}



