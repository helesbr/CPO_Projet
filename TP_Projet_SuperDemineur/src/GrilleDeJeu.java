/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author helia
 */
public class GrilleDeJeu {
    private Cellule[][] matriceCellules;
    private int nbLines;
    private int nbColonnes;
    private int nbBombes;

    public int getNbLines() {
        return nbLines;
    }

    public int getNbColonnes() {
        return nbColonnes;
    }

    public int getNbBombes() {
        return nbBombes;
    }
    
    public void placerBombesAleatoirement(){
        int nbMaxBombes;             
        for (int a = 0; a < nbMaxBombes; a++) {
    int i = (int)(Math.random() * nbLines);
    int j = (int)(Math.random() * nbColonnes);

    if (!matriceCellules[i][j].isPresenceBombe()) {
        matriceCellules[i][j].placerBombe(); // place la bombe si la cellule est vide
    } else {
        a--; // recommence cette itération si la cellule avait déjà une bombe
    }
}

        
        }
    }
    
}
