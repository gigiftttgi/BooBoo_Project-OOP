package com.booboo.CAREN.Parser;

import java.util.Map;

public class Intlit implements Node{
        
    private String val;
    private Map<String,Integer> allVariable;
        
    Intlit (String val, Map<String,Integer> allVariable){
        this.val = val;
        this.allVariable = allVariable;
    }

    @Override
    public int evaluate() throws SyntaxError {
        if(isNumber(val))
            return Integer.parseInt(val);
        else{
            Variable v = new Variable(val, allVariable);
            return v.evaluate();
        }
            
    }

    private boolean isNumber(String s){
        try {
            Integer.parseInt(s);
            return true;
        }
        catch( Exception e ) {
            return false;
        }
    }
}
