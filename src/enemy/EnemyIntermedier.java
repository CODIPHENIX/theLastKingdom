package enemy;

import unite.TypeUniteJ;
import unite.Unite;

public class EnemyIntermedier extends Unite {


        public EnemyIntermedier(){
            super("Enemy Intermedier",TypeEnemy.ENEMYINTERMEDIER,120,40,25);
        }
        @Override
        public String toString() {
            return null;
        }

        @Override
        public int degatCalcul( Unite attaquant) {
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

}
