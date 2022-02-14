package grammar;

public class IfStatement implements Node { 
    protected Node expression;
    protected StatementNode thenStatement;
    protected StatementNode elseStatement;
    
    IfStatement(Node expression, StatementNode thenStatement, StatementNode elseStatement){
        this.expression = expression;
        this.thenStatement = thenStatement;
        this.elseStatement = elseStatement;
    }

    public StatementNode getThenStatement(){
        return thenStatement;
    }

    public StatementNode getElseStatement(){
        return elseStatement;
    }

    public Node setCondition(Node exp){
        if(expression == exp){
            return expression;
        }
        else{
            expression = exp;
            return expression;
        }
    }

    @Override
    public double evaluate() throws SyntaxError {
        expression.evaluate();
        thenStatement.evaluate();
        elseStatement.evaluate();
        return 0;
    }
}
