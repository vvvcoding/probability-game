import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class StatsPanel extends JPanel {
    
    //Fields
    private long counter = 0;
    static final int SCREEN_WIDTH = 500;
    static final int SCREEN_HEIGHT = 500;
    JButton returnGame = new JButton("Return");
    JLabel statsLabel = new JLabel("All-Time Stats");

    //Constructor
    public StatsPanel(StatsFrame frame) {
        //Panel design
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.CYAN);
        this.setFocusable(true);
        this.setLayout(null);

        //Return Game button design
        returnGame.setBounds(410, 450, 80, 40);
        returnGame.setBackground(Color.YELLOW);
        returnGame.setForeground(Color.BLACK);
        returnGame.setFont(new Font("Arial", Font.BOLD, 20));
        returnGame.setBorder(BorderFactory.createRaisedBevelBorder());
        returnGame.setEnabled(true);
        returnGame.setFocusable(false);

        //Label design
        statsLabel.setBounds(150, 25, 200, 70);
        statsLabel.setFont(new Font("Arial", Font.BOLD, 30));
        statsLabel.setForeground(Color.BLACK);

        //Return Game mouse listener
        returnGame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Return game pressed");
                frame.dispose();
                GameFrame frame = new GameFrame();
            }
        });

        //Add button
        this.add(returnGame);
        
        //Add label
        this.add(statsLabel);

        printStats();
    }

    //Methods
    private void printStats() {
        long oldData = 0;
        long tempDivisor = 50000000;
        int statsWidth = 100;
        int statsHeight = 20;
        int secondIndex = 0;

        //Read current stats from file
        try {
            File myObj = new File("PersonalStats.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                oldData = Long.parseLong(data);
                long tempPrintValue = 100000000 / tempDivisor;
                if (counter < 10) {
                    JLabel tempLabel = new JLabel("1/" + tempPrintValue + ": " + oldData);
                    tempLabel.setFont(new Font("Arial", Font.PLAIN, 15));
                    tempLabel.setForeground(Color.BLACK);
                    tempLabel.setBounds(125, (110 + (secondIndex * 20)), statsWidth, statsHeight);
                    this.add(tempLabel);
                } else if (counter < 20) {
                    JLabel tempLabel = new JLabel("1/" + tempPrintValue + ": " + oldData);
                    tempLabel.setFont(new Font("Arial", Font.PLAIN, 15));
                    tempLabel.setForeground(Color.BLACK);
                    tempLabel.setBounds(325, (110 + (secondIndex * 20)), statsWidth, statsHeight);
                    this.add(tempLabel);
                } else if (counter < 25) {
                    JLabel tempLabel = new JLabel("1/" + tempPrintValue + ": " + oldData);
                    tempLabel.setFont(new Font("Arial", Font.PLAIN, 15));
                    tempLabel.setForeground(Color.BLACK);
                    tempLabel.setBounds(225, (310 + (secondIndex * 20)), statsWidth, statsHeight);
                    this.add(tempLabel);
                }
                tempDivisor = tempDivisor / 2;
                counter ++;
                secondIndex ++;
                if (counter == 10 || counter == 20) {
                    secondIndex = 0;
                }
            }
            counter = 0;
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
}
