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
import java.util.ArrayList;
import java.util.Random;

/**
 import java.awt.event.ActionEvent;
im*
 * @author ramon
 */
public class JuegoPanelC extends JPanel implements KeyListener {
    private Image[] ataques;
    private Circulo jugador;
    private Jefe jefe;
    private boolean turnoJugador;
    private String mensaje;
    private boolean juegoTerminado;
    private Timer Cerrar;
    private static int victorias = 0;
    private JPanel panelPrincipal;
    private ArrayList<Point> ataquesEnCurso;
    private boolean ataqueFuerte;
    private Timer animacionAtaque;
    private Timer animacionAtaqueJefe;
    private Random random;
    private ArrayList<Point> ataquesJefe;

    public JuegoPanelC(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
        setBackground(Color.BLACK);
        
        ataques = new Image[]{
            new ImageIcon(getClass().getResource("/imagenes/A1Circulo.png")).getImage(),
            new ImageIcon(getClass().getResource("/imagenes/A2Circulo.png")).getImage(),
            new ImageIcon(getClass().getResource("/imagenes/A3Circulo.png")).getImage(),
            new ImageIcon(getClass().getResource("/imagenes/AFCirculo.png")).getImage()
        };

        jugador = new Circulo();
        jefe = new Jefe();
        turnoJugador = true;
        mensaje = "El jugador debe atacar";
        juegoTerminado = false;
        ataquesEnCurso = new ArrayList<>();
        ataquesJefe = new ArrayList<>();
        random = new Random();
        
        setFocusable(true);
        addKeyListener(this);
    }

    private void iniciarTurnoJefe() {
        mensaje = "El jefe atacará";
        repaint();
        Timer timer = new Timer(2000, e -> {
            if (!juegoTerminado) {
                int ataqueSeleccionado = random.nextInt(4);
                int daño = 0;
                switch (ataqueSeleccionado) {
                    case 0:
                        daño = jefe.getDañoAtaque1();
                        mensaje = "El jefe usa Ataque Básico 1";                     
                        break;
                    case 1:
                        daño = jefe.getDañoAtaque2();
                        mensaje = "El jefe usa Ataque Básico 2";                     
                        break;
                    case 2:
                        daño = jefe.getDañoAtaqueEspecial();
                        mensaje = "¡El jefe usa su Ataque Especial!";                  
                        break;
                    case 3:
                        mensaje = "El jefe perdió su turno";                       
                        break;
                }
                if (ataqueSeleccionado != 3) {
                    iniciarAnimacionAtaqueJefe(3);
                    jugador.setVida(jugador.getVida() - daño);
                    mensaje = "El jugador debe atacar";
                }
                
                verificarFinDelJuego();
                turnoJugador = true;
                repaint();
            }
            ((Timer) e.getSource()).stop();
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void verificarFinDelJuego() {
        if (jugador.getVida() <= 0) {
            juegoTerminado = true;
            mensaje = "HAS MUERTO";
            repaint();
            iniciarCuentaRegresiva();
        } else if (jefe.getVida() <= 0) {
            juegoTerminado = true;
            mensaje = "¡HAS GANADO!";
            victorias++;
            repaint();
            iniciarCuentaRegresiva();
        }
    }

    private void iniciarCuentaRegresiva() {
        if (jugador.getVida() == 0){
            mensaje = "HAS MUERTO";
            repaint();
        } else if (jefe.getVida() == 0){
            mensaje = "HAS GANADO";
            repaint();
        }
        Cerrar = new Timer(2000, e -> {
            System.exit(0);
        });
        Cerrar.setRepeats(false);
        Cerrar.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        requestFocus();
        
        if (!juegoTerminado) {
            g.setColor(Color.WHITE);
            g.fillOval(100, 275, 100, 100);
            g.fillOval(750, 200, 250, 250);

            g.drawImage(ataques[0], 50, 500, 70, 70, null);
            g.drawImage(ataques[1], 150, 500, 70, 70, null);
            g.drawImage(ataques[2], 250, 500, 70, 70, null);
            g.drawImage(ataques[3], 350, 500, 100, 100, null);
            
            g.setColor(Color.WHITE);
            g.drawString("PLAYER: " + jugador.getVida(), 120, 70);
            g.drawString("JEFE: " + jefe.getVida(), 620, 70);
        }

        g.setColor(Color.WHITE);
        for (Point ataque : ataquesEnCurso) {
            g.fillOval(ataque.x, ataque.y, ataqueFuerte ? 40 : 20, ataqueFuerte ? 40 : 20);
        }

        for (Point ataque : ataquesJefe) {
            g.fillOval(ataque.x, ataque.y, 30, 30);
        }

        g.setColor(Color.WHITE);
        g.drawString(mensaje, 350, 450);
    }

    private void iniciarAnimacionAtaqueJefe(int cantidad) {
        ataquesJefe.clear();
        for (int i = 0; i < cantidad; i++) {
            ataquesJefe.add(new Point(800, 300 + (i * 20)));
        }

        animacionAtaqueJefe = new Timer(50, e -> {
            for (Point ataque : ataquesJefe) {
                ataque.x -= 20;
            }
            if (!ataquesJefe.isEmpty() && ataquesJefe.get(0).x <= 150) {
                ataquesJefe.clear();
                animacionAtaqueJefe.stop();
            }
            repaint();
        });
        animacionAtaqueJefe.start();
    }
    
    private void iniciarAnimacionAtaque(int cantidad, boolean fuerte) {
        ataquesEnCurso.clear();
        ataqueFuerte = fuerte;
        for (int i = 0; i < cantidad; i++) {
            ataquesEnCurso.add(new Point(150, 300 + (i * 20)));
        }

        animacionAtaque = new Timer(50, e -> {
            for (Point ataque : ataquesEnCurso) {
                ataque.x += 20;
            }
            if (!ataquesEnCurso.isEmpty() && ataquesEnCurso.get(0).x >= 750) {
                ataquesEnCurso.clear();
                animacionAtaque.stop();
                int daño = fuerte ? jugador.getDañoAtaque1() * 8 : jugador.getDañoAtaque1() * cantidad;
                jefe.setVida(jefe.getVida() - daño);
                verificarFinDelJuego();
                turnoJugador = false;
                iniciarTurnoJefe();
            }
            repaint();
        });
        animacionAtaque.start();
    }
    @Override 
    public void keyPressed(KeyEvent e) {
        if (turnoJugador && !juegoTerminado) {
            if (e.getKeyCode() == KeyEvent.VK_1) {
                iniciarAnimacionAtaque(1, false);
            } else if (e.getKeyCode() == KeyEvent.VK_2) {
                iniciarAnimacionAtaque(2, false);
            } else if (e.getKeyCode() == KeyEvent.VK_3) {
                iniciarAnimacionAtaque(3, false);
            } else if (e.getKeyCode() == KeyEvent.VK_4) {
                iniciarAnimacionAtaque(1, true);
            }
        }
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}