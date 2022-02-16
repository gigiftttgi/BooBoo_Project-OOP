package Parser;

public class StatementNode implements Node{

    private Node statement;

    StatementNode(Node statement){
        this.statement = statement;
    }

    @Override
    public double evaluate() throws SyntaxError {
        statement.evaluate();
        return 0;
    }
    
}
