package com.booboo.CAREN.Model;

public class Antibody_C extends Antibody {

    Antibody_C(int posx, int posy){
        this.type = "antibody";
        this.atk = 10;
        this.hp = 120;
        this.moveCost = 15;
        this.pos = new Position(posx, posy);
        this.filename = "CAREN/src/main/java/com/booboo/CAREN/Model/Genetic/Genetic_C.txt";
        
    }
    
}
