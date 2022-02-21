package com.booboo.CAREN.Parser;

import java.util.LinkedHashMap;
import java.util.Map;

import com.booboo.CAREN.Model.Random_int;

public class Variable implements Node {

    protected Map<String,Double> allVariable;
    protected String identifier;
    protected Random_int r = new Random_int(8);


    Variable(String identifier, Map<String,Double> allVariable){
        this.identifier = identifier;
        this.allVariable = allVariable;

        if(!allVariable.keySet().contains(identifier)){
            if(identifier.equals("random")){
                allVariable.put(identifier,(double) r.randomInt()+1);
            }
            else{
                allVariable.put(identifier, 0.0);
            }
        }
            
    }

    @Override
    public double evaluate() {
        if(!allVariable.keySet().contains(identifier))
            allVariable.put(identifier, 0.0);
        if(identifier.equals("random")){
            allVariable.put("random", (double) (r.randomInt()+1));
        }
             
        return allVariable.get(identifier);
    }

    public void addValue(double value){
        allVariable.put(identifier,value);
    }
    
}
