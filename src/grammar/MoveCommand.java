package grammar;

public class MoveCommand implements Node{

    protected String direction;

    MoveCommand(String direction){
        this.direction = direction;
    }

    @Override
    public double evaluate() {
        System.out.println(direction);
        return 0;
    }
    
}
