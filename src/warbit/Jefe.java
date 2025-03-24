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
class Jefe {
    private int vida;
    private int fase;
    private int dañoAtaque1;
    private int dañoAtaque2;
    private int dañoAtaqueEspecial;
    private int cooldownA1;
    private int cooldownA2;
    private int cooldownEspecial;
    private Random random;

    public Jefe() {
        this.vida = 500;
        this.fase = 1;
        this.dañoAtaque1 = 30;
        this.dañoAtaque2 = 50;
        this.dañoAtaqueEspecial = 100;
        this.cooldownA1 = 2;
        this.cooldownA2 = 4;
        this.cooldownEspecial = 6;
        this.random = new Random();
    }

    public void siguienteFase() {
        this.fase++;
        this.vida += 100;
        this.dañoAtaque1 += 10;
        this.dañoAtaque2 += 20;
        this.dañoAtaqueEspecial += 50;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDañoAtaque1() {
        return random.nextInt(10) + dañoAtaque1;
    }

    public int getDañoAtaque2() {
        return random.nextInt(15) + dañoAtaque2;
    }

    public int getDañoAtaqueEspecial() {
        return dañoAtaqueEspecial;
    }

    public int getCooldownA1() {
        return cooldownA1;
    }

    public int getCooldownA2() {
        return cooldownA2;
    }

    public int getCooldownEspecial() {
        return cooldownEspecial;
    }
}

