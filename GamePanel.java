import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class GamePanel extends JPanel {
    
    //Fields
    private long numClicks = 0;
    private long [] numPerProbability = new long[25];
    private long [] oldNumPerProbability = new long[25];
    private int arrayIndex = 0;
    static final int SCREEN_WIDTH = 500;
    static final int SCREEN_HEIGHT = 500;
    JButton randomizeButton = new JButton("Randomize");
    JButton statsButton = new JButton("Stats");
    JButton resetStatsButton = new JButton("Reset Stats");
    JLabel iconDisplay;

    //Images
    ImageIcon stickmanImage = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\stickmanImage.png");
    ImageIcon humanImage = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\humanImage.png");
    ImageIcon hawkeyeImage = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\hawkeyeImage.png");
    ImageIcon robinImage = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\robin.png");
    ImageIcon captainAmericaImage = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\captainAmerica.png");
    ImageIcon batmanImage = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\batman.png");
    ImageIcon spidermanImage = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\spiderman.png");
    ImageIcon aangImage = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\aang.png");
    ImageIcon tanjiroImage = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\tanjiro.png");
    ImageIcon zoroImage = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\zoro.png");
    ImageIcon luffyImage = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\luffy.png");
    ImageIcon sasukeImage = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\sasuke.png");
    ImageIcon narutoImage = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\naruto.png");
    ImageIcon thanosImage = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\thanos.png");
    ImageIcon gokuImage = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\goku.png");
    ImageIcon saitamaImage = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\saitama.png");
    ImageIcon galactusImage = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\galactus.png");
    ImageIcon supermanImage = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\superman.png");
    ImageIcon flashImage = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\flash.png");
    ImageIcon drManhattanImage = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\drMahattan.png");
    ImageIcon patrickImage = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\patrick.png");
    ImageIcon spongebobImage = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\spongebob.png");
    ImageIcon ben10Image = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\ben10.png");
    ImageIcon tribunalImage = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\tribunal.png");
    ImageIcon aboveAllImage = new ImageIcon("C:\\Users\\Dell User\\Documents\\In-Class-Programs\\Games-In-Class\\Probability Game\\ImagesProbGame\\aboveAll.jpg");
    private ImageIcon [] imageArr = {stickmanImage, humanImage, hawkeyeImage, robinImage, captainAmericaImage, 
                                    batmanImage, spidermanImage, aangImage, tanjiroImage, zoroImage, luffyImage,
                                    sasukeImage, narutoImage, thanosImage, gokuImage, saitamaImage, galactusImage,
                                    supermanImage, flashImage, drManhattanImage, patrickImage, spongebobImage, 
                                    ben10Image, tribunalImage, aboveAllImage};

    //Constructor
    public GamePanel(GameFrame frame) {
        //Panel design
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.CYAN);
        this.setFocusable(true);
        this.setLayout(null);

        //Randomize button design
        randomizeButton.setBounds(150, 300, 200, 70);
        randomizeButton.setBackground(Color.YELLOW);
        randomizeButton.setForeground(Color.BLACK);
        randomizeButton.setFont(new Font("Arial", Font.BOLD, 20));
        randomizeButton.setBorder(BorderFactory.createRaisedBevelBorder());
        randomizeButton.setEnabled(true);
        randomizeButton.setFocusable(false);

        //Stats button design
        statsButton.setBounds(410, 450, 80, 40);
        statsButton.setBackground(Color.YELLOW);
        statsButton.setForeground(Color.BLACK);
        statsButton.setFont(new Font("Arial", Font.BOLD, 20));
        statsButton.setBorder(BorderFactory.createRaisedBevelBorder());
        statsButton.setEnabled(true);
        statsButton.setFocusable(false);

        //Reset Stats button design
        resetStatsButton.setBounds(10, 450, 120, 40);
        resetStatsButton.setBackground(Color.YELLOW);
        resetStatsButton.setForeground(Color.BLACK);
        resetStatsButton.setFont(new Font("Arial", Font.BOLD, 20));
        resetStatsButton.setBorder(BorderFactory.createRaisedBevelBorder());
        resetStatsButton.setEnabled(true);
        resetStatsButton.setFocusable(false);

        //Image design
        iconDisplay = new JLabel();
        iconDisplay.setIcon(stickmanImage);
        iconDisplay.setBounds(150, 50, 200, 200);
        iconDisplay.setVisible(false);
        this.add(iconDisplay);

        //Randomize button listener
        randomizeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse Clicked!");
                getPrize();
                displayImage();
            }
        });

        //Stats button listener
        statsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("stats clicked");
                frame.dispose();
                StatsFrame newStats = new StatsFrame();
            }
        });

        //Reset Stats button listener
        resetStatsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                resetStats();
                System.out.println("reset stats clicked");
            }
        });

        //Add buttons
        this.add(randomizeButton);
        this.add(statsButton);
        this.add(resetStatsButton);
    }

    //methods
    private long getRandomProbability() {
        Random rand = new Random();
        long randomLong = rand.nextLong(100000000) + 1;
        return randomLong;
    }

    private void displayImage() {
        Image image = imageArr[arrayIndex].getImage().getScaledInstance(iconDisplay.getWidth(), iconDisplay.getHeight(), Image.SCALE_SMOOTH);
        iconDisplay.setIcon(new ImageIcon(image));
        iconDisplay.setVisible(true);
    }

    private void getPrize() {
        long number = getRandomProbability();

        if (number <= 100000000 && number > 50000000) {
            System.out.println("You got a Stickman. 1/2 Chance!");
            numClicks ++;
            arrayIndex = 0;
            numPerProbability[arrayIndex] ++;
        } else if (number <= 50000000 && number > 25000000) {
            System.out.println("You got a Human. 1/4 Chance!");
            numClicks ++;
            arrayIndex = 1;
            numPerProbability[arrayIndex] ++;
        } else if (number <= 25000000 && number > 12500000) {
            System.out.println("You got Hawkeye. 1/8 Chance!");
            numClicks ++;
            arrayIndex = 2;
            numPerProbability[arrayIndex] ++;
        } else if (number <= 12500000 && number > 6250000) {
            System.out.println("You got Robin. 1/16 Chance!");
            numClicks ++;
            arrayIndex = 3;
            numPerProbability[arrayIndex] ++;
        } else if (number <= 6250000 && number > 3125000) {
            System.out.println("You got Captain America. 1/32 Chance!");
            numClicks ++;
            arrayIndex = 4;
            numPerProbability[arrayIndex] ++;
        } else if (number <= 3125000 && number > 1562500) {
            System.out.println("You got Batman. 1/64 Chance!");
            numClicks ++;
            arrayIndex = 5;
            numPerProbability[arrayIndex] ++;
        } else if (number <= 1562500 && number > 781250) {
            System.out.println("You got Spiderman. 1/128 Chance!");
            numClicks ++;
            arrayIndex = 6;
            numPerProbability[arrayIndex] ++;
        } else if (number <= 781250 && number > 390625) {
            System.out.println("You got Aang. 1/256 Chance!");
            numClicks ++;
            arrayIndex = 7;
            numPerProbability[arrayIndex] ++;
        } else if (number <= 390625 && number > 195312) {
            System.out.println("You got Tanjiro Kamado. 1/512 Chance!");
            numClicks ++;
            arrayIndex = 8;
            numPerProbability[arrayIndex] ++;
        } else if (number <= 195312 && number > 97656) {
            System.out.println("You got Zoro. 1/1024!");
            numClicks ++;
            arrayIndex = 9;
            numPerProbability[arrayIndex] ++;
        } else if (number <= 97656 && number > 48828) {
            System.out.println("You got Luffy. 1/2048!");
            numClicks ++;
            arrayIndex = 10;
            numPerProbability[arrayIndex] ++;
        } else if (number <= 48828 && number > 24414) {
            System.out.println("You got Sasuke. 1/4096 Chance!");
            numClicks ++;
            arrayIndex = 11;
            numPerProbability[arrayIndex] ++;
        } else if (number <= 24414 && number > 12207) {
            System.out.println("You got Naruto. 1/8192 Chance!");
            numClicks ++;
            arrayIndex = 12;
            numPerProbability[arrayIndex] ++;
        } else if (number <= 12207 && number > 6103) {
            System.out.println("You got Thanos. 1/16384 Chance!");
            numClicks ++;
            arrayIndex = 13;
            numPerProbability[arrayIndex] ++;
        } else if (number <= 6103 && number > 3051) {
            System.out.println("You got Goku. 1/32768 Chance!");
            numClicks ++;
            arrayIndex = 14;
            numPerProbability[arrayIndex] ++;
        } else if (number <= 3051 && number > 1525) {
            System.out.println("You got Saitama. 1/65536 Chance!");
            numClicks ++;
            arrayIndex = 15;
            numPerProbability[arrayIndex] ++;
        } else if (number <= 1525 && number > 762) {
            System.out.println("You got Galactus. 1/131072 Chance!");
            numClicks ++;
            arrayIndex = 16;
            numPerProbability[arrayIndex] ++;
        } else if (number <= 762 && number > 381) {
            System.out.println("You got Superman. 1/262144 Chance!");
            numClicks ++;
            arrayIndex = 17;
            numPerProbability[arrayIndex] ++;
        } else if (number <= 381 && number > 190) {
            System.out.println("You got Flash. 1/524288 Chance!");
            numClicks ++;
            arrayIndex = 18;
            numPerProbability[arrayIndex] ++;
        } else if (number <= 190 && number > 95) {
            System.out.println("You got Dr. Manhattan. 1/1048576 Chance!");
            numClicks ++;
            arrayIndex = 19;
            numPerProbability[arrayIndex] ++;
        } else if (number <= 95 && number > 47) {
            System.out.println("You got Patrick. 1/2097152 Chance!");
            numClicks ++;
            arrayIndex = 20;
            numPerProbability[arrayIndex] ++;
        } else if (number <= 47 && number > 23) {
            System.out.println("You got SpongeBob. 1/4194304 Chance!");
            numClicks ++;
            arrayIndex = 21;
            numPerProbability[arrayIndex] ++;
        } else if (number <= 23 && number > 11) {
            System.out.println("You got Ben 10. 1/8388608 Chance!");
            numClicks ++;
            arrayIndex = 22;
            numPerProbability[arrayIndex] ++;
        } else if (number <= 11 && number > 5) {
            System.out.println("You got The Living Tribunal. 1/16777216 Chance!");
            numClicks ++;
            arrayIndex = 23;
            numPerProbability[arrayIndex] ++;
        } else if (number <= 5 && number > 0) {
            System.out.println("You got a The One Above All. 1/33554432 Chance!");
            numClicks ++;
            arrayIndex = 24;
            numPerProbability[arrayIndex] ++;
        }
        System.out.println(number);
        saveStats();
    }

    private void saveStats() {
        long oldData = 0;
        int counter = 0;

        //Read current stats from file
        try {
            File myObj = new File("PersonalStats.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                oldData = Long.parseLong(data);
                if (counter != 25) {
                    oldNumPerProbability[counter] = oldData;
                } else {
                    numClicks += oldData;
                }
                counter ++;
            }
            counter = 0;
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

        //Add new stats to file
        try {
            FileWriter myWriter = new FileWriter("PersonalStats.txt");
            for (int i = 0; i < 25; i ++) {
                long newStat = oldNumPerProbability[i] + numPerProbability[i];
                myWriter.write(newStat + "\n");
            }
            myWriter.write(numClicks + "\n");
            Arrays.fill(numPerProbability, 0);
            numClicks = 0;
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void resetStats() {
        //Reset stats to 0
        try {
            FileWriter myWriter = new FileWriter("PersonalStats.txt");
            for (int i = 0; i < 26; i ++) {
                myWriter.write("0\n");
            }
            Arrays.fill(numPerProbability, 0);
            numClicks = 0;
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}