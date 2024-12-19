import javax.swing.*;

public class StatsFrame extends JFrame {

    //Create stats frame
    JFrame StatsFrame = new JFrame();

    //Constructor
    public StatsFrame() {
        StatsPanel statsPanel = new StatsPanel(this);
        this.add(statsPanel);
        this.setTitle("Stats");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}