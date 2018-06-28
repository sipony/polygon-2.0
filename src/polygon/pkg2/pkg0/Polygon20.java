/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygon.pkg2.pkg0;


import java.io.File;
import static java.time.Clock.system;
import javafx.application.Application;
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
        //--------fisso il divider dello splitpane tra canvas e strumenti
        leftPane.setMinWidth(105);
        leftPane.setMaxWidth(105);
        
        //-----------divido il leftpane-----------//
        
        
        AnchorPane upPane = new AnchorPane(new Label("Uppaneleft"));
        upPane.setPrefWidth(100);
        upPane.setPrefHeight(610);
        upPane.setStyle("-fx-background-color: #FFFFFF;");
        
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
        upPane.setMaxHeight(400);
        upPane.setMinHeight(400);
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
     
        StackPane upPane2 = new StackPane(new Label("Uppaneright"));
        upPane2.setStyle("-fx-background-color:#d8dee3;");
        Pannello_inferiore downPane2= new Pannello_inferiore();
        downPane2.setStyle("-fx-background-color:#d7d6d5;");
        Canvas foglio = new Canvas();
         upPane2.getChildren().add(foglio);
        //---------creo canvas
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
         Image ret = new Image(getClass().getResourceAsStream("millimetrata2.jpg"));
         BackgroundSize dimensioni=new BackgroundSize(upPane2.getPrefWidth(),upPane2.getPrefHeight(),false,false,false,true);
         BackgroundImage backgroundimage = new BackgroundImage(ret,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,dimensioni);
         upPane2.setBackground(new Background(backgroundimage));
      
         SplitPane splitPane3 = new SplitPane();
         splitPane3.setOrientation(Orientation.VERTICAL);
        //---------fisso il divider del rightpane---------------//
        upPane2.setMaxHeight(800);
        upPane2.setMinHeight(800);
       
        //---------------------------------------------------------//
        splitPane3.getItems().addAll(upPane2, downPane2);
        rightPane.getChildren().add(splitPane3);
 
        
        //-------creo la gridpane per contenere i bottoni delle figure ---------------
        
        
      
        
        
       Button bottone1= new Button();
       Button bottone2= new Button();
       Button bottone3= new Button();
       Button bottone4= new Button();
       Button bottone5= new Button();
       Button bottone6= new Button();
       Button bottone7= new Button();
       Button bottone8= new Button();
       Button bottone9= new Button();
       Button bottone10= new Button();
       
       bottone1.setPrefSize(upPane.getPrefWidth()/2,upPane.getPrefHeight()/10 );
       Image image1 = new Image(getClass().getResourceAsStream("linea.png"));
       ImageView vista1=new ImageView(image1);
       bottone1.setGraphic(vista1);
       
       
       bottone2.setPrefSize(upPane.getPrefWidth()/2,upPane.getPrefHeight()/10 );
       Image image2 = new Image(getClass().getResourceAsStream("triangolo.png"));
       ImageView vista2= new ImageView(image2);
       vista2.setFitHeight(25);
       vista2.setFitWidth(25);
       bottone2.setGraphic(vista2);
       
       
       bottone3.setPrefSize(upPane.getPrefWidth()/2,upPane.getPrefHeight()/10 );
       Image image3= new Image(getClass().getResourceAsStream("rettangolo.png"));
       ImageView vista3= new ImageView(image3);
       vista3.setFitHeight(25);
       vista3.setFitWidth(25);
       bottone3.setGraphic(vista3);
       
       
       bottone4.setPrefSize(upPane.getPrefWidth()/2,upPane.getPrefHeight()/10 );
       Image image4= new Image(getClass().getResourceAsStream("cerchio.png"));
       ImageView vista4= new ImageView(image4);
       vista4.setFitHeight(25);
       vista4.setFitWidth(25);
       bottone4.setGraphic(vista4);
       
       bottone5.setPrefSize(upPane.getPrefWidth()/2,upPane.getPrefHeight()/10 );
       Image image5= new Image(getClass().getResourceAsStream("rombo.png"));
       ImageView vista5= new ImageView(image5);
       vista5.setFitHeight(25);
       vista5.setFitWidth(25);
       bottone5.setGraphic(vista5);
       
       bottone6.setPrefSize(upPane.getPrefWidth()/2,upPane.getPrefHeight()/10 );
       Image image6= new Image(getClass().getResourceAsStream("ellisse.png"));
       ImageView vista6= new ImageView(image6);
       vista6.setFitHeight(25);
       vista6.setFitWidth(25);
       bottone6.setGraphic(vista6);
       
       bottone7.setPrefSize(upPane.getPrefWidth()/2,upPane.getPrefHeight()/10 );
       Image image7= new Image(getClass().getResourceAsStream("selezione.png"));
       ImageView vista7= new ImageView(image7);
       vista7.setFitHeight(25);
       vista7.setFitWidth(25);
       bottone7.setGraphic(vista7);
       
       bottone8.setPrefSize(upPane.getPrefWidth()/2,upPane.getPrefHeight()/10 );
       Image image8= new Image(getClass().getResourceAsStream("sposta.png"));
       ImageView vista8= new ImageView(image8);
       vista8.setFitHeight(25);
       vista8.setFitWidth(25);
       bottone8.setGraphic(vista8);
       
       bottone9.setPrefSize(upPane.getPrefWidth()/2,upPane.getPrefHeight()/10 );
       Image image9= new Image(getClass().getResourceAsStream("libera.png"));
       ImageView vista9= new ImageView(image9);
       vista9.setFitHeight(25);
       vista9.setFitWidth(25);
       bottone9.setGraphic(vista9);
       
       
       bottone10.setPrefSize(upPane.getPrefWidth()/2,upPane.getPrefHeight()/10 );

       Image image10 = new Image(getClass().getResourceAsStream("sega.png"));
       ImageView vista10 = new ImageView(image10);
       vista10.setFitHeight(25);
       vista10.setFitWidth(25);
       bottone10.setGraphic(vista10);
       
       
       
       
       
       bottone2.setPrefSize(upPane.getPrefWidth()/2,upPane.getPrefHeight()/10 );
       bottone3.setPrefSize(upPane.getPrefWidth()/2,upPane.getPrefHeight()/10);
       bottone4.setPrefSize(upPane.getPrefWidth()/2,upPane.getPrefHeight()/10 );
       bottone5.setPrefSize(upPane.getPrefWidth()/2,upPane.getPrefHeight()/10);
       bottone6.setPrefSize(upPane.getPrefWidth()/2,upPane.getPrefHeight()/10 );
       bottone7.setPrefSize(upPane.getPrefWidth()/2,upPane.getPrefHeight()/10 );
       bottone8.setPrefSize(upPane.getPrefWidth()/2,upPane.getPrefHeight()/10 );
       bottone9.setPrefSize(upPane.getPrefWidth()/2,upPane.getPrefHeight()/10 );
       bottone10.setPrefSize(upPane.getPrefWidth()/2,upPane.getPrefHeight()/10 );
       
       GridPane griglia = new GridPane();
       griglia.setVgap(6);
       griglia.setHgap(2);
       griglia.add(bottone1, 0, 1);
       griglia.add(bottone2, 1, 1);
       griglia.add(bottone3, 0, 2);
       griglia.add(bottone4, 1, 2);
       griglia.add(bottone5, 0, 3);
       griglia.add(bottone6, 1, 3);
       griglia.add(bottone7, 0, 4);
       griglia.add(bottone8, 1, 4);
       griglia.add(bottone9, 0, 5);
       griglia.add(bottone10, 1, 5);
       
       
      
     
       
       
       strumenti.getChildren().add(griglia);
       
      
       
        
      
  
        
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
