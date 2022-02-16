package grammar;

import Model.Gamecharacter;

public class MoveCommand implements Node{

    protected Node direction;
    protected Gamecharacter host;

    MoveCommand(Node direction , Gamecharacter host){
        this.direction = direction;
        this.host = host;
    }

    @Override
    public double evaluate() throws SyntaxError {
        host.move(direction.evaluate());        
        return 0;
    }
    
}
