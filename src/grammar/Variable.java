package grammar;

import java.util.Map;

public class Variable implements Node {

    protected Map<String,Double> allVariable = null;
    protected String identifier;
    

    Variable(String identifier){
        this.identifier = identifier;
        allVariable.put(identifier,0.0);
    }

    @Override
    public double evaluate() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
