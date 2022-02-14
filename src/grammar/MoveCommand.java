package grammar;

public class MoveCommand implements Node{

    protected Node direction;

    MoveCommand(Node direction){
        this.direction = direction;
    }

    @Override
    public double evaluate() throws SyntaxError {
        System.out.println("Move ->");
        direction.evaluate();
        return 0;
    }
    
}
