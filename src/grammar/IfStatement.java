package grammar;

public class IfStatement implements Node { 
    protected Node expression;
    protected StatementNode thenStatement;
    protected StatementNode elseStatement;
    
    IfStatement(Node expression){
    //StatementNode thenStatement, StatementNode elseStatement){
        this.expression = expression;
        // this.thenStatement = thenStatement;
        // this.elseStatement = elseStatement;
    }

    @Override
    public double evaluate() throws SyntaxError {
        if(expression.evaluate() == 1){
            System.out.print("true");
            //thenStatement.evaluate();
        }           
        else{
            System.out.print("false");
            //elseStatement.evaluate();
        }           
        return 0;
    }
}
