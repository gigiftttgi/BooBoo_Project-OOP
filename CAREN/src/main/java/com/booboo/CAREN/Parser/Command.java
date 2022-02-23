package com.booboo.CAREN.Parser;

import java.lang.management.ThreadInfo;

public class Command implements Node {

    private Node command;

    Command(Node command){
        this.command = command;
    }

    @Override
    public int evaluate() throws SyntaxError {
        command.evaluate();
        return 0;
    }
    
}
