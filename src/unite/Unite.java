package unite;

abstract class Unite {
     private String nom;
     private int pv;
     private int attaque;
     private int defence;
     private int coutAchat;
     public Unite(){}
    public Unite(int pv,int attaque,int defence){
          this.pv = pv;
          this.attaque = attaque;
          this.defence = defence;
    }
     public Unite( String nom,int pv,int attaque,int defence,int coutAchat){
          this.nom = nom;
          this.pv = pv;
          this.attaque = attaque;
          this.defence = defence;
          this.coutAchat = coutAchat;
     }

     public String getNom(){return nom;}
     public void setNom(String nom){this.nom = nom;}
     public int getPv(){return pv;}
     public void setPv(int pv){this.pv = pv;}
     public int getAttaque(){return attaque;}
     public void setAttaque(int attaque){this.attaque = attaque;}
     public int getDefence(){return defence;}
     public void setDefence(int defence){this.defence = defence;}
     public int getCoutAchat(){return coutAchat;}
     public void setCoutAchat(int coutAchat){this.coutAchat = coutAchat;}

     public abstract String toString();
}
