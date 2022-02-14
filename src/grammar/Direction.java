package grammar;

public class Direction implements Node{

    private String direct;

    Direction(String direct){
        this.direct = direct;
    }

    @Override
    public double evaluate() throws SyntaxError {
        System.out.println(direct);
        return 0;
    }
    
}
