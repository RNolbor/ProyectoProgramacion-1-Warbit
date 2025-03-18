/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package warbit;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author ramon
 */

public class warbit {
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            JuegoFrame frame = new JuegoFrame();
            frame.setVisible(true);
        });
    }
}

class JuegoFrame extends JFrame {
    
    public JuegoFrame() {
        
        setTitle("Warbit");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new JuegoPanel());
    }
}


class JuegoPanel extends JPanel {
    
    public JuegoPanel() {
        
        setBackground(Color.BLACK); 
    }

    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        g.setColor(Color.WHITE);
        g.fillRect(50, 50, 50, 50); 
    }
}
