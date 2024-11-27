package main;

import javax.swing.*;

public class Jeu extends JFrame {

    public Jeu(){
        setTitle("THE Last Kingdom");
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        GameSreen gameSreen = new GameSreen();
        add(gameSreen);

    }
}
