import javax.swing.JFrame;

public class GameFrame extends JFrame {
    
    //constructor
    public GameFrame() {
        GamePanel gamePanel = new GamePanel(this);
        this.add(gamePanel);
        this.setTitle("Probability Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
