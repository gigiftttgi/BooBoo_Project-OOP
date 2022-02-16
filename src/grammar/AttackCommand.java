package grammar;

import Model.Gamecharacter;

public class AttackCommand implements Node{

    protected Node direction;
    protected Gamecharacter host;

    AttackCommand(Node direction,Gamecharacter host){
        this.direction = direction;
        this.host = host;
    }

    @Override
    public double evaluate() throws SyntaxError {
        System.out.print("\nAttack ->");
        direction.evaluate();
        return 0;
    }

    
}
