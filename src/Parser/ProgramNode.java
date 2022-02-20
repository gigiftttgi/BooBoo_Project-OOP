package Parser;

import java.util.LinkedList;
import java.util.List;

import Model.Gamecharacter;
import Model.Virus;

public class ProgramNode implements Node{

    protected List<Node> statement;

    public ProgramNode(){
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
