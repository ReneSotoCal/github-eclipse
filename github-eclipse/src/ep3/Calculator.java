package ep3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import java.util.ArrayList;

public class Calculator extends Application {
	
	//Instance Variables declared outside the start method
	private ArrayList<Button> bts = new ArrayList<>();//Holds Buttons
	private Button btDivide = new Button("/");
	private Button btMultiply = new Button("*");
	private Button btSub = new Button("-");
	private Button btAdd = new Button("+");
	private TextField tfNum1 = new TextField();
	private TextField tfNum2 = new TextField();
	private TextField tfAnswer = new TextField("0");
	private HBox topRow = new HBox(5);
	private HBox row2 = new HBox(5);
	private HBox row3 = new HBox(5);
	private HBox row4 = new HBox(5);

	@Override
	public void start(Stage primaryStage) {
		
		//Add Buttons to ArrayList and adding style to the buttons
		bts.add(btAdd);
		bts.add(btSub);
		bts.add(btMultiply);
		bts.add(btDivide);
		btStyle(bts);
		tfAnswer.setEditable(false);//Making Answer box unchangeable
		
		//Setting the actions for each Button
		bts.get(0).setOnAction(e -> {
			calculateSum();
		});
		bts.get(1).setOnAction(e -> {
			calculateDiff();
		});
		bts.get(2).setOnAction(e -> {
			calculateProd();
		});
		bts.get(3).setOnAction(e -> {
			
			calculateQuotient();
		});
		
		//GridPane Set up
		GridPane pane = new GridPane();
		pane.setHgap(5);
		pane.setVgap(10);
		pane.setPadding(new Insets(15));
		
		//Adding HBoxes in the GridPane
		topRow.getChildren().add(tfNum1);
		row2.getChildren().add(tfNum2);
		row3.getChildren().addAll(bts.get(0), bts.get(1), bts.get(2), bts.get(3));//Row with Buttons
		row4.getChildren().add(tfAnswer);
		
		//GridPane layout
		pane.add(new Label("First Number:"), 0, 0);
		pane.add(topRow, 1, 0);
		pane.add(row2, 1, 1);
		pane.add(new Label("Second Number:"), 0, 1);
		pane.add(row3, 1, 2);
		pane.add(new Label("Operation:"), 0, 2);
		pane.add(new Label("Answer:"), 0, 3);
		pane.add(row4, 1, 3);
		
		//Center-alignment
		row3.setAlignment(Pos.CENTER);
		pane.setAlignment(Pos.CENTER);		
		
		//Scene and Stage settings
		Scene scene = new Scene(pane, 300, 375);
		primaryStage.setMaxHeight(425);
		primaryStage.setMaxWidth(325);
		primaryStage.setTitle("Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void calculateSum() {
		
		if (tfNum1.getText() != null && !tfNum1.getText().isEmpty() && tfNum2.getText() != null && !tfNum2.getText().isEmpty()) {
			double num1 = Double.parseDouble(tfNum1.getText());
			double num2 = Double.parseDouble(tfNum2.getText());
			Double sum = num1 + num2;
			tfAnswer.setText(sum.toString());
		}
	}
	
	public void calculateDiff() {
		if (tfNum1.getText() != null && !tfNum1.getText().isEmpty() && tfNum2.getText() != null && !tfNum2.getText().isEmpty()) {
		double num1 = Double.parseDouble(tfNum1.getText());
		double num2 = Double.parseDouble(tfNum2.getText());
		Double difference = num1 - num2;
		tfAnswer.setText(difference.toString());	
		}
	}
	
	public void calculateProd() {
		if (tfNum1.getText() != null && !tfNum1.getText().isEmpty() && tfNum2.getText() != null && !tfNum2.getText().isEmpty()) {
		double num1 = Double.parseDouble(tfNum1.getText());
		double num2 = Double.parseDouble(tfNum2.getText());
		Double prod = num1 * num2;
		tfAnswer.setText(prod.toString());
		}
	}
	
	public void calculateQuotient() {
		if (tfNum1.getText() != null && !tfNum1.getText().isEmpty() && tfNum2.getText() != null && !tfNum2.getText().isEmpty()) {
		double num1 = Double.parseDouble(tfNum1.getText());
		double num2 = Double.parseDouble(tfNum2.getText());
		if(num2 != 0) {
			Double quotient = num1 / num2;
			tfAnswer.setText(quotient.toString());
		} else {
			tfAnswer.setText("Undefined");
		}
		}
	}
	
	public void btStyle(ArrayList<Button> bts) {
		
		for(Button bt : bts) {
			bt.setStyle("-fx-padding: 10;");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
