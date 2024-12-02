package enemy;

import unite.Unite;

public class EnemyBase extends Unite {
    public EnemyBase(){
        super("Enemy Base",TypeEnemy.ENEMYBASE,60,20,15);
    }
    @Override
public String toString() {
    return String.format("%s [Type: %s, PV: %d, Attaque: %d, Défense: %d]",
            getNom(), getTypeEnemy(), getPv(), getAttaque(), getDefence());
}



}
