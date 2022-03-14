package com.booboo.CAREN.Parser;

public class SensorExpression implements Node {

    private Node sensor;

    SensorExpression(Node sensor){
        this.sensor = sensor;
    }

    @Override
    public int evaluate() throws SyntaxError {
        return sensor.evaluate();
    }
    
}
