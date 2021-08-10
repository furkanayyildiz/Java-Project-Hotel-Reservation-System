package application;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Modality;
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

public class TableStage {
	TableView<Room> table;
	
	public void display() {
		Stage tableStage = new Stage();
		tableStage.initModality(Modality.APPLICATION_MODAL);
		tableStage.setTitle("Price Table");
		//Type column
				TableColumn<Room , String> typeColumn = new TableColumn<>("Type");
				typeColumn.setMinWidth(200);
				typeColumn.setCellValueFactory(new PropertyValueFactory("type"));
				
				//One Star
				TableColumn<Room , String> oneStarColumn = new TableColumn<>("One Star");
				oneStarColumn.setMinWidth(100);
				oneStarColumn.setCellValueFactory(new PropertyValueFactory("oneStar"));
				
				//Two Star
				TableColumn<Room , String> twoStarColumn = new TableColumn<>("Two Star");
				twoStarColumn.setMinWidth(100);
				twoStarColumn.setCellValueFactory(new PropertyValueFactory("twoStar"));
				
				//Three Star
				TableColumn<Room , String> threeStarColumn = new TableColumn<>("Three Star");
				threeStarColumn.setMinWidth(100);
				threeStarColumn.setCellValueFactory(new PropertyValueFactory("threeStar"));
				
				table = new TableView<>();
				ObservableList<Room> rooms = FXCollections.observableArrayList();
				rooms.add(new Room("Single Room",100,300,500));
				rooms.add(new Room("Double Room",400,600,800));
				rooms.add(new Room("Family Room",700,1000,1300));
				table.setItems(rooms);
				table.getColumns().addAll(typeColumn, oneStarColumn, twoStarColumn, threeStarColumn );
				
				VBox vBox = new VBox();
				vBox.getChildren().add(table);
				
				Scene scene2 = new Scene(vBox);
				tableStage.setScene(scene2);
				tableStage.showAndWait();
	}

}
