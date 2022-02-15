package grammar;

public class ActionCommand implements Node {
    
    private Node action;

    ActionCommand(Node action){
        this.action = action;
    }

    @Override
    public double evaluate() throws SyntaxError {
        action.evaluate();
        return 0;
    }
    
}
