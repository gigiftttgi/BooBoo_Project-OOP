package com.booboo.CAREN.Parser;

public class ActionCommand implements Node {
    
    private Node action;

    ActionCommand(Node action){
        this.action = action;
    }

    @Override
    public int evaluate() throws SyntaxError {
        action.evaluate();
        return 0;
    }
    
}
