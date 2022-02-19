package Parser;

import java.util.LinkedList;
import java.util.List;

public class Program implements Node{

    protected List<Node> statement;

    Program(){
        List<Node> statememt = new LinkedList<>();
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
