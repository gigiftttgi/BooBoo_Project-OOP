package com.booboo.CAREN.Parser;

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
    public int evaluate() throws SyntaxError {
        // positive is true
        if(expression.evaluate() > 0){
            thenStatement.evaluate();
        }           
        else{
            elseStatement.evaluate();
        }           
        return 0;
    }
}
