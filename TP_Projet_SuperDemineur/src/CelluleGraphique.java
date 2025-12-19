
import javax.swing.JButton;
import java.awt.Graphics;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author helia
 */
public class CelluleGraphique extends JButton {
    int largeur; 
    int hauteur;
    
    Cellule celluleLumineuseAssociee;

 public CelluleGraphique(Cellule celluleLumineuseAssociee, int l,int h) {
 this.largeur = l;
 this.hauteur = h;
 this.celluleLumineuseAssociee = celluleLumineuseAssociee;
 }
 
 @Override
 protected void paintComponent(Graphics g) {
 super.paintComponent(g);
 this.setText(celluleLumineuseAssociee.toString());
 if (celluleLumineuseAssociee.estDevoilee()) this.setEnabled(false);
 
 
 }
 public void actualiser() {
        this.setText(celluleLumineuseAssociee.toString());
        this.setEnabled(!celluleLumineuseAssociee.estDevoilee());
        repaint();
    }
}



