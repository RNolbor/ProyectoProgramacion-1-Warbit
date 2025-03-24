/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package warbit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author ramon
 */
public class MenuPanel extends JPanel implements KeyListener {
    private Image titulo;
    private Timer parpadeoTimer;
    private boolean mostrarTexto = true;
    private boolean menuActivo = false;
    private int opcionSeleccionada = 0;
    private String[] opciones = {"JUGAR", "SALIR"};
    private CardLayout cardLayout;
    private JPanel panelPrincipal;

    public MenuPanel(CardLayout cardLayout, JPanel panelPrincipal) {
        panelPrincipal.requestFocusInWindow();

        this.cardLayout = cardLayout;
        this.panelPrincipal = panelPrincipal;
          
        setBackground(Color.BLACK);
        titulo = new ImageIcon(getClass().getResource("/imagenes/titulo.png")).getImage();

        parpadeoTimer = new Timer(500, e -> {
            mostrarTexto = !mostrarTexto;
            repaint();
        });
        parpadeoTimer.start();

        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(titulo, 150, 100, null);

        if (!menuActivo) {
            if (mostrarTexto) {
                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.BOLD, 25));
                g.drawString("( Presiona ESPACIO para continuar )", 225, 500);
            }
        } else {
            g.setFont(new Font("Arial", Font.BOLD, 30));
            for (int i = 0; i < opciones.length; i++) {
                g.setColor(i == opcionSeleccionada ? Color.WHITE : Color.GRAY);
                g.drawString(opciones[i], 350, 300 + (i * 50));
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!menuActivo && e.getKeyCode() == KeyEvent.VK_SPACE) {
            menuActivo = true;
            repaint();
        } else if (menuActivo) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                opcionSeleccionada = (opcionSeleccionada - 1 + opciones.length) % opciones.length;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                opcionSeleccionada = (opcionSeleccionada + 1) % opciones.length;
            } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                switch (opciones[opcionSeleccionada]) {
                    case "JUGAR" -> cardLayout.show(panelPrincipal, "Juego");
                    
                    case "SALIR" -> System.exit(0);
                }
            }
            repaint();
        }
    }


    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
