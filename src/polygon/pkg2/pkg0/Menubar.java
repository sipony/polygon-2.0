/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygon.pkg2.pkg0;
import java.awt.event.KeyEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
/**
 *
 * @author DAVIDE
 */
public class Menubar extends MenuBar{
   
    private final Menu File;
    private final Menu Impostazioni;
    private final Menu Strumenti;
    private final Menu Aiuto;
    
    private final MenuItem Nuovo;
    private final MenuItem Apri;
    private final MenuItem Salva;
    private final MenuItem Esci;
    private final MenuItem SalvaNome;
    private final MenuItem Coloresfondo;
    private final MenuItem SpessoreLinea;
    private final MenuItem Taglia;
    private final MenuItem Copia;
    private final MenuItem Incolla;
    private final MenuItem Aboutus;
    private final MenuItem Undo;
    private final MenuItem Redo;
    private final MenuItem Stampa;
    private final MenuItem Seleziona;
    
    private final SeparatorMenuItem  separatore1;
    private final SeparatorMenuItem  separatore2;
    private final SeparatorMenuItem  separatore3;
    
    
    
    
public Menubar()
{
   //------Instanzio oggetti Menu presenti nella barra---------------------------------// 
   File =new Menu("File");
   Impostazioni =new Menu("impostazioni");
   Strumenti = new Menu("Strumenti");
   Aiuto = new Menu("Aiuto");
   
   
   //-----Instanzio oggetti Menuitem da bindare ai menu sopra definiti-----------------//
   
   Nuovo = new MenuItem("Nuovo File...");
   Nuovo.setAccelerator(new KeyCodeCombination(KeyCode.N,KeyCombination.SHIFT_DOWN) );

   Apri  = new MenuItem("Apri");
   Apri.setAccelerator(new KeyCodeCombination(KeyCode.A,KeyCombination.CONTROL_DOWN) );

   Salva = new MenuItem("Salva");
   Salva.setAccelerator(new KeyCodeCombination(KeyCode.S,KeyCombination.ALT_DOWN) );
   
   Copia = new MenuItem("Copia");
   Copia.setAccelerator(new KeyCodeCombination(KeyCode.C,KeyCombination.CONTROL_DOWN) );
   
   Taglia = new MenuItem("Taglia");
   Taglia.setAccelerator(new KeyCodeCombination(KeyCode.T,KeyCombination.CONTROL_DOWN) );
   
   Incolla= new MenuItem("Incolla");
   Incolla.setAccelerator(new KeyCodeCombination(KeyCode.V,KeyCombination.CONTROL_DOWN) );
   
   Undo = new MenuItem("Undo ..");
   Undo.setAccelerator(new KeyCodeCombination(KeyCode.Z,KeyCombination.ALT_DOWN) );
   
   Redo = new MenuItem("Redo ..");
   Redo.setAccelerator(new KeyCodeCombination(KeyCode.X,KeyCombination.ALT_DOWN) );
   
   Stampa = new MenuItem("Stampa");
   Stampa.setAccelerator(new KeyCodeCombination(KeyCode.S,KeyCombination.ALT_DOWN) );
   
   Seleziona = new MenuItem("Seleziona");
   Seleziona.setAccelerator(new KeyCodeCombination(KeyCode.S,KeyCombination.ALT_DOWN) );
   
   Aboutus = new MenuItem("About us");
   Aboutus.setAccelerator(new KeyCodeCombination(KeyCode.S,KeyCombination.ALT_DOWN) );
   
   Coloresfondo = new MenuItem("Colore Sfondo");
   
   SpessoreLinea  = new MenuItem("SpessoreLinea");
   

   SalvaNome =new MenuItem("Salva File con nome");
   Esci = new MenuItem("Esci");
   separatore1 = new SeparatorMenuItem();
   separatore2 = new SeparatorMenuItem();
   separatore3 = new SeparatorMenuItem();

        
   //----Imposto le icone dell' sottomenu----------------------------------------------//
   
   //sottmenu esci
   Image Icona = new Image(getClass().getResourceAsStream("exit.png"));
   ImageView vista= new ImageView(Icona);
   vista.setFitHeight(15);
   vista.setFitWidth(15);
   Esci.setGraphic(vista);
   Esci.setOnAction(new EventHandler<ActionEvent>()
           {
            @Override public void handle(ActionEvent e) {
                System.exit(0);
           
           }
           } );
   
   
   // sottomenu Nuovo File
   Image Icona1 = new Image(getClass().getResourceAsStream("nuovo.png"));
   ImageView vista1 = new ImageView(Icona1);
   vista1.setFitHeight(15);
   vista1.setFitWidth(15);
   Nuovo.setGraphic(vista1);
   Nuovo.setOnAction(new EventHandler<ActionEvent>()
           {
            @Override public void handle(ActionEvent e) {
                System.exit(0);
           
           }
           } );
   
   // sottomenu Apri File
   
   Image Icona2 = new Image(getClass().getResourceAsStream("apri.png"));
   ImageView vista2 = new ImageView(Icona2);
   vista2.setFitHeight(15);
   vista2.setFitWidth(15);
   Apri.setGraphic(vista2);
   Apri.setOnAction(new EventHandler<ActionEvent>()
           {
            @Override public void handle(ActionEvent e) {
                System.exit(0);
           
           }
           } );
   
    //sottomenu salva file       
  
   Image Icona3 = new Image(getClass().getResourceAsStream("salva.png"));
   ImageView vista3 = new ImageView(Icona3);
   vista3.setFitHeight(15);
   vista3.setFitWidth(15);
   SalvaNome.setGraphic(vista3);
   SalvaNome.setOnAction(new EventHandler<ActionEvent>()
           {
            @Override public void handle(ActionEvent e) {
                System.exit(0);
           
           }
           } );
   
   
   Image Icona11 = new Image(getClass().getResourceAsStream("stampa.png"));
   ImageView vista11= new ImageView(Icona11);
   vista11.setFitHeight(15);
   vista11.setFitWidth(15);
   Stampa.setGraphic(vista11);
   Stampa.setOnAction(new EventHandler<ActionEvent>()
           {
            @Override public void handle(ActionEvent e) {
                System.exit(0);
           
           }
           } );

   
  
   Image Icona6 = new Image(getClass().getResourceAsStream("impostazioni.png"));
   ImageView vista6= new ImageView(Icona6);
   vista6.setFitHeight(15);
   vista6.setFitWidth(15);
   Impostazioni.setGraphic(vista6);
   
   Image Icona7 = new Image(getClass().getResourceAsStream("strumenti.png"));
   ImageView vista7= new ImageView(Icona7);
   vista6.setFitHeight(15);
   vista6.setFitWidth(15);
   Strumenti.setGraphic(vista7);
   
   Image Icona8 = new Image(getClass().getResourceAsStream("aiuto.png"));
   ImageView vista8= new ImageView(Icona8);
   vista6.setFitHeight(15);
   vista6.setFitWidth(15);
   Aiuto.setGraphic(vista8);
   
   
   
   
   
   
   
   //------------------------- Aggiungo gli itemmenu al menu File------------------------\\ 
   
   File.getItems().add(Nuovo);
   File.getItems().add(Apri);
   File.getItems().add(Salva);
   File.getItems().add(SalvaNome);
   File.getItems().add(Stampa);
   File.getItems().add(separatore1);
   File.getItems().add(Esci);
   
   //------------------------ Aggiungo gli itemmenu al menu Strumenti--------------------\\
   
   Image Icona12 = new Image(getClass().getResourceAsStream("taglia.png"));
   ImageView vista12= new ImageView(Icona12);
   vista12.setFitHeight(15);
   vista12.setFitWidth(15);
   Taglia.setGraphic(vista12);
   Taglia.setOnAction(new EventHandler<ActionEvent>()
           {
            @Override public void handle(ActionEvent e) {
                System.exit(0);
           
           }
           } );
   
   Image Icona13 = new Image(getClass().getResourceAsStream("copia.png"));
   ImageView vista13= new ImageView(Icona13);
   vista13.setFitHeight(15);
   vista13.setFitWidth(15);
   Copia.setGraphic(vista13);
   Copia.setOnAction(new EventHandler<ActionEvent>()
           {
            @Override public void handle(ActionEvent e) {
                System.exit(0);
           
           }
           } );
   
   Image Icona14 = new Image(getClass().getResourceAsStream("undo.png"));
   ImageView vista14= new ImageView(Icona14);
   vista14.setFitHeight(15);
   vista14.setFitWidth(15);
   Undo.setGraphic(vista14);
   Undo.setOnAction(new EventHandler<ActionEvent>()
           {
            @Override public void handle(ActionEvent e) {
                System.exit(0);
           
           }
           } );
   Image Icona15 = new Image(getClass().getResourceAsStream("redo.png"));
   ImageView vista15= new ImageView(Icona15);
   vista15.setFitHeight(15);
   vista15.setFitWidth(15);
   Redo.setGraphic(vista15);
   Redo.setOnAction(new EventHandler<ActionEvent>()
           {
            @Override public void handle(ActionEvent e) {
                System.exit(0);
           
           }
           } );
   
   
   Image Icona16 = new Image(getClass().getResourceAsStream("incolla.png"));
   ImageView vista16= new ImageView(Icona16);
   vista16.setFitHeight(15);
   vista16.setFitWidth(15);
   Incolla.setGraphic(vista16);
   Incolla.setOnAction(new EventHandler<ActionEvent>()
           {
            @Override public void handle(ActionEvent e) {
                System.exit(0);
           
           }
           } );
  
     
   
   
   Strumenti.getItems().add(Undo);
   Strumenti.getItems().add(Redo);
   Strumenti.getItems().add(Taglia);
   Strumenti.getItems().add(Copia);
   Strumenti.getItems().add(Incolla);
   
   
   //--------------------- Aggiungo gli item al Menu Impostazioni --------------------------------//
   
   Impostazioni.getItems().add(Coloresfondo);
   Impostazioni.getItems().add(SpessoreLinea);
 
   
   
   
   
   
   
   
   
   
   
   
   
   
   //----------------------------------------------------------------------------------------------//
  
   
   
   
   this.getMenus().add(File);
   this.getMenus().add(Impostazioni);
   this.getMenus().add(Strumenti);
   this.getMenus().add(Aiuto);


}
    
        
    
 public Menubar get_Menubar(){ 
    return (this);}
    
}
