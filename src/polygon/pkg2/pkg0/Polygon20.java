/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygon.pkg2.pkg0;


import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import static java.time.Clock.system;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Path;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author DAVIDE
 */
public class Polygon20 extends Application {
    
     private Button[] pulsanti;
     private  Image Immagini[];
     private  ImageView viste [];
     private  String Path;
     private  String file;
     private  File[] Listafile;
     private  File cartella;
     private  GridPane griglia;
 
    
    
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        
        
        
        
        
        StackPane leftPane = new StackPane(new Label("Left"));
        StackPane rightPane = new StackPane(new Label("Right"));
        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(leftPane, rightPane);
        splitPane.setDividerPositions(0.25);
        
      
        
        
        //--------imposto uguale la massima e la minima larghezza dell left pane per rendere
        //--------fisso il divider dello splitpane tra canvas e strumenti
        leftPane.setMinWidth(105);
        leftPane.setMaxWidth(105);
        
        //-----------divido il leftpane-----------//
        
        
        AnchorPane upPane = new AnchorPane(new Label("Uppaneleft"));
        upPane.setPrefWidth(100);
        upPane.setPrefHeight(610);
        upPane.setStyle("-fx-background-color:#d7d6d5;");
        
        //-------------------settaggi per il downpane dove ce il logo dell universita di parma -------------------------------------------------------------------//
        Pane downPane = new Pane();
        SplitPane splitPane2 = new SplitPane();
        splitPane2.setOrientation(Orientation.VERTICAL);
        Image imagee= new Image(getClass().getResourceAsStream("parma.png"));
        Label etichetta2 = new Label();
        etichetta2.setLayoutX(0);
        etichetta2.setLayoutY(200);
        etichetta2.setPrefSize(100, 100);
       
        etichetta2.setGraphic(new ImageView(imagee));
       
        downPane.getChildren().add(etichetta2);
        downPane.setStyle("-fx-background-color:#d7d6d5;");
        

        //--------fisso il divider tra ppane e downpane -------------------//
        upPane.setMaxHeight(380);
        upPane.setMinHeight(380);
        //----------------------------------------------------------//
        splitPane2.getItems().addAll(upPane, downPane);
        leftPane.getChildren().add(splitPane2);
        
        
        //-------------------creo un altro split pane in cui nella parte superiore metto il logo e nella parte inferiore la griglia strumenti-------------------------------//
        StackPane logo =new StackPane();  
        StackPane strumenti = new StackPane();
        strumenti.setStyle("-fx-background-color:#d7d6d5;");
        logo.setMaxSize(100,56);
        logo.setMinSize(100,56);
        
        
        
        
        
        Label etichetta = new Label();
        etichetta.setPrefSize(upPane.getPrefWidth()-4, 60);
        Image image = new Image(getClass().getResourceAsStream("strumentibar.png"));
        etichetta.setGraphic(new ImageView(image));
        logo.getChildren().add(etichetta);
      
        
        SplitPane splitPane4 = new SplitPane();
        splitPane4.setOrientation(Orientation.VERTICAL);
        splitPane4.getItems().addAll(logo,strumenti);
        upPane.getChildren().add(splitPane4);
        //--------------------fisso il divider per separare logo strumenti e griglia strumenti-------------------//
       






        //----------divido il rightpane(quello per il canvas e il menu interattivo in basso-------------------------------------------------------------//
        Screen screen1 =Screen.getPrimary();
        Rectangle2D bordi = screen1.getVisualBounds();
        StackPane upPane2 = new StackPane();
        upPane2.setStyle("-fx-background-color:#d8dee3;");
        Pannello_inferiore downPane2= new Pannello_inferiore(bordi.getHeight(),bordi.getWidth());
        downPane2.setStyle("-fx-background-color:#d7d6d5;");
        
        Strumenti tool = new Strumenti(strumenti,upPane2,upPane.getPrefWidth()/2,upPane.getPrefHeight()/10,primaryStage);

        
        
        upPane2.setOnMouseMoved(new EventHandler<MouseEvent>(){
            
            @Override
            public void handle(MouseEvent evento){
               System.out.println(evento.getX());
               System.out.println(evento.getY());
                downPane2.set_campox(String.valueOf(evento.getX()));
                downPane2.set_campoy(String.valueOf(evento.getY()));
            }
                
                
            });


       
        System.out.println(upPane2.getWidth());
        System.out.println(upPane2.getHeight());
         //imposto immagine di background del canvas----  
         //Image ret = new Image(getClass().getResourceAsStream("millimetrata2.jpg"));
         //BackgroundSize dimensioni=new BackgroundSize(upPane2.getPrefWidth(),upPane2.getPrefHeight(),false,false,false,true);
         //BackgroundImage backgroundimage = new BackgroundImage(ret,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,dimensioni);
         //upPane2.setBackground(new Background(backgroundimage));
      
         SplitPane splitPane3 = new SplitPane();
         splitPane3.setOrientation(Orientation.VERTICAL);
        //---------fisso il divider del rightpane---------------//
        //bisogna necesssariamente dimensinarlo in base alle dimensioni dello schermo su cui gira il programma
        
        
        upPane2.setMaxHeight(bordi.getHeight()- bordi.getHeight()/3);
        upPane2.setMinHeight(bordi.getHeight()- bordi.getHeight()/3);
       
        //---aggiungo il canvas e il pannello inferiore allo splipane 3------------------------------------------------------//
        splitPane3.getItems().addAll(upPane2, downPane2);
        rightPane.getChildren().add(splitPane3);
 
        
        //-------creo la gridpane per contenere i bottoni delle figure ---------------
        String workingDir = System.getProperty("user.dir");
	System.out.println("Current working directory : " + workingDir); 
       
   
        
        Menubar barra = new Menubar();
        
        BorderPane root = new BorderPane();
        root.setCenter(splitPane);
        root.setTop(barra);
       
        
        Screen screen =Screen.getPrimary();
        Rectangle2D bordi2 = screen.getVisualBounds();
        Scene scene = new Scene(root,bordi2.getWidth() ,bordi2.getHeight() );
        
        
        
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
    
    public void lanciaevento()
    {
        ActionEvent evento = new ActionEvent();
    
    };
    

}
   
    
   
    
  
