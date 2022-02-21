package com.booboo.CAREN.Parser;

import java.util.ArrayList;
import java.util.List;

public class BlockStatement implements Node{

    protected List<Node> statement;
    private Node newstat;

    BlockStatement(Node newstat){
        List<Node> statement = new ArrayList<>();
        statement.add(newstat);
    }

    public void addStatement(Node newStatement){
        statement.add(newStatement);
    }

    @Override
    public double evaluate() throws SyntaxError {
        for(Node st : statement){
            st.evaluate();
        }
        return 0;
    }
    
}
