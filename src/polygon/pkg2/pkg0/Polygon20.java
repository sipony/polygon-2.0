/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygon.pkg2.pkg0;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author DAVIDE
 */
public class Polygon20 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Menubar barra = new Menubar();
        
        BorderPane root = new BorderPane();
        root.setTop(barra);
       
        
        Screen screen =Screen.getPrimary();
        Rectangle2D bordi = screen.getVisualBounds();
        Scene scene = new Scene(root,bordi.getWidth() ,bordi.getHeight() );
        
        
        
        primaryStage.setTitle("Polygon 2.0");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
