package application;


import enemy.EnemyBase;
import enemy.EnemyBoss;
import enemy.EnemyIntermedier;
import unite.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;


public class Jeu {
    int argent=1000;
    ArrayList<Unite> armee;
    ArrayList<Unite> ennemis;
    int tour;
    int score;


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
    public int getScore(){
        return argent;
    }
    public void setScore(int score){
        this.score=score;
    }

    
    public void demarrer() {
        int currentScore = 0;
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        boolean jeuEnCours = true;
        int choix ;
        Difficulter niveauDifficulte = Difficulter.NORMAL;
    
        System.out.println("Bienvenue dans 'THE LAST KINGDOM' !");
        System.out.println("Choisissez le niveau de difficulté :");
        System.out.println("1. FACILE\n2. NORMAL\n3. DIFFICILE");
    
        try {
            choix = Integer.parseInt(scanner.readLine());
            switch (choix) {
                case 1 -> niveauDifficulte = Difficulter.FACILE;
                case 2 -> niveauDifficulte = Difficulter.NORMAL;
                case 3 -> niveauDifficulte = Difficulter.DIFFICILE;
                default -> System.out.println("Niveau par défaut sélectionné : NORMAL.");
            }
        } catch (Exception e) {
            System.out.println("Entrée non valide, niveau par défaut : NORMAL.");
        }
    
        System.out.printf("Vous commencez avec %d Piece.%n", argent);
    
        
        while (jeuEnCours) {
            currentScore = meilleurScore(currentScore);
            score = 0;
            System.out.println("\n--- TOUR " + (tour + 1) + " ---");
            afficherArmee();
    
            genererEnnemis(tour, niveauDifficulte);
    
            System.out.println("\nQue voulez-vous faire ?");
            System.out.println("1. Acheter des unités\n2. Lancer une attaque\n3. Défendre\n4. Quitter le jeu");
    
            try {
                choix = Integer.parseInt(scanner.readLine());
                switch (choix) {
                    case 1 -> acheterUnites(scanner);
                    case 2 -> attaquer();
                    case 3 -> defendre();
                    case 4 -> {
                        System.out.println("Merci d'avoir joué !");
                        jeuEnCours = false;
                    }
                    default -> System.out.println("Choix non valide, veuillez réessayer.");
                }
            } catch (Exception e) {
                System.out.println("Entrée non valide, veuillez réessayer.");
            }
            int maxScore =meilleurScore(currentScore);
            System.out.printf("score de la partie: %d%n",score);
            System.out.printf("Meilleur Score Ever: %d%n",meilleurScore(currentScore));
            int currentTour = tour;

            tour++;
//            le jouer passe ou prochain tour que si il gagne;
            if(armee.isEmpty()){
                tour=currentTour;
            }

        }
        System.out.println("Fin de la partie.");
    }
    
    public void afficherArmee(){

            if (armee.isEmpty()){
                System.out.println("Vous n'avez aucune unite");
            }else{

                System.out.println("Vous avez "+ armee.size() + " Unite\n" );
                checkUniter(armee);

            }

        }

    public void checkUniter(ArrayList<Unite> armee) {
        int NumSoldat = 0;
        int NumArcher = 0;
        int NumCavalier = 0;

        for (Unite unite : armee) {
            if (unite instanceof Soldat) {
                NumSoldat++;
            } else if (unite instanceof Archer) {
                NumArcher++;
            } else if (unite instanceof Cavalier) {
                NumCavalier++;
            }
        }

        System.out.println("Nombre de Soldats : " + NumSoldat);
        System.out.println("Nombre d'Archers : " + NumArcher);
        System.out.println("Nombre de Cavaliers : " + NumCavalier);
    }
    public void genererEnnemis(int tour,Difficulter NiveauDifficulter){

        ennemis.clear();
        int numEnemy=0;

        switch (NiveauDifficulter) {
            case FACILE -> numEnemy = 2 + tour;
            case NORMAL-> numEnemy = 4 + tour;
            case DIFFICILE -> numEnemy = 6 + tour;
        };

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

        System.out.printf("Une vague de %d ennemis arrive...%n", numEnemy);
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
        if (argent < cout) {
            System.out.println("Vous n'avez pas assez de ressources pour acheter cette unité.");
            return null;
        }
        setArgent(argent - cout);
        return switch (choix) {
            case SOLDAT -> new Soldat();
            case ARCHER -> new Archer();
            case CAVALIER -> new Cavalier();
    };
    }
    public void acheterUnites(BufferedReader scanner){

        int type=0;
        do {
            menuAchatUniter();
            try {
                type = Integer.parseInt(scanner.readLine());

                switch (type){
                    case 1-> armee.add(acheteUniter(argent, TypeUniteJ.SOLDAT));

                    case 2-> armee.add(acheteUniter(argent, TypeUniteJ.ARCHER));

                    case 3-> armee.add(acheteUniter(argent, TypeUniteJ.CAVALIER));
                    case 4-> afficherArmee();

                    case 5-> attaquer();
                    case 6-> defendre();

                }

            } catch (Exception e) {
                System.out.println("choix non valide.");
            }
        }while (type!=5 && type!=6);
    }

    public void attaquer(){

        System.out.println("LA BATAILLE COMMENCE......");
        System.out.println("VOTRE ARMEE COMMENCE L'ATTAQUE...");

        do {
            ArrayList<Unite> armeeMort=new ArrayList<>();
            ArrayList<Unite> ennemisMort=new ArrayList<>();

            for (Unite unite : armee) {
                for (Unite enemy : ennemis) {

                    if (unite.getPv() > 0 && enemy.getPv() > 0) {
                            int degatSurEnemy = unite.degatCalculEnemy(unite);
                            enemy.degatRecu(degatSurEnemy);
                            int degatSurJouer = enemy.degatCalculJouer(enemy);
                            unite.degatRecu(degatSurJouer);

                        if (unite.isDeath(unite.getPv())) {
                            armeeMort.add(unite);
                            System.out.println(enemy.getNom() + " : " + FunMessage.UniteTuer());
                        }
                        if (enemy.isDeath(enemy.getPv())) {
                            ennemisMort.add(enemy);
                            System.out.println(unite.getNom() + " : " + FunMessage.enemyTuer());
                            argent+=50;
                        }
                    }

                }
            }
            calculScore(ennemisMort,armeeMort);
            armee.removeAll(armeeMort);
            ennemis.removeAll(ennemisMort);
        }while (!armee.isEmpty() && !ennemis.isEmpty());
        whoWon();

    }
    public void defendre(){

        System.out.println("LA BATAILLE COMMENCE......");
        System.out.println("L'ENEMIE ATTAQUE...");

        do {
            ArrayList<Unite> armeeMort=new ArrayList<>();
            ArrayList<Unite> ennemisMort=new ArrayList<>();

            for (Unite unite : armee) {
                for (Unite enemy : ennemis) {

                    if (unite.getPv() > 0 && enemy.getPv() > 0) {
                        int degatSurEnemy = unite.degatCalculEnemy(unite);
                        int DSE = (int) (degatSurEnemy * 0.85);
                        enemy.degatRecu(DSE);
                        int degatSurJouer = enemy.degatCalculJouer(enemy);
                        int DSJ = (int) (degatSurJouer * 0.75);
                        unite.degatRecu(DSJ);

                        if (unite.isDeath(unite.getPv())) {
                            armeeMort.add(unite);
                            System.out.println(enemy.getNom() + " : " + FunMessage.UniteTuer());
                        }
                        if (enemy.isDeath(enemy.getPv())) {
                            ennemisMort.add(enemy);
                            System.out.println(unite.getNom() + " : " + FunMessage.enemyTuer());
                            argent+=50;
                        }
                    }

                }
            }
            calculScore(ennemisMort,armeeMort);
            armee.removeAll(armeeMort);
            ennemis.removeAll(ennemisMort);
        }while (!armee.isEmpty() && !ennemis.isEmpty());
        whoWon();

    }

    public void whoWon(){
//        determine qui a garnier
        System.out.println("----------------------------------");
        if(ennemis.isEmpty() && armee.isEmpty()){
            System.out.println("🤝 Match nul ! Les deux armées sont tombées au combat.");


        }else if(ennemis.isEmpty()){
            System.out.println("----------VICTOIRE--------------");
            System.out.println(FunMessage.victoire());
            System.out.println("Il vous reste " + armee.size() + " unités.");
            argent+=50;
            System.out.printf("Piece: %d%n", argent);
        } else {
            System.out.println("----------GAME OVER--------------");
            System.out.println(FunMessage.defaite());
            System.out.printf("Piece: %d%n", argent);
        }
    }

    public void menuAchatUniter(){
        System.out.println("----------------------------------");
        System.out.println("Quel type Unite voulez vouz acheter?");
        System.out.println("1. SOLDAT - " + Soldat.getCoutAchet());
        System.out.println("2. ARCHER - " + Archer.getCoutAchet());
        System.out.println("3. CAVALIER - " + Cavalier.getCoutAchet());
        System.out.println("4.Afficher armee");
        System.out.println("5.Lancer l'attaque");
        System.out.println("6.se defendre");
//        System.out.println("5.retouner au menu principal");
        System.out.println("----------------------------------");
        System.out.println("Veillez choisir une option.");
        System.out.printf("ARGENT: %d%n", argent);
    }

    public void calculScore(ArrayList<Unite> ennemisMort,ArrayList<Unite> armeeMort){
        for(Unite EM : ennemisMort){
            if(EM instanceof EnemyBase){
                score+=150;
            }else if(EM instanceof EnemyIntermedier){
                score+=300;
            }else if(EM instanceof EnemyBoss){
                score+=500;
            }
        }
        for(Unite AM : armeeMort){
            if(AM instanceof Soldat){
               score= Math.max(score-90,0);
            }else if(AM instanceof Archer){
                score= Math.max(score-100,0);
            }else if(AM instanceof Cavalier){
                score= Math.max(score-125,0);
            }
        }
    }
    public int meilleurScore(int currentScore){
        return Math.max(score,currentScore);
    }


}
