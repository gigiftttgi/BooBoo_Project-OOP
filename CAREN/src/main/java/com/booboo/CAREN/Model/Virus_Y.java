package com.booboo.CAREN.Model;
public class Virus_Y extends Virus {
    
    Virus_Y(int posx,int posy){
        this.type = "virus";
        this.atk = 10;
        this.hp = 130;
        this.credit = 20;
        this.pos = new Position(posx, posy);
        this.filename = "CAREN/src/main/java/com/booboo/CAREN/Model/Genetic/Genetic_Y.txt";
    }
}
