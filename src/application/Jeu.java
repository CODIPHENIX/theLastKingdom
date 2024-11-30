package application;

import enemy.EnemyBase;
import enemy.EnemyBoss;
import enemy.EnemyIntermedier;
import unite.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.runtime.SwitchBootstraps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Jeu {
    int argent=200;
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
    public  Unite acheteUniter(int argent,TypeUniteJ choix ) {

        int cout = switch (choix) {
            case SOLDAT -> Soldat.getCoutAchet();
            case ARCHER -> Archer.getCoutAchet();
            case CAVALIER -> Cavalier.getCoutAchet();
        };
        if (argent >= cout) {
            int achatU = argent - cout;
            setArgent(achatU);
        } else {
            System.out.println("Vous n'avez pas assez de ressources pour acheter cette unité.");
            return null;
        }
        switch (choix) {
            case SOLDAT -> System.out.println("Vous avez bien acheté une unité SOLDAT.");
            case ARCHER -> System.out.println("Vous avez bien acheté une unité ARCHER.");
            case CAVALIER -> System.out.println("Vous avez bien acheté une unité CAVALIER.");
        }
        return switch (choix) {
            case SOLDAT -> new Soldat();
            case ARCHER -> new Archer();
            case CAVALIER -> new Cavalier();
        };



    }
    public void acheterUnites(BufferedReader scanner){

        int type=0;
        do {
            System.out.println("----------------------------------");
            System.out.println("Quel type Unite voulez vouz acheter?");
            System.out.println(STR."1.SOLDAT-\{Soldat.getCoutAchet()}\n2.ARCHER-\{Archer.getCoutAchet()}\n3.CAVALIER-\{Cavalier.getCoutAchet()}");
            System.out.println("4.retouner au menu principal");
            System.out.println("----------------------------------");
            System.out.println("Veillez choisir une option.");
            System.out.println(STR."ARGENT: \{argent}");
            try {
                type = Integer.parseInt(scanner.readLine());

                    switch (type){
                        case 1-> armee.add(acheteUniter(argent, TypeUniteJ.SOLDAT));

                        case 2-> armee.add(acheteUniter(argent, TypeUniteJ.ARCHER));

                        case 3-> armee.add(acheteUniter(argent, TypeUniteJ.CAVALIER));

                        case 4 -> {}
                    }

            } catch (Exception e) {
                System.out.println("choix non valide.");
            }
        }while (type!=4);
    }


}
