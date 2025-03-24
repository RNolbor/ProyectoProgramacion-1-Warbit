package warbit;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.awt.*;
import javax.swing.*;

public class Warbit extends JFrame {
    private CardLayout cardLayout;
    private JPanel panelPrincipal;
    private MenuPanel menuPanel;
    private JuegoPanelC juegoPanelC;

    public Warbit() {
        setTitle("War-Bit");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);
        
        menuPanel = new MenuPanel(cardLayout, panelPrincipal);
        juegoPanelC = new JuegoPanelC(panelPrincipal);
        
        panelPrincipal.add(menuPanel, "Menu");
        panelPrincipal.add(juegoPanelC, "Juego");
        
        add(panelPrincipal);
    
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Warbit warbit = new Warbit();
            warbit.setVisible(true);
        });
    }
}
