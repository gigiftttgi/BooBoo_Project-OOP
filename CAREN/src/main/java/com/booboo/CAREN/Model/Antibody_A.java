package com.booboo.CAREN.Model;

public class Antibody_A  extends Antibody {

    Antibody_A(int posx, int posy){
        this.type = "A";
        this.atk = 15;
        this.hp = 100;
        this.moveCost = 10;
        this.pos = new Position(posx, posy);
        this.filename = "CAREN/src/main/java/com/booboo/CAREN/Model/Genetic/Genetic_A.txt";
        
    }
    
}
