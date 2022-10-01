import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame extends JFrame {

    public static boolean paint = false;

    // Componente
    JButton[] fastButton = new JButton[10];

    JButton startButton = button();

    JButton resetButton = resetButton();

    SoundLoader soundLoader = new SoundLoader();

    Game game = new Game();

    Gui gui = new Gui();

    // Thread (Game.java)
    Thread thread = new Thread();

    // Start
    public void setUp() {

        int x = 0;

        addComp(x);
        frameStats();

        // Cube move + repaint on action
        while(true)
        for (x = 0; x < fastButton.length; x++){
            fastButton[x].setLocation(Game.coordsX[x], Game.coordsY[x]);
            if (paint == true){
                gui.repaint();
                paint = false;
            }
            if (Game.over == true){
                gui.repaint();
            }

            if(Game.overTimer > 2720){
                this.add(resetButton);
                frameStats();
            } else {
                this.remove(resetButton);
            }

        }

    }

    // Frame Settings
    public void frameStats() {

        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Kreis Game");

        this.setVisible(true);
    }

    // Add Componente
    public void addComp(int x) {

        for (x = 0; x < fastButton.length; x++){

        fastButton[x] = fastButton(x);
        this.add(fastButton[x]);
        }

        this.add(startButton);
        this.add(gui);
    }

    // Start Button
    public JButton button() {

        JButton button = new JButton("Start Game");

        button.setBounds(100, 100, 600, 300);
        button.setFont(new Font("Arial", Font.BOLD, 90));
        button.setBackground(Color.YELLOW);
        button.setForeground(Color.GREEN);
        button.setFocusPainted(false);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                gui.repaint();

                button.setBounds(1000, 1000, 1, 1);

                soundLoader.playBackground();

                game.start();

            }
        });

        return button;
    }

    // Moving Buttons
    public JButton fastButton(int x) {

        JButton button = new JButton();
        
        button.setText("1");
        button.setSize(50 ,50);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.GREEN);
        button.setFocusPainted(false);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                if (Game.started == true){

                gui.repaint();

                soundLoader.playClick();

            // Health System
            if (button.getText() == "5"){
                button.setText("4");
            } else if (button.getText() == "4"){
                button.setText("3");
            } else if (button.getText() == "3"){
                button.setText("2");
            } else if (button.getText() == "2"){
                button.setText("1");
            } else if (button.getText() == "1"){
                Game.moveBack[x] = true;
                Game.coordsY[x] = (int) (Math.random() * 500 + 1);
                Game.score ++;

                if (Game.level == 3){
                    button.setText("2");
                } else if (Game.level == 4){
                    button.setText("3");
                } else if (Game.level == 5){
                    button.setText("5");
                }
            }

                }
    

            }
        });

        return button;
    }

    public JButton resetButton() {

        JButton button = new JButton("Reset Game");

        button.setBounds(550, 50, 200, 100);
        button.setFont(new Font("Arial", Font.BOLD, 50));
        button.setBackground(Color.RED);
        button.setForeground(Color.GREEN);
        button.setFocusPainted(false);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                Game.timer = 0;
                Game.level = 1;
                Game.score = 0;
                Game.live = 5;
                Game.over = false;
                Game.overTimer = 0;

                gui.repaint();

            }
        });

        return button;
    }

}