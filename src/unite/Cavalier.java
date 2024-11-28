package unite;

import enemy.TypeEnemy;

public class Cavalier extends Unite{
    public Cavalier(){
        super("Cavalier",TypeUniteJ.CAVALIER,400,50,40);
    }
    public static int getCoutAchet(){
        return 200;
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
