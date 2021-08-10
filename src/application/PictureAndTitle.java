package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.util.ArrayList;
import java.util.List;

public class PictureAndTitle  {
	public FlowPane PictureAndTitle(){
		FlowPane pane = new FlowPane();
		pane.setPadding(new Insets(15,15,15,15));
		pane.setHgap(150);
		
		// F&T Hotel picture 1
		Image image1 = new Image("F&THotel.jpg");
		ImageView imageView1 = new ImageView(image1);
		imageView1.setFitHeight(200);
		imageView1.setFitWidth(300);
		ColorAdjust colorAd1 = new ColorAdjust();
		 	colorAd1.setContrast(-0.1);
		 	colorAd1.setHue(-0.05);
		 	colorAd1.setBrightness(0.1);
		 	colorAd1.setSaturation(0.1);
		 	imageView1.setPreserveRatio(true);
		 	imageView1.setEffect(colorAd1);
		 	imageView1.getStyleClass().add("image");
		 	pane.getChildren().add(imageView1);
		//TÝTLE
		 	Text bigTitle = new Text();
			bigTitle.setText("WELCOME TO\n F&T HOTEL");
			bigTitle.setFill(Color.PAPAYAWHIP);
			bigTitle.setId("label-title");
			pane.getChildren().add(bigTitle);
		// F&T Hotel picture 2
				Image image2 = new Image("F&THotel2.jpg");
				ImageView imageView2 = new ImageView(image2);
				imageView2.setFitHeight(180);
				imageView2.setFitWidth(450);
				ColorAdjust colorAd2 = new ColorAdjust();
			 		colorAd2.setContrast(-0.1);
			 		colorAd2.setHue(-0.05);
			 		colorAd2.setBrightness(0.1);
			 		colorAd2.setSaturation(0.1);
			 		imageView2.setPreserveRatio(true);
			 		imageView2.setEffect(colorAd2);
			 	
			 	pane.getChildren().add(imageView2);
			 	
			 	return pane;
		
	}

}
