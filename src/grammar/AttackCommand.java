package grammar;

public class AttackCommand implements Node{

    protected String direction;

    AttackCommand(String direction){
        this.direction = direction;
    }

    @Override
    public double evaluate() throws SyntaxError {
        System.out.print(direction);
        return 0;
    }

    
}
