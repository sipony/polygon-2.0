/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygon.pkg2.pkg0;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Deen Kugar
 */
public class Strumenti {
    
     private final Button[] pulsanti;
     private final  Image Immagini[];
     private final  ImageView viste [];
     private  String Path;
     private  String file;
     private  File[] Listafile;
     private  File cartella;
     private final  GridPane grid;
     private  int j ;
     private  Canvas foglio_disegno;
     
  
     
     public Strumenti(StackPane pannello,StackPane pan_canvas,double width,double height,Stage primario) throws FileNotFoundException
     {  
         //carico path delle immagini
         
         
         Immagini = new Image[10];
         viste = new ImageView[10];
         grid = new GridPane();
         pulsanti = new Button[10];
         List<String> nomi_file = new ArrayList<>();
         List<Image> image_icon = new ArrayList<>();
         
        String workingDir = System.getProperty("user.dir");
	System.out.println("Current working directory : " + workingDir); 

         File directory = new File("/Users/DAVIDE/NetBeansProjects/Griglia/src/griglia/immagini");
         //prendo tutti i file dalla directory
         File[] fList = directory.listFiles();
         System.out.println(fList.length);
         int j = 0;
         //imposto le dimensioni del gridpane e le distanze tra bottoni
          for (int i = 1 ;i < fList.length;i++)
           {   

                if(fList[i].getName().contains("_btn"))
                {   
                   
                    nomi_file.add(fList[i].getName());
                    System.out.println(nomi_file.get(j));
                    FileInputStream inputstream = new FileInputStream(fList[i].getAbsoluteFile()); 
                    image_icon.add(new Image(inputstream));
                    pulsanti[j]=new Button();
                    pulsanti[j].setPrefSize(width,height);
                    viste[j]= new ImageView(image_icon.get(j));
                    viste[j].setFitHeight(25);
                    viste[j].setFitWidth(25);
                    pulsanti[j].setGraphic(viste[j]);
                    j++;
                  }
                 
            }
        set_button(pannello);
        set_comp(pan_canvas,primario);
     }   
         
  private void set_button(StackPane pannello)
    {
        grid.setPrefSize(50, 305);
        grid.setVgap(6);
        grid.setHgap(2);
        
        grid.add(pulsanti[0], 0, 1);
        grid.add(pulsanti[1], 1, 1);
        grid.add(pulsanti[2], 0, 2);
        grid.add(pulsanti[3], 1, 2);
        grid.add(pulsanti[4], 0, 3);
        grid.add(pulsanti[5], 1, 3);
        grid.add(pulsanti[6], 0, 4);
        grid.add(pulsanti[7], 1, 4);
        grid.add(pulsanti[8], 0, 5);
        grid.add(pulsanti[9], 1, 5);
    
        pannello.getChildren().add(grid);
        
    }
  
  
   public void set_comp(StackPane pan_canvas,Stage primary)
   {
      pulsanti[0].setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    Disegna_linea disegna = new Disegna_linea(pan_canvas, primary);
            }
        });
}
   
   
   
   
   
   
   }
  
  
    
   
