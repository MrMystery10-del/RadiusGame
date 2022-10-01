import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import bfw.gui.draw.Label;
import bfw.gui.draw.LabelType;

// Gui
public class Gui extends JPanel{

    Label label = new Label();
    
    // Draw Method
    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D)g;

        g2d.setFont(new Font("Arial", Font.BOLD, 55));

        drawBase(g2d);

        if (Game.started == true){
            
            if (Game.over != true){

                if (Game.level != 5){
                    drawAction(g2d);
                } else {
                    drawHackAction(g2d);
                }

            } else {

            drawEnd(g2d);

            }

        }

        g2d.dispose();

    }

    // Base draw
    public void drawBase(Graphics g2d){

        int x;

        if (Game.level != 5){
        g2d.setColor(Color.GRAY);
        g2d.fillRect(0, 0, 800, 600);

        for(x = 0; x < 800; x += 100){
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(x, 0, 50, 600);
        }

        if (Game.started == false){
            g2d.setColor(Color.YELLOW);
            label.button(g2d, LabelType.Rounded_BOTH, 100, 100, 600, 300);
        }
        // Draw Label on start
        if (Game.started == true && Game.over != true){

        label.button(g2d, LabelType.Mark_OUT, 100, 10, 300, 200, Color.ORANGE, Color.RED);
        label.button(g2d, LabelType.Mark_IN, 450, 10, 300, 300, Color.CYAN, Color.GREEN);

        }
    } else {
        g2d.setColor(Color.decode("#8a4913"));
        g2d.fillRect(0, 0, 800, 600);

        for(x = 0; x < 800; x += 100){
        g2d.setColor(Color.decode("#9e5a23"));
        g2d.fillRect(x, 0, 50, 600);
        }

        // Draw Label HACK
        if (Game.started == true && Game.over != true){

        label.button(g2d, LabelType.Mark_OUT, 100, 10, 300, 200, Color.decode("#961b96"), Color.decode("#520b52"));
        label.button(g2d, LabelType.Mark_IN, 450, 10, 300, 300, Color.decode("#214a96"), Color.decode("#291266"));

        }
    }
     
    }

    // Action draw
    public void drawAction(Graphics g2d){

        drawScores(g2d);
        drawLive(g2d);
    
    }

    // Draw Score + Level
    public void drawScores(Graphics g2d){

    g2d.setColor(Color.BLACK);
    
    g2d.drawString("Level", 170, 80);

    g2d.drawString("Score", 520, 80);

    g2d.setFont(new Font("Arial", Font.BOLD, 80));

    switch (Game.level) {
        case 1:
        g2d.setColor(Color.decode("#2eb82e"));
        g2d.drawString("Easy", 155, 180);
            break;
    
        case 2:
        g2d.setFont(new Font("Arial", Font.BOLD, 60));
        g2d.setColor(Color.decode("#ff8533"));
        g2d.drawString("Medium", 135, 180);
            break;

        case 3:
        g2d.setFont(new Font("Arial", Font.BOLD, 80));
        g2d.setColor(Color.decode("#24248f"));
        g2d.drawString("Hard", 155, 180);
            break;
        
        case 4:
        g2d.setFont(new Font("Arial", Font.BOLD, 45));
        g2d.setColor(Color.decode("#800080"));
        g2d.drawString("Impossible", 133, 180);
            break;

        case 5:
        g2d.setFont(new Font("Arial", Font.BOLD, 80));
        g2d.setColor(Color.decode("#3f138a"));
        g2d.drawString("HACK", 133, 180);
            break;
    }
    
    g2d.setFont(new Font("Arial", Font.BOLD, 90));
    g2d.setColor(Color.BLACK);

    if (Game.score >= 100){

    g2d.drawString(""+Game.score, 524, 180);

    } 
    else if (Game.score >= 10){

    g2d.drawString(""+Game.score, 554, 180);

    } else {

    g2d.drawString(""+Game.score, 580, 180);

    }

    }

    // draw Lives 
    public void drawLive(Graphics g2d){

        g2d.setColor(Color.decode("#ccffff"));
        label.button(g2d, LabelType.Rounded_LEFT, 350, 445, 400, 150);
        g2d.fillRect(600, 445, 200, 150);

        g2d.setColor(Color.CYAN);

        switch (Game.live) {
            case 5:
            g2d.fillRect(600, 500, 30, 30);
            g2d.fillRect(550, 500, 30, 30);
            g2d.fillRect(500, 500, 30, 30);
            g2d.fillRect(450, 500, 30, 30);
            g2d.fillRect(400, 500, 30, 30);
                break;
        
            case 4:
            g2d.fillRect(600, 500, 30, 30);
            g2d.fillRect(550, 500, 30, 30);
            g2d.fillRect(500, 500, 30, 30);
            g2d.fillRect(450, 500, 30, 30);
                break;
            
            case 3:
            g2d.fillRect(600, 500, 30, 30);
            g2d.fillRect(550, 500, 30, 30);
            g2d.fillRect(500, 500, 30, 30);
                break;
            
            case 2:
            g2d.fillRect(600, 500, 30, 30);
            g2d.fillRect(550, 500, 30, 30);
                break;

            case 1:
            g2d.fillRect(600, 500, 30, 30);
                break;
        }

        g2d.setColor(Color.BLUE);
        g2d.drawRect(399, 499, 231, 31);
        g2d.drawRect(398, 498, 233, 33);
        g2d.drawRect(397, 497, 235, 35);

        g2d.setFont(new Font("Arial", Font.BOLD, 50));
        g2d.drawString("Lives:", 360, 490);
        
    }

    // End draw
    public void drawEnd(Graphics g2d){

        // Calculation of radius, Oberflaeche (idk the english word for it lol), Volume
        double s = Game.score;
        double radius = s / 10;
            
        double A = Math.ceil(4 * (radius*radius) * Math.PI * 10) / 10;
        double V = Math.ceil((4.0/3.0) * Math.pow(radius, 3) * Math.PI * 10) / 10;

        drawEndAnimation(g2d, radius, A, V);
    }

    // End Aniamtion draw
    public void drawEndAnimation(Graphics g2d, double radius, double A, double V){

        g2d.setFont(new Font("Arial", Font.BOLD, 110));

        if (Game.overTimer > 0){
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 800, 600);
        }
        
        g2d.setColor(Color.RED);
        if (Game.overTimer < 150){
        g2d.drawString("Sc", Game.overTimer, 200);
        }

        if (Game.overTimer >= 150 && Game.overTimer < 300){
            g2d.drawString("Sc", 150, 200);
            g2d.drawString("ore", 280, (int) (Game.overTimer / 1.5));
        }

        if (Game.overTimer >= 300 && Game.overTimer < 1100){
            g2d.drawString("Sc", 150, 200);
            g2d.drawString("ore", 280, 200);

            g2d.setFont(new Font("Arial", Font.BOLD, Game.overTimer / 10));
            g2d.drawString(""+Game.score, 280, 300);
        }

        if (Game.overTimer >= 1100 && Game.overTimer < 1600){
            g2d.drawString("Sc", 150, 200);
            g2d.drawString("ore", 280, 200);

            g2d.setColor(Color.ORANGE);
            g2d.drawString(""+Game.score, 280 + (Game.overTimer - 1100) / 2, 300);

            g2d.setColor(Color.GREEN);
            g2d.fillRect(0, 210, 450, 5);
            g2d.fillRect(270, 310, 450, 5);

        }

        if (Game.overTimer >= 1600 && Game.overTimer < 1700){
            g2d.drawString("Sc", 150, 200);
            g2d.drawString("ore", 280, 200);

            g2d.setColor(Color.ORANGE);
            g2d.drawString(""+Game.score, 530, 300 + (Game.overTimer - 1600) * -1);

            g2d.setColor(Color.GREEN);
            g2d.fillRect(0, 210, 450, 5);
            g2d.fillRect(270, 310, 450, 5);
        }

        if (Game.overTimer >= 1700 && Game.overTimer < 1800){
            g2d.setColor(Color.ORANGE);
            g2d.drawString("Ra", 150, 200);
            g2d.setColor(Color.RED);
            g2d.drawString("ore", 280, 200);

            g2d.setColor(Color.ORANGE);
            g2d.drawString(""+Game.score, 530, 200);

            g2d.setColor(Color.GREEN);
            g2d.fillRect(0, 210, 450, 5);
            g2d.fillRect(270, 310, 450, 5);
        }

        if (Game.overTimer >= 1800 && Game.overTimer < 1900){
            g2d.setColor(Color.ORANGE);
            g2d.drawString("Ra", 140, 200);
            g2d.drawString("dius:", 270, 200);

            g2d.drawString(""+radius, 530, 200);

            g2d.setColor(Color.GREEN);
            g2d.fillRect(0, 210, 450, 5);
            g2d.fillRect(270, 310, 450, 5);
        }

        if (Game.overTimer >= 1900 && Game.overTimer < 2000){
            g2d.setColor(Color.ORANGE);
            g2d.drawString("Ra", 140, 200);
            g2d.drawString("dius:", 270, 200);

            g2d.drawString(""+radius, 530, 200);

            g2d.setColor(Color.GREEN);
            g2d.fillRect(0, 210, 450, 5);
            g2d.fillRect(270, 310, 450, 5);
        }

        if (Game.overTimer >= 2000 && Game.overTimer < 2720){
            g2d.setColor(Color.ORANGE);
            g2d.fillArc(150, 80, 450, 450, 0, (Game.overTimer - 2000) / 2);
        }

        if (Game.overTimer >= 2720){
            g2d.setColor(Color.ORANGE);
            g2d.fillArc(150, 80, 450, 450, 0, 360);

            g2d.setColor(Color.BLACK);
            g2d.drawString("A", 335, 180);
            g2d.drawString("V", 335, 380);

            g2d.setFont(new Font("Arial", Font.BOLD, 90));
            g2d.drawString(""+A, 250, 250);
            g2d.drawString(""+V, 250, 450);

            g2d.setColor(Color.RED);
            g2d.fillRect(550, 50, 200, 100);
        }
    }

    public void drawHackAction(Graphics g2d){

        drawScores(g2d);
        drawHackLive(g2d);
    }

    public void drawHackLive(Graphics g2d){
        g2d.setColor(Color.decode("#cc6275"));
        label.button(g2d, LabelType.Rounded_LEFT, 350, 445, 400, 150);
        g2d.fillRect(600, 445, 200, 150);

        g2d.setColor(Color.decode("#9c1c71"));

        switch (Game.live) {
            case 5:
            g2d.fillRect(600, 500, 30, 30);
            g2d.fillRect(550, 500, 30, 30);
            g2d.fillRect(500, 500, 30, 30);
            g2d.fillRect(450, 500, 30, 30);
            g2d.fillRect(400, 500, 30, 30);
                break;
        
            case 4:
            g2d.fillRect(600, 500, 30, 30);
            g2d.fillRect(550, 500, 30, 30);
            g2d.fillRect(500, 500, 30, 30);
            g2d.fillRect(450, 500, 30, 30);
                break;
            
            case 3:
            g2d.fillRect(600, 500, 30, 30);
            g2d.fillRect(550, 500, 30, 30);
            g2d.fillRect(500, 500, 30, 30);
                break;
            
            case 2:
            g2d.fillRect(600, 500, 30, 30);
            g2d.fillRect(550, 500, 30, 30);
                break;

            case 1:
            g2d.fillRect(600, 500, 30, 30);
                break;
        }

        g2d.setColor(Color.decode("#661222"));
        g2d.drawRect(399, 499, 231, 31);
        g2d.drawRect(398, 498, 233, 33);
        g2d.drawRect(397, 497, 235, 35);

        g2d.setFont(new Font("Arial", Font.BOLD, 55));
        g2d.drawString("Lives:", 360, 490);
        
    }
}
