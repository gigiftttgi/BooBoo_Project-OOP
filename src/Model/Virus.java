package Model;

public class Virus extends Gamecharacter{

    protected int credit;

    public int changtoCredit(){
        if(super.hp > 0)
            return 0;
        return credit;
    }
}
