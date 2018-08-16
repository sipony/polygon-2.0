/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygon.pkg2.pkg0;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author DAVIDE
 */
public class Disegna_linea {
    
 //------coordinate del punto iniziale e del punti finale e numero di segmenti.
    
    private double from_x = 0;
    private double from_y = 0;
    private double to_x = 0;
    private double to_y = 0;
    private int line_no = 1;
    
    
public Disegna_linea(StackPane pan_canvas, Stage primary)
{       
        
        //StackPane root = new StackPane();
        Canvas canvas = new Canvas(pan_canvas.getMaxWidth(), pan_canvas.getMaxHeight());
        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        this.initDraw(graphicsContext);

        canvas.setOnMousePressed((event) -> this.setFromPos(event));
        
        /*
          ogni volta che il mouse viene spostato rimuove il canvas iniziale 
          create e messo nello stackpane e succesivamente ad ogni movimento crea la linea da mettere
          nel canvas temporaneo che viene aggiunto allo stackpane root per far vedere la linea succesiva relativa al movimento 
        
        */
        canvas.setOnMouseDragged((event) -> {
            pan_canvas.getChildren().remove(0);
            final Canvas temp_canvas = new Canvas(400, 400);
            final GraphicsContext gc = temp_canvas.getGraphicsContext2D();
            this.setToPos(event);
            this.drawLine(gc);
            pan_canvas.getChildren().add(0,temp_canvas);
        });   
        
        
        /*
        
        quando viene rilasciato il pulsante del mouse crea un nuovo canvas chiamato newline
        ne acquisisce il graphicsovntext ,richiama la funzione setpos per fissare la posizione finale del mouse che 
        e in sostanza il punto finale della linea ,e richiama la funzione darawline per disegnare la linea 
        
        
        */
        canvas.setOnMouseReleased((event) -> {
            final Canvas new_line = new Canvas(400, 400);
            final GraphicsContext gc = new_line.getGraphicsContext2D();
            this.setToPos(event);
            this.drawLine(gc);
            //final new stright line
            pan_canvas.getChildren().add(line_no++,new_line);             
        });
        
        //importante mette un new Canvas perche la prima funzione era remove ,e quindi ci deve essere almeno un elemento sullo
        //stakckpane altrimenti non rimuove nulla;
        pan_canvas.getChildren().addAll( new Canvas() , canvas);
        Scene scene = new Scene(pan_canvas, 400, 400);
        primary.setTitle("disegna linea");
        primary.setScene(scene);
        primary.show();

        

}    
    
 private void drawLine(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(1);
        gc.strokeLine(from_x, from_y, to_x, to_y);      
    }

    private void initDraw(GraphicsContext gc){
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

    private void setFromPos(MouseEvent event) {
        this.from_x = event.getSceneX();
        this.from_y = event.getSceneY();
    }

    private void setToPos(MouseEvent event) {
        this.to_x = event.getSceneX();
        this.to_y = event.getSceneY();
    } 
           
    
    
    
    
    
}
