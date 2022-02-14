package grammar;

public class AssignmentStatement implements Node {
    protected Variable variable;
    protected Node expression;

    AssignmentStatement(Node expression, Variable variable){
        this.expression = expression;
        this.variable = variable;
    }

    @Override
    public double evaluate() throws SyntaxError {
        variable.addValue(expression.evaluate());
        return 0;
    }
    
}
