package com.booboo.CAREN.Model;
public class Virus_X extends Virus {

    Virus_X(int posx,int posy){
        this.type = "virus";
        this.atk = 20;
        this.hp = 80;
        this.credit = 10;
        this.pos = new Position(posx, posy);
        this.filename = "src/main/java/com/booboo/CAREN/Model/Genetic/Genetic_X.txt";
    }
}
