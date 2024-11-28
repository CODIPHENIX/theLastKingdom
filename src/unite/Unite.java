package unite;

import application.Jeu;
import enemy.TypeEnemy;

public abstract class Unite {
     private String nom;
     private int pv;
     private int attaque;
     private int defence;
     private int coutAchat;

     private TypeUniteJ typeUniteJ;
     private TypeEnemy typeEnemy;
     public Unite(){}
    public Unite(String nom,TypeEnemy typeEnemy,int pv,int attaque,int defence){
          this.nom = nom;
          this.pv = pv;
          this.attaque = attaque;
          this.defence = defence;
          this.typeEnemy = typeEnemy;
    }
    public Unite(TypeUniteJ typeUniteJ){
        this.typeUniteJ = typeUniteJ;
    }
     public Unite( String nom,TypeUniteJ typeUniteJ, int pv,int attaque,int defence){
          this.nom = nom;
          this.pv = pv;
          this.attaque = attaque;
          this.defence = defence;
         this.typeUniteJ = typeUniteJ;
     }

     public String getNom(){return nom;}
     public void setNom(String nom){this.nom = nom;}
     public int getPv(){return pv;}
     public void setPv(int pv){this.pv = Math.max(pv,0);}
     public int getAttaque(){return attaque;}
     public void setAttaque(int attaque){this.attaque = attaque;}
     public int getDefence(){return defence;}
     public void setDefence(int defence){this.defence = defence;}
     public int getCoutAchat(){return coutAchat;}
     public void setCoutAchat(int coutAchat){this.coutAchat = coutAchat;}
     public TypeEnemy getTypeEnemy(){return typeEnemy;}
     public TypeUniteJ getTypeUniteJ(){return typeUniteJ;}


     public abstract String toString();
     public abstract int degatCalcul(Unite unite);
     public boolean isDeath(int updatePv){
         return updatePv == 0;
     }
    public void degatRecu(int degat){
        int degatPV=this.getPv()-degat;
        this.setPv(Math.max(degatPV,0));
    }
    public Unite acheteUniter(int argent,TypeUniteJ choix,Jeu jeu ) {

        int cout = switch (choix) {
            case SOLDAT -> Soldat.getCoutAchet();
            case ARCHER -> Archer.getCoutAchet();
            case CAVALIER -> Cavalier.getCoutAchet();
        };
        if (argent >= cout) {
            int achetU = argent - this.coutAchat;
            jeu.setArgent(achetU);
        } else {
            System.out.println("Vous n'avez pas assez de ressources pour acheter cette unité.");
            return null;
        }

        return switch (choix) {
            case SOLDAT -> new Soldat();
            case ARCHER -> new Archer();
            case CAVALIER -> new Cavalier();
        };

    }
}
