/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author helia
 */

public class Partie {
    private GrilleDeJeu grille;
    private boolean partieTerminee;
    
public void tourDeJeu(int ligne, int colonne) {

    if (partieTerminee) {
        return;
    }

    grille.revelerCellule(ligne, colonne);
}
    
}
