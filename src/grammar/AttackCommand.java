package grammar;

public class AttackCommand implements Node{

    protected Node direction;

    AttackCommand(Node direction){
        this.direction = direction;
    }

    @Override
    public double evaluate() throws SyntaxError {
        System.out.print(direction);
        return 0;
    }

    
}
