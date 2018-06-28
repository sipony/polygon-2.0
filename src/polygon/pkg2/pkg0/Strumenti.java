/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygon.pkg2.pkg0;

import java.io.File;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Deen Kugar
 */
public class Strumenti extends StackPane{
    
     private final  Button bottoni[];
     private  Image Immagini[];
     private final  ImageView viste [];
     private final  String Path;
     private  String file;
     private final  File[] Listafile;
     private final  File cartella;
     private final  GridPane griglia;
     
     public Strumenti()
     {  
         //carico path delle immagini
         
         Path ="C:\\Users\\Deen Kugar\\Documents\\NetBeansProjects\\polygon-2.0\\Icone";  
         cartella =new File(Path);
         Immagini = new Image[50];
         Listafile = cartella.listFiles(); //prendo l elenco dei file dalla cartella
         bottoni = new Button[10];
         Immagini = new Image[10];
         viste = new ImageView[10];
         griglia = new GridPane();
         
         //imposto le dimensioni del gridpane e le distanze tra bottoni
        
         
        set_button(bottoni,Immagini,viste,Listafile,Path,cartella);
         
        set_all(bottoni,griglia); 
         
     }   
         
  private void set_button(Button[] bottoni,Image[] immagini,ImageView[] viste,File[] Listafile ,String path,File cartella)
    {
      for(int i=0;i<Listafile.length;i++)
         {   
             if(Listafile[i].getName().contains("_btn")) //controllo che sia l'iconadi un bottone
             {
                 System.out.println(Listafile[i].getAbsolutePath());
                 file = "file:" + Listafile[i].getAbsolutePath();//il + concatena le strighe
                 
                 
                  bottoni[i].setPrefSize(25, 61);
                  Immagini[i]= new Image(getClass().getResourceAsStream(Listafile[i].getAbsolutePath())); //ricavo immagini dai file
                  viste[i]= new ImageView(Immagini[i]);
                  viste[i].setFitHeight(25);
                  viste[i].setFitWidth(25);
                  bottoni[i].setGraphic(viste[i]);
             } 
             
         
                  
             
         }
    
    }
  private void set_all(Button[] bottoni,GridPane griglia){    
        griglia.setPrefSize(50, 305);
        griglia.setVgap(6);
        griglia.setHgap(2);  
                //aggiungo i bottoni alla gridpane in 2 colonne e 5 righe 
                
            for(int k = 0; k<=9;k++){
                      for(int z = 0; z<=4 ;z++){
                        for(int y = 0; y<=1; y++)
                               griglia.add(bottoni[k], y, z);
                      }
                   }
     
        this.getChildren().add(griglia);
        this.setStyle("-fx-background-color:#d7d6d5;");
      }
    
       
    
    
}
