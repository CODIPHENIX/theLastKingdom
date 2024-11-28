package unite;

import enemy.TypeEnemy;

public class Archer extends Unite{
    public Archer(String nom, int pv,int attaque,int defence,int coutAchat){
        super("Archer",TypeUniteJ.ARCHER,80,40,20,100);
    }
    public String toString() {
        return null;
    }
    @Override
    public int degatCalcul( Unite attaquant) {
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
}
