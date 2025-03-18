/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package warbit;

/**
 *
 * @author ramon
 */
public class PLAYER {
    
    private int vida;
    private String estado_ataque1;
    private String estado_ataque2;
    private String estado_ataque3;
    private String estado_ataqueFuerte;
    private int daño_ataque1;
    private int daño_ataque2;
    private int daño_ataque3;
    private int daño_ataqueFuerte;
    private int dañoAtaqueFatality;
    

    public PLAYER(){
        
        this.vida = 200;
        this.estado_ataque1 = "DESBLOQUEADO";
        this.estado_ataque2 = "BLOQUEADO";
        this.estado_ataque3 = "BLOQUEADO";
        this.estado_ataqueFuerte = "BLOQUEADO";
        this.daño_ataque1 = 35;
        this.daño_ataque2 = 45;
        this.daño_ataque3 = 60;
        this.daño_ataqueFuerte = 200;
        this.dañoAtaqueFatality = 15;
        
    }
    
    public void desbloquearA2 (){
        this.estado_ataque2 = "DESBLOQUEADO";
    }
    public void desbloquearA3 (){
        this.estado_ataque3 = "DESBLOQUEADO";
    }    
    public int setAtaqueFuerteDaño (int dañoAF){
        this.daño_ataqueFuerte = dañoAF;
        return daño_ataqueFuerte;
    }    
}