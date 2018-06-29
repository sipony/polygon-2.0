/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygon.pkg2.pkg0;

import javafx.geometry.Orientation;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Deen Kugar
 */
public class Pannello_inferiore extends AnchorPane{
    
    private TextField currentx;
    private TextField currenty;
    private TextField valorex;
    private TextField valorey;
    private ColorPicker colorelinea;
    private Label title1;
    private Label title2;
    private Label current_x;
    private Label current_y;
    private Separator separatore1;
    private Separator separatore2;
    
    
    public Pannello_inferiore(double altezza,double larghezza)
    {
        currentx = new TextField();
        currenty = new TextField();
        valorex  = new TextField();
        valorey  = new TextField();
        current_x = new Label("VALORE CORRENTE X :");
        current_y = new Label("VALORE CORRENTE Y :");
        title1 = new Label (" CORDINATE PUNTATORE ");
        title1.setStyle("-fx-text-fill: #000000; -fx-font-size: 28px; -fx-translate-x: -36; -fx-translate-y: 24; -fx-font-family: 'Arial'");

        separatore1 = new Separator();
        separatore2 = new Separator();
        
         // imposto stramite la funzione stelayout la distanza ripsetto all origne (sempre riferita in alto a destra del contenitore)degli elementi
        current_x.setLayoutY(60);
        current_x.setLayoutX(40);
        
        current_y.setLayoutY(90);
        current_y.setLayoutX(40);
        
       
        currentx.setLayoutX(200);
        currentx.setLayoutY(55);
        
        currenty.setLayoutX(200);
        currenty.setLayoutY(85);
        
        title1.setLayoutX(60);
        title1.setLayoutY(-20);
        
        currentx.setPrefSize(100, 25);
        currenty.setPrefSize(100,25);
        
        separatore1.setPrefSize(4, larghezza/2);
        separatore1.setOrientation(Orientation.VERTICAL);
        separatore1.setLayoutX((larghezza/2)-200);
        separatore1.setLayoutY(0);
        
        
        set_all(currentx,currenty,current_x,current_y,title1,separatore1);
      
    
    }
    
  private void set_all(TextField campo1 , TextField campo2 ,Label etichetta1 ,Label etichetta2,Label etichetta3,Separator sep)
   {
        this.getChildren().add(campo1);
        this.getChildren().add(campo2);
        this.getChildren().add(etichetta3);
        this.getChildren().add(etichetta1);
        this.getChildren().add(etichetta2);
        this.getChildren().add(sep);
   
   }
    
  
  public void set_campox(String valore)
          {
              currentx.setText(valore);     
          }
  
  public void set_campoy(String valore)
          {
              currenty.setText(valore);
          }
    
}
