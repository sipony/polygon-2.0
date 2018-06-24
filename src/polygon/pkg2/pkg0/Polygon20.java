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
import javafx.geometry.Orientation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
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
        
        
        
        
        
        StackPane leftPane = new StackPane(new Label("Left"));
        StackPane rightPane = new StackPane(new Label("Right"));
        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(leftPane, rightPane);
        splitPane.setDividerPositions(0.25);
        
        //--------imposto uguale la massima e la minima larghezza dell left pane per rendere
        //--------fisso il divider dello splitpane
        leftPane.setMinWidth(100);
        leftPane.setMaxWidth(100);
        
        //-----------divido il leftpane-----------//
        
        
        AnchorPane upPane = new AnchorPane(new Label("Uppaneleft"));
        upPane.setStyle("-fx-background-color: #FFFFFF;");
        
        GridPane griglia = new GridPane();
        final RowConstraints righe = new RowConstraints(0);
        griglia.getRowConstraints().add(righe);
        
     
        Button bottone1 = new Button();
        Button bottone2 = new Button();
        griglia.add(bottone1, 0, 0);
        griglia.add(bottone2,0,1);
        
        upPane.getChildren().add(griglia);
        




       

        StackPane downPane = new StackPane(new Label("DownPaneleft"));
        SplitPane splitPane2 = new SplitPane();
        splitPane2.setOrientation(Orientation.VERTICAL);
        //--------fisso il divider tra ppane e downpane -----------//
        upPane.setMaxHeight(400);
        upPane.setMinHeight(400);
        //----------------------------------------------------------//
        splitPane2.getItems().addAll(upPane, downPane);
        leftPane.getChildren().add(splitPane2);
        
        //----------divido il rightpane(quello per il canvas e il )----------------------------//
        
        StackPane upPane2 = new StackPane(new Label("Uppane"));
        StackPane downPane2= new StackPane(new Label("DownPane"));
        SplitPane splitPane3 = new SplitPane();
        splitPane3.setOrientation(Orientation.VERTICAL);
        //---------fisso il divider del rightpane---------------/---------------------/
        upPane2.setMaxHeight(800);
        upPane2.setMinHeight(800);
       
        //---------------------------------------------------------//
        splitPane3.getItems().addAll(upPane2, downPane2);
        rightPane.getChildren().add(splitPane3);
        //-------creo la gridpane per contenere i bottoni delle figure ---------------
        
        
        
        
        
       

        
        
     
        
 
        
        Menubar barra = new Menubar();
        
        BorderPane root = new BorderPane();
        root.setCenter(splitPane);
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
