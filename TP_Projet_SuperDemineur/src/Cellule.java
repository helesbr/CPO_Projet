/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author helia
 */
public class Cellule {
   private boolean presenceBombe;
   private boolean devoilee;
    private int nbBombesAdjacentes;

    public boolean isPresenceBombe() {
        return presenceBombe;
    }

public void setNbBombesAdjacentes(int nbBombesAdjacentes) {
        this.nbBombesAdjacentes = nbBombesAdjacentes;
    }

    public int getNbBombesAdjacentes() {
        return nbBombesAdjacentes;
    }
    
   public void placerBombe(){
        if (!presenceBombe){
        presenceBombe=true;
    }
    }
     
    public void revelerCellule(){
        devoilee=true;
    }

@Override
public String toString() {
    if (!devoilee) {
        return "?";
    } else if (presenceBombe) {
        return "B";
    } else if (getNbBombesAdjacentes() > 0) {
        return String.valueOf(getNbBombesAdjacentes());
    } else {
        return " ";
    }
}
}
    
    
    

