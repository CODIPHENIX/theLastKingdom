package main;

import javax.swing.*;
import java.awt.*;

public class GameSreen extends JPanel {

    public GameSreen(){}
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillRect(0,0,150,150);
    }
}
