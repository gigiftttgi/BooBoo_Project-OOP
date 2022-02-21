package com.booboo.CAREN.Parser;

import java.util.LinkedList;
import java.util.List;

import com.booboo.CAREN.Model.Gamecharacter;
import com.booboo.CAREN.Model.Virus;

public class ProgramNode implements Node{

    protected List<Node> statement;

    public ProgramNode(){
        this.statement = new LinkedList<>();
    }

    public void addStatement(Node newStatement){
        statement.add(newStatement);
    }

    @Override
    public double evaluate() throws SyntaxError {
        for(Node current : statement){
            current.evaluate();
        }
        return 0;
    }
    
}
