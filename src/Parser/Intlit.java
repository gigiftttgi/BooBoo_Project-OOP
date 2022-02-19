package Parser;

import java.util.Map;

public class Intlit implements Node{
        
    private String val;
    private Map<String,Double> allVariable;
        
    Intlit (String val, Map<String,Double> allVariable){
        this.val = val;
        this.allVariable = allVariable;
    }

    @Override
    public double evaluate() throws SyntaxError {
        if(isNumber(val))
            return Double.parseDouble(val);
        else{
            Variable v = new Variable(val, allVariable);
            return v.evaluate();
        }
            
    }

    private boolean isNumber(String s){
        try {
            Double.parseDouble(s);
            return true;
        }
        catch( Exception e ) {
            return false;
        }
    }
}
