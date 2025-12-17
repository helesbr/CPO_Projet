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

    public void InitaliserGrille(){
    matriceCellules = new Cellule[10][10];
            for(int i=0; i<10; i++){
                for (int j=0; j<10; j++){
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
    
    public void placerBombesAleatoirement(){
        int nbMaxBombes=0;           
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
                                if (matriceCellules[nj][ni].isPresenceBombe()){
                                    compteur++;
                                }
                            }
                        
                    }
                } 
                matriceCellules[i][j].setNbBombesAdjacentes(compteur);
                    }
                }
            }
        }

 

public boolean getPresence(int i, int j){
            return matriceCellules[i][j].isPresenceBombe();
}

public boolean toutesCellulesRevelees(){
    for(int i=0 ;i<nbLines; i++){
        for (int j=0; j<nbColonnes; j++){
            if(!matriceCellules[i][j].isPresenceBombe()) && !matriceCellules[i][j].isrevellerCellule()){
            return false;
            }
        }
    }return true;
}
}

                
           
        

        
        
    
    

