package Model;
public class Virus_Z extends Virus {

    Virus_Z(int posx,int posy){
        this.atk = 15;
        this.hp = 110;
        this.credit = 20;
        this.pos = new Position(posx, posy);
        this.filename = "src/Model/Genetic/Genetic_Z.txt";
    }
    
}
