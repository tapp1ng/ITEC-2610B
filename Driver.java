import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Driver extends JFrame implements MouseListener {
    {
    
    //creating the jframe 
    JFrame frame = new JFrame("Game Name");  

    //panel creation
    JPanel panel = new JPanel();  
    panel.setLayout(new FlowLayout());  
    JLabel label = new JLabel("Welcome to Game Name");  
    JButton button = new JButton("Next Stage");
    JButton button2 = new JButton("Shop");    
    
    //adding the jframe components to the panel
    panel.add(label);  
    panel.add(button);
    panel.add(button2);  
    frame.add(panel);  

    //defining the frame size and default commands
    frame.setSize(200, 300);  
    frame.setLocationRelativeTo(null);  
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    frame.setVisible(true);  
    }

        @Override
       public void mousePressed (MouseEvent e) {
            e.getX() + e.getY();
       }

       @Override
       public void mouseReleased (MouseEvent e) {

       }

       @Override
       public void mouseEntered (MouseEvent e) {
        
       }
       
       @Override
       public void mouseExited (MouseEvent e) {

       }

       @Override
       public void mouseClicked (MouseEvent e) {

       




        

    }
    public static void main (String arg []) {
        new Driver();
    }
}