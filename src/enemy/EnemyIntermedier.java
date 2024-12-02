package enemy;

import unite.Unite;

public class EnemyIntermedier extends Unite {


        public EnemyIntermedier(){
            super("Enemy Intermedier",TypeEnemy.ENEMYINTERMEDIER,120,40,25);
        }
        @Override
public String toString() {
    return String.format("%s [Type: %s, PV: %d, Attaque: %d, Défense: %d]",
            getNom(), getTypeEnemy(), getPv(), getAttaque(), getDefence());
}





}
