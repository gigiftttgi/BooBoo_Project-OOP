package grammar;

public class IfStatement implements Node { 
    protected Node expression;
    protected Node thenStatement;
    protected Node elseStatement;
    
    IfStatement(Node expression, Node thenstat, Node elsestat){
        this.expression = expression;
        this.thenStatement = thenstat;
        this.elseStatement = elsestat;
    }

    @Override
    public double evaluate() throws SyntaxError {
        if(expression.evaluate() == 1){
            System.out.print("true");
            thenStatement.evaluate();
        }           
        else{
            System.out.print("false");
            elseStatement.evaluate();
        }           
        return 0;
    }
}
