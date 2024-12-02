package enemy;

import unite.Unite;

public class EnemyBoss extends Unite {

    public EnemyBoss(){
        super("Enemy Base",TypeEnemy.BOSS,300,60,50);
    }
    @Override
    public String toString() {
        return String.format("%s [Type: %s, PV: %d, Attaque: %d, Défense: %d]",
                getNom(), getTypeEnemy(), getPv(), getAttaque(), getDefence());
    }
    

}
