package ep3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class MPGCalculator extends Application {
	
	private TextField tfMiles = new TextField();
	private TextField tfGallons = new TextField();
	private TextField tfMPG = new TextField();
	private Button btCalc = new Button("Calculate");
	
	public void start(Stage primaryStage) {
		
		GridPane pane = new GridPane();
		pane.setHgap(5);
		pane.setVgap(5);
		pane.add(new Label("Miles: "), 0, 0);
		pane.add(tfMiles, 1, 0);
		pane.add(new Label("Gallons: "), 0, 1);
		pane.add(tfGallons, 1, 1);
		pane.add(btCalc, 0, 2);
		pane.add(tfMPG, 1, 2);
		pane.setAlignment(Pos.CENTER);
		
		btCalc.setOnAction(new CalculateHandler());
		
		Scene scene = new Scene(pane, 250, 200);
		primaryStage.setMaxHeight(200);
		primaryStage.setMaxWidth(250);
		primaryStage.setTitle("MPG Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	class CalculateHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			calculateMPG();
		}
	}
	
	public void calculateMPG() {
		double miles = Double.parseDouble(tfMiles.getText());
		double gallons = Double.parseDouble(tfGallons.getText());
		double MPG = miles / gallons;
		tfMPG.setText(String.format("%.4f", MPG));
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
