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
    private int nbCellulesRevelees = 0;

    public GrilleDeJeu getGrille() {
        return grille;
    }

    public void tourDeJeu(int ligne, int colonne) {
    if (partieTerminee) {
        return;
    }
    boolean bombeCliquee = grille.getCellule(ligne, colonne).isPresenceBombe();
    if (bombeCliquee) {
        nbVies--;
    }
    int nouvellesCasesRevelees = grille.revelerCellule(ligne, colonne, nbVies, NbBombes);

    nbCellulesRevelees += nouvellesCasesRevelees;

    verifierFinDePartie(bombeCliquee);
}


    public void initaliserPartie(int nbLines, int nbColonnes, int NbBombes, int nbVies) {
        this.nbLines = nbLines;
        this.nbColonnes = nbColonnes;
        this.NbBombes = NbBombes;
        this.nbVies = nbVies;
        grille = new GrilleDeJeu(this.nbLines, this.nbColonnes, this.NbBombes, this.nbVies);
        grille.InitaliserGrille();
        grille.placerBombesAleatoirement();
        partieTerminee = false;
    }

    public void demarrerPartie() {
        partieTerminee = false;
        grille.calculerBombesAdjacentes();
        System.out.println("La partie commence !");
    }

    public void verifierFinDePartie(boolean bombeCliquee) {
        if (nbVies<=0) {
            partieTerminee = true;
            grille.revelerToutesLesCellules();
            System.out.println("Boom Défaite !");
            return;
        }
        if (grille.toutesCellulesRevelees() == true) {
            partieTerminee = true;
            victoire = true;
            grille.revelerToutesLesCellules();
        }
    }

    public boolean isPartieTerminee() {
        return partieTerminee;
    }

    public int getNbCellulesRevelees() {
        return nbCellulesRevelees;
    }

    public boolean isVictoire() {
        return victoire;
    }
}
