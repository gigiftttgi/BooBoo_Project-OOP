package Parser;

public class SensorExpression implements Node {

    private Node sensor;

    SensorExpression(Node sensor){
        this.sensor = sensor;
    }

    @Override
    public double evaluate() throws SyntaxError {
        return sensor.evaluate();
    }
    
}
