package com.booboo.CAREN.Model;
public class Virus_Z extends Virus {

    Virus_Z(int posx,int posy){
        this.type = "virus";
        this.atk = 15;
        this.hp = 110;
        this.credit = 20;
        this.pos = new Position(posx, posy);
        this.filename = "CAREN/src/main/java/com/booboo/CAREN/Model/Genetic/Genetic_Z.txt";
    }
    
}
