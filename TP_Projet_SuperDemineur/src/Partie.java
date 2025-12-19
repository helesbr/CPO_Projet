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
    private boolean victoire;
    private int nbVies;
    private int nbLines;
    private int nbColonnes;
    private int NbBombes;

    public GrilleDeJeu getGrille() {
    return grille;
}

public void tourDeJeu(int nbLines, int nbColonne) {
    if (partieTerminee) {
        return;
    }
    boolean bombe = grille.revelerCellule(nbLines, nbColonne);
    verifierFinDePartie(bombe);
}
    
    public void initaliserPartie(int nbLines, int nbColonnes, int NbBombes){
        this.nbLines = nbLines;
        this.nbColonnes = nbColonnes;
        this.NbBombes = NbBombes;
        grille = new GrilleDeJeu(this.nbLines, this.nbColonnes, this.NbBombes);
        grille.InitaliserGrille();
        grille.placerBombesAleatoirement();
        nbVies = 1;               
        partieTerminee = false;
    }
    public void demarrerPartie() {
    partieTerminee = false;
    grille.calculerBombesAdjacentes();
    System.out.println("La partie commence !");
}
    
 public void verifierFinDePartie(boolean bombeCliquee){
     if (bombeCliquee) {
        partieTerminee = true;
        grille.revelerToutesLesCellules();
        System.out.println("Boom Défaite !");
        return;
    }
     if (grille.toutesCellulesRevelees()==true){
         partieTerminee = true;
         victoire = true;
     }
 }   
 public boolean isPartieTerminee() {
    return partieTerminee;
}
}
