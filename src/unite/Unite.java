package unite;

import application.Jeu;
import enemy.TypeEnemy;

public abstract class Unite {
        private String nom;
        private int pv;
        private int attaque;
        private int defence;
        private int coutAchat;

        Jeu jeu = new Jeu();

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
    public int degatCalculJouer( Unite attaquant) {
        int attaque = attaquant.getAttaque();
        int defense = this.getDefence();
        double multi;
        TypeEnemy target = attaquant.getTypeEnemy();
        switch (target){
            case ENEMYBASE -> multi = 1.5;
            case ENEMYINTERMEDIER -> multi = 2.0;
            case BOSS -> multi =3.0;
            default -> multi=1;
        }
        double degatBase = ((double) attaque /( 1 + ((double) defense /10))  * multi);
        return Math.max((int)Math.round(degatBase),0);
    }
    public int degatCalculEnemy( Unite attaquant) {
        int attaque = attaquant.getAttaque();
        int defense = this.getDefence();
        double multi;
        TypeUniteJ target = attaquant.getTypeUniteJ();
        switch (target){
            case SOLDAT -> multi = 1.5;
            case ARCHER -> multi = 2.0;
            case CAVALIER -> multi =3.0;
            default -> multi=1;
        }
        double degatBase = ((double) attaque /( 1 + ((double) defense /10))  * multi);
        return Math.max((int)Math.round(degatBase),0);
    }
        public boolean isDeath(int updatePv){
            return updatePv == 0;
        }
    public void degatRecu(int degat){
        int degatPV=this.getPv()-degat;
        this.setPv(Math.max(degatPV,0));
    }

}
