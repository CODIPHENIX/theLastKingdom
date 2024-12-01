package application;

import java.util.Random;

public class FunMessage {
    static Random random = new Random();
    public static String UniteTuer(){
        int aleatoire = random.nextInt(5);
       return switch (aleatoire){
            case 0-> "Un de vos soldats a fait une sieste éternelle… R.I.P.";
            case 1-> "Oh non! il a trébuché sur une flèche!";
            case 2-> "Unité perdue… Elle aurait dû esquiver!";
            case 3-> "C’était un brave… mais pas assez rapide.";
            case 4-> "Bon… au moins, il ne prendra plus de salaire!";
            default -> throw new IllegalStateException("Unexpected value: " + aleatoire);
        };
    }
    public static String defaite(){
        int aleatoire = random.nextInt(6);
       return switch (aleatoire){
            case 0-> "Votre armée a succombé… Mais on croit en votre retour!";
            case 1-> "Défaite aujourd’hui, mais victoire demain! On espère!";
            case 2-> "C’était une bataille, pas une promenade au parc!";
            case 3-> "Vos soldats ont donné leur vie… Peut-être pour rien, mais bon.";
            case 4-> "Défaite amère… Peut-être que la prochaine fois, utilisez un plan";
            case 5-> "Plus qu’un champ de bataille… c’est une piste de danse maintenant!";
            default -> throw new IllegalStateException("Unexpected value: " + aleatoire);
        };
    }
    public static String enemyTuer(){
        int aleatoire = random.nextInt(5);
       return switch (aleatoire){
            case 0-> "Bim! L’ennemi n’a rien vu venir!";
            case 1-> "Un ennemi éliminé! NEXT!";
            case 2-> "Un ennemi a appris à voler… sans ailes.";
            case 3-> "Un coup magistral! L’ennemi retourne chez maman!";
            case 4-> "BOOM! Ce méchant ne reviendra pas.";
           default -> throw new IllegalStateException("Unexpected value: " + aleatoire);
        };
    }
    public static String victoire(){
        int aleatoire = random.nextInt(6);
        return switch (aleatoire){
            case 0-> "Plus qu’un champ de bataille… c’est une piste de danse maintenant!";
            case 1-> "Facile! Vous êtes le boss des boss!";
            case 2-> "Mission accomplie, général! Que la gloire soit vôtre!";
            case 3-> "Votre nom sera chanté dans toutes les tavernes!";
            case 4-> "Vous avez écrasé vos ennemis comme des moustiques!";
            case 5-> "Victoire! Votre armée est invincible!";
            default -> throw new IllegalStateException("Unexpected value: " + aleatoire);
        };
    }

}
