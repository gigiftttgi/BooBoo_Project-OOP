package grammar;

import java.util.LinkedHashMap;
import java.util.Map;

public class Variable implements Node {

    protected Map<String,Double> allVariable;
    protected String identifier;


    Variable(String identifier, Map<String,Double> allVariable){
        this.identifier = identifier;
        this.allVariable = allVariable;

        if(!allVariable.keySet().contains(identifier))
            allVariable.put(identifier, 0.0);
    }

    @Override
    public double evaluate() {
        if(!allVariable.keySet().contains(identifier))
            allVariable.put(identifier, 0.0);
        return 0;
    }

    public void addValue(double value){
        allVariable.put(identifier,value);
    }
    
}
