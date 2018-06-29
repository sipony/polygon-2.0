/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygon.pkg2.pkg0;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 *
 * @author DAVIDE
 */
public class DisegnaLinea {
    
    //valori iniziali e finali del punto iniziale e finale della linea
    
    private double x_iniziale  = 0;
    private double y_iniziale  = 0;
    private double x_finale = 0;
    private double y_finale = 0;
    private int num_linea = 1;
    private StackPane root ;

    
    //costruttore
    public DisegnaLinea(StackPane pannello)
    {
         
        root = pannello;
        Canvas canvas = new Canvas(pannello.getPrefHeight(),pannello.getPrefWidth());
        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        this.SettaggioCanvas(graphicsContext);

        /*abilito il canvas a monitorare la presionne del mouse sul tasto sinistro
        * e all'occorenza della pressione invio l'evento in toto alla funzione setposiniz
        * che imposta le coordinate x,y dell punto iniziale della retta  
        *     
        */
        canvas.setOnMousePressed((event) -> this.setPosiniziale(event));
        
        
        canvas.setOnMouseDragged((event) -> {
            root.getChildren().remove(0);
            final Canvas temp_canvas = new Canvas(400, 400);
            final GraphicsContext gc = temp_canvas.getGraphicsContext2D();
            this.setPosfinale(event);
            this.drawLine(gc);
            root.getChildren().add(0,temp_canvas);
        });   
        
        canvas.setOnMouseReleased((event) -> {
            final Canvas new_line = new Canvas(400, 400);
            final GraphicsContext gc = new_line.getGraphicsContext2D();
            this.setPosfinale(event);
            this.drawLine(gc);
            //final new stright line
            root.getChildren().add(num_linea,new_line);             
        });
        
       root.getChildren().addAll( new Canvas(), canvas);

     
    }
    
    
    private void SettaggioCanvas(GraphicsContext gc){
        double canvasWidth = gc.getCanvas().getWidth();
        double canvasHeight = gc.getCanvas().getHeight();

        gc.setFill(Color.LIGHTGRAY);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);

        gc.fill();
        gc.strokeRect(
                0,              //x of the upper left corner
                0,              //y of the upper left corner
                canvasWidth,    //width of the rectangle
                canvasHeight);  //height of the rectangle
    }
    
    
    private void drawLine(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(1);
        gc.strokeLine(x_iniziale,y_iniziale, x_finale, y_finale);      
    }

    
   //funzione che setta la posizione iniziale per la retta 
  private void setPosiniziale(MouseEvent event) {
      
        this.x_iniziale= event.getSceneX();
        this.y_iniziale = event.getSceneY();
    }
  //funzione che setta la posizione finale per la retta
    private void setPosfinale(MouseEvent event) {
        this.x_finale = event.getSceneX();
        this.y_finale = event.getSceneY();
    }    
    
    
    
}
