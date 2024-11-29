package application;

import enemy.EnemyBase;
import enemy.EnemyBoss;
import enemy.EnemyIntermedier;
import unite.Archer;
import unite.Cavalier;
import unite.Soldat;
import unite.Unite;

import java.lang.runtime.SwitchBootstraps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Jeu {
    int argent;
    ArrayList<Unite> armee;
    ArrayList<Unite> ennemis;

    int tour;

    public Jeu(){
        armee = new ArrayList<>();
        ennemis = new ArrayList<>();
    }


    public int getArgent(){
        return argent;
    }
    public void setArgent(int argent){
        this.argent=argent;
    }

    public void demarrer(){}

    public void afficherArmee(){

            if (armee.isEmpty()){
                System.out.println("Vous n'avez aucune unite");
            }
            int NumSoldat =0;
            int NumArcher =0;
            int NumCavalier =0;

            for(Unite unite : armee){
                if(unite instanceof Soldat){
                    NumSoldat++;
                }
                else if(unite instanceof Archer){
                    NumArcher++;
                }
               else if(unite instanceof Cavalier){
                    NumCavalier++;
                }
            }

            System.out.println("Vous avez "+ armee.size() + " Unite\n" +
                    "------------------------\n" +
                    "SOLDAT" +" "+ NumSoldat+"\n" +
                    "ARCHER" +" "+ NumArcher+"\n"+
                    "CAVALIER" +" "+ NumCavalier+"\n" +
                    "------------------------\n" );

        }
    public void genererEnnemis(int tour){

        ennemis.clear();
        int numEnemy = 3 + tour;
        Random random = new Random();
        int type;

        int numBoss = Math.min(1+(tour/5),numEnemy);

        for(int i=0; i < numEnemy-numBoss; i++){
           type = random.nextInt(2);
            switch (type){
                case 0->ennemis.add(new EnemyBase());
                case 1->ennemis.add(new EnemyIntermedier());
            }
        }
        for(int i=0;i<numBoss;i++){
            ennemis.add(new EnemyBoss());
        }

        System.out.println(STR."Une vague de \{numEnemy} d'ennemie arrive.....");
/*       int NumSoldat=0;
        int NumArcher=0;
        int NumCavalier=0;
        for(Unite unite : ennemis){
            if(unite instanceof EnemyBase){
                NumSoldat++;
            }
            else if(unite instanceof EnemyIntermedier){
                NumArcher++;
            }
            else if(unite instanceof EnemyBoss){
                NumCavalier++;
            }
        }

        System.out.println("Vous avez "+ ennemis.size() + " enemy\n" +
                "------------------------\n" +
                "base" +" "+ NumSoldat+"\n" +
                "inter" +" "+ NumArcher+"\n"+
                "boss" +" "+ NumCavalier+"\n" +
                "------------------------\n" );*/
    }

}
