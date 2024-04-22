/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloDesign;

import java.awt.Color;
import javax.swing.JLabel;
import menuPackage.MenuPage;
import nicemenu.PanelGradient;

/**
 *
 * @author Paragon
 */
public class AnimateBTT {
    

private void mostrarColor(PanelGradient panex,PanelGradient panez,JLabel lblx,String url ){

    panex.setBackground(new Color(204,204,204));
panez.setColorGradient(Color.BLACK);
lblx.setForeground(Color.WHITE);

}
private void estableColor(PanelGradient panex,PanelGradient panez,JLabel lblx,String url ){

    panex.setBackground(new Color (204,204,204));
panez.setColorGradient(new Color(204,204,204));
lblx.setForeground(new Color(51,51,51));

}

    public void AnimattIni() {
   

        mostrarColor(MenuPage.btt_inicio, MenuPage.btt_inicio,MenuPage.lbl_ini,"");
        estableColor(MenuPage.btt_prueba, MenuPage.btt_prueba, MenuPage.lbl_prueba, "");
     estableColor(MenuPage.btt_pruebaOne, MenuPage.btt_pruebaOne, MenuPage.lbl_pruebaOne, "");
   
    
    }
public void Animattprueba() {
   
        mostrarColor(MenuPage.btt_prueba, MenuPage.btt_prueba,MenuPage.lbl_prueba,"");
        estableColor(MenuPage.btt_inicio, MenuPage.btt_inicio, MenuPage.lbl_ini, "");
     estableColor(MenuPage.btt_pruebaOne, MenuPage.btt_pruebaOne, MenuPage.lbl_pruebaOne, "");
   
    
    }

public void AnimattpruebaOne() {
   
        mostrarColor(MenuPage.btt_pruebaOne, MenuPage.btt_pruebaOne,MenuPage.lbl_pruebaOne,"");
        estableColor(MenuPage.btt_inicio, MenuPage.btt_inicio, MenuPage.lbl_ini, "");
     estableColor(MenuPage.btt_prueba, MenuPage.btt_prueba, MenuPage.lbl_prueba, "");
   
    
    }
public void AnimattpruebaTwo() {
   
       
        estableColor(MenuPage.btt_inicio, MenuPage.btt_inicio, MenuPage.lbl_ini, "");
     estableColor(MenuPage.btt_prueba, MenuPage.btt_prueba, MenuPage.lbl_prueba, "");
     estableColor(MenuPage.btt_pruebaOne, MenuPage.btt_pruebaOne, MenuPage.lbl_pruebaOne, "");
    
    }
}