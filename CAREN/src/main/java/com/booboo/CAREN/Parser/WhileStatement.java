package com.booboo.CAREN.Parser;

public class WhileStatement implements Node{

    protected Node expression;
    protected Node loopStatement;

    WhileStatement(Node expression, Node loopStatement){
        this.expression = expression;
        this.loopStatement = loopStatement;
    }


    @Override
    public int evaluate() throws SyntaxError {

        while(expression.evaluate() > 0){
            loopStatement.evaluate();
        }
        return 0;
    }
       
}
