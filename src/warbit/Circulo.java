/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package warbit;

import java.util.Random;

/**
 *
 * @author ramon
 */
public class Circulo {
    private int vida;
    private int nivel;
    private String estado_ataque1;
    private String estado_ataque2;
    private String estado_ataque3;
    private String estado_ataqueFuerte;
    private int daño_ataque1;
    private int daño_ataque2;
    private int daño_ataque3;
    private int daño_ataqueFuerte;
    private int dañoAtaqueFatality;
    private int cooldownA1;
    private int cooldownA2;
    private int cooldownA3;
    private Random random;

    public Circulo() {
        this.vida = 200;
        this.nivel = 1;
        this.estado_ataque1 = "DESBLOQUEADO";
        this.estado_ataque2 = "BLOQUEADO";
        this.estado_ataque3 = "BLOQUEADO";
        this.estado_ataqueFuerte = "BLOQUEADO";
        this.daño_ataque1 = 20;
        this.daño_ataque2 = 30;
        this.daño_ataque3 = 45;
        this.daño_ataqueFuerte = 120;
        this.dañoAtaqueFatality = 30;
        this.cooldownA1 = 1;
        this.cooldownA2 = 3;
        this.cooldownA3 = 5;
        this.random = new Random();
    }

    public void desbloquearA2() {
        this.estado_ataque2 = "DESBLOQUEADO";
    }

    public void desbloquearA3() {
        this.estado_ataque3 = "DESBLOQUEADO";
    }

    public int setAtaqueFuerteDaño(int dañoAF) {
        this.daño_ataqueFuerte = dañoAF;
        return daño_ataqueFuerte;
    }

    public void subirNivel() {
        this.nivel += 1;
        this.daño_ataque1 += 10;
        this.daño_ataque2 += 20;
        this.daño_ataque3 += 30;
        this.daño_ataqueFuerte += 100;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getNivel() {
        return nivel;
    }

    public int getDañoAtaque1() {
        return random.nextInt(6) + daño_ataque1;
    }

    public int getDañoAtaque2() {
        return random.nextInt(10) + daño_ataque2;
    }

    public int getDañoAtaque3() {
        return random.nextInt(15) + daño_ataque3;
    }

    public int getDañoAtaqueFuerte() {
        return daño_ataqueFuerte;
    }

    public int getDañoAtaqueFatality() {
        return dañoAtaqueFatality;
    }

    public int getCooldownA1() {
        return cooldownA1;
    }

    public int getCooldownA2() {
        return cooldownA2;
    }

    public int getCooldownA3() {
        return cooldownA3;
    }
}

