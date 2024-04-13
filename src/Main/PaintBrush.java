import javax.swing.JFrame;
import paintbrush.DrawPanel;

public static void main(String[] args) {
        
            
    JFrame frame = new JFrame("Paint Brush ");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);

    DrawPanel drawPanel = new DrawPanel(); 
    frame.setContentPane(drawPanel); 
    frame.setVisible(true);
}