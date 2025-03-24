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
class Triangulo {
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

    public Triangulo() {
        this.vida = 180;
        this.nivel = 1;
        this.estado_ataque1 = "DESBLOQUEADO";
        this.estado_ataque2 = "BLOQUEADO";
        this.estado_ataque3 = "BLOQUEADO";
        this.estado_ataqueFuerte = "BLOQUEADO";
        this.daño_ataque1 = 15;
        this.daño_ataque2 = 25;
        this.daño_ataque3 = 40;
        this.daño_ataqueFuerte = 180;
        this.dañoAtaqueFatality = 30;
        this.cooldownA1 = 1;
        this.cooldownA2 = 2;
        this.cooldownA3 = 4;
        this.random = new Random();
    }

    public void desbloquearA2() {
        this.estado_ataque2 = "DESBLOQUEADO";
    }

    public void desbloquearA3() {
        this.estado_ataque3 = "DESBLOQUEADO";
    }

    public void subirNivel() {
        this.nivel += 1;
        this.daño_ataque1 += 8;
        this.daño_ataque2 += 18;
        this.daño_ataque3 += 28;
        this.daño_ataqueFuerte += 90;
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
        return random.nextInt(5) + daño_ataque1;
    }

    public int getDañoAtaque2() {
        return random.nextInt(8) + daño_ataque2;
    }

    public int getDañoAtaque3() {
        return random.nextInt(12) + daño_ataque3;
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