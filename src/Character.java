public class Character {

    protected double hp;
    protected double atk;
    protected Boolean status;
    protected Position pos;

    public double getATK(){
        return atk;
    }

    public double getHP(){
        return hp;
    }

    public void attack(Character a){
        hp = hp - a.getATK();
    }

    public void runGeneticcode(){

    }
    
}
