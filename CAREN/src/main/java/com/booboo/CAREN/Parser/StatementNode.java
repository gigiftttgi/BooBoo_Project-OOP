package com.booboo.CAREN.Parser;

public class StatementNode implements Node{

    private Node statement;

    StatementNode(Node statement){
        this.statement = statement;
    }

    @Override
    public int evaluate() throws SyntaxError {
        statement.evaluate();
        return 0;
    }
    
}
