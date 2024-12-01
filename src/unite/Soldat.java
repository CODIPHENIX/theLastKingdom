package unite;

import enemy.TypeEnemy;

public class Soldat extends Unite{

    public Soldat(){
    super("Soldat",TypeUniteJ.SOLDAT,100,25,20);
    }
    public static int getCoutAchet(){
        return 50;
    }


    @Override
    public String toString() {
        return null;
    }



}
