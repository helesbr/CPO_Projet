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
    private int nbVies;
    private boolean partieTerminee;
    
    public void initaliserPartie(){
        grille = new GrilleDeJeu(grille.getNbLines(), grille.getNbColonnes(), grille.getNbBombes());
        grille.placerBombesAleatoirement();
        nbVies = 1;               
        partieTerminee = false;
    }
}
