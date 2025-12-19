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

    public GrilleDeJeu(int nbLines, int nbColonnes, int nbBombes) {
        this.nbLines = nbLines;
        this.nbColonnes = nbColonnes;
        this.nbBombes = nbBombes;
    }
    
    public void InitaliserGrille(){
    matriceCellules = new Cellule[nbLines][nbColonnes];
            for(int i=0; i<nbLines; i++){
                for (int j=0; j<nbColonnes; j++){
                    matriceCellules[i][j] = new Cellule();
                }
            }
    }
    
    public int getNbLines() {
        return nbLines;
    }

    public int getNbColonnes() {
        return nbColonnes;
    }

    public int getNbBombes() {
        return nbBombes;
    }
    public Cellule getCellule(int i, int j) {
    return matriceCellules[i][j];
}

    public void placerBombesAleatoirement(){
        int nbMaxBombes=nbBombes;           
        for (int a = 0; a < nbMaxBombes; a++) {
    int i = (int)(Math.random() * nbLines);
    int j = (int)(Math.random() * nbColonnes);

    if (!matriceCellules[i][j].isPresenceBombe()) {
        matriceCellules[i][j].placerBombe(); 
    } else {
        a--; 
    }
}
    }
        public void calculerBombesAdjacentes(){
            for (int i=0; i<nbLines;i++){
                for (int j=0; j<nbColonnes; j++){
                    if (!matriceCellules[i][j].isPresenceBombe()) {
                        int compteur = 0;
                for (int di = -1; di <= 1; di++) {
                        for (int dj=-1; dj<=1; dj++){
                            if(di==0&&dj==0){
                                continue;
                            }
                            int ni = i +di;
                            int nj = j + dj;
                            
                            if (ni>=0 && ni < nbLines && nj>=0&& nj<nbColonnes){
                                if (matriceCellules[ni][nj].isPresenceBombe()){
                                    compteur++;
                                }
                            }
                        
                    }
                } 
                matriceCellules[i][j].setNbBombesAdjacentes(compteur);
                    }
                }
                
            }}
        
public boolean revelerCellule(int nbLines, int nbColonnes) {
    if (nbLines < 0 || nbLines >= this.nbLines ||
        nbColonnes < 0 || nbColonnes >= this.nbColonnes) {
        return false;
    }
    Cellule c = matriceCellules[nbLines][nbColonnes];
    if (c.estDevoilee()) {
        return false;
    }
    if (c.isPresenceBombe()) {
        System.out.println("BOOM ! Partie terminée.");
        return true;
    }
    c.revelerCellule();
    if (c.getNbBombesAdjacentes() == 0) {
        for (int i = nbLines - 1; i <= nbLines + 1; i++) {
            for (int j = nbColonnes - 1; j <= nbColonnes + 1; j++) {
                revelerCellule(i, j);
            }
        }
    }
    return false;
}
public boolean getPresence(int i, int j){
            return matriceCellules[i][j].isPresenceBombe();
}

public boolean toutesCellulesRevelees(){
    for(int i=0 ;i<nbLines; i++){
        for (int j=0; j<nbColonnes; j++){
            if(!matriceCellules[i][j].isPresenceBombe() && !matriceCellules[i][j].estDevoilee()){
            return false;
            }
        }
    }return true;
}
public void revelerToutesLesCellules() {
    for (int i = 0; i < nbLines; i++) {
        for (int j = 0; j < nbColonnes; j++) {
            matriceCellules[i][j].revelerCellule();
        }
    }
}
        @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("   ");
    for (int j = 0; j < nbColonnes; j++) {
        sb.append(j).append(" ");
    }
    sb.append("\n");
    sb.append("  +");
    for (int j = 0; j < nbColonnes * 2; j++) {
        sb.append("-");
    }
    sb.append("+\n");
    for (int i = 0; i < nbLines; i++) {
        sb.append(i).append(" |");
        for (int j = 0; j < nbColonnes; j++) {
            sb.append(matriceCellules[i][j].toString()).append(" ");
        }
        sb.append("|\n");
    }
    sb.append("  +");
    for (int j = 0; j < nbColonnes * 2; j++) {
        sb.append("-");
    }
    sb.append("+\n");
    return sb.toString();
}
}
