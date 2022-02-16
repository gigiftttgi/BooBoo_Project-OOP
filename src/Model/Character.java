package Model;
public class Character {

    protected double hp;
    protected double atk;
    protected Boolean status;
    protected Position pos;
    protected String filename;

    public double getATK(){
        return atk;
    }

    public double getHP(){
        return hp;
    }

    public void attack(Character a){
        hp = hp - a.getATK();
    }

    public void startPosition(){
        //ตำแหน่งตอนเกิด
    }

    public void runGeneticcode(String filename){

    }
    
}
