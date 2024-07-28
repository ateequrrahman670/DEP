package com.ateeq.factorial;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    
    private HBox top,bottom,form;
    private GridPane grid;
    private Label label;
    private Text title, result;
    private TextField input_field;
    private Button calculate_btn;
    

    @Override
    public void start(Stage stage) {
        
        ColumnConstraints columns1 = new ColumnConstraints(160,213.3,640);
//        ColumnConstraints columns2 = new ColumnConstraints(250,350,400);
        RowConstraints row1 = new RowConstraints(200,300, Double.MAX_VALUE);

        grid = new GridPane();
//        grid.setGridLinesVisible(true);
        top = new HBox();
        bottom = new HBox();
        form = new HBox();
        input_field = new TextField();
        calculate_btn = new Button();
        
        calculate_btn.setText("Calculate");
        calculate_btn.setPrefSize(80, 30);
        
        input_field.setPrefSize(200, 30);
        
        title = new Text();
        result = new Text();
        result.setText("Result");
        result.setFont(Font.font("Arial", FontPosture.ITALIC, 24));
        result.setStyle("-fx-text-fill: green");
        
        
        label = new Label();
        
        title.setText("Factorial Calculator");
        title.setFont(Font.font("Arial", 24));
        
        top.setAlignment(Pos.CENTER);
        top.setPadding(new Insets(10));
        top.getChildren().add(title);
        
        form.setAlignment(Pos.CENTER);
        form.getChildren().add(input_field);
        form.getChildren().add(calculate_btn);
        
        bottom.setPadding(new Insets(10));
        bottom.setAlignment(Pos.CENTER);
        bottom.getChildren().add(result);
        
        grid.setVgap(50);
        grid.getColumnConstraints().add(0,columns1);
//        grid.getColumnConstraints().add(1,columns2);
//        grid.getRowConstraints().add(row1);
        grid.add(top,2,0);
        grid.add(form,2,2);
        grid.add(bottom, 2, 5);
        
        
        calculate_btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t) {
                String number = input_field.getText().toString();
                int factorial = 1;
                if(number.isEmpty()){
                    result.setText("Please Enter a number");
                }else{
                    int n = Integer.valueOf(number);
                    
                    for(int i=1; i<=n; i++){
                        factorial*=i;
                    }
                    
                    result.setText(String.valueOf(factorial));
                }
                
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
            
        });
        
        var scene = new Scene(new StackPane(grid), 640, 480);
        
        stage.setTitle("Factorial Calculator");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}