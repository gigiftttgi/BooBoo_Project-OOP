package grammar;

public class AssignmentStatement implements Node {
    protected Variable variable;
    protected Node expression;

    AssignmentStatement(Node expression){
        this.expression = expression;
        this.variable = variable;
    }

    @Override
    public double evaluate() {
        
        return 0;
    }
    
}
