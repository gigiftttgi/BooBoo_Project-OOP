package grammar;

import java.util.ArrayList;
import java.util.List;

public class BlockStatement implements Node{

    protected List<Node> statement;

    BlockStatement(){
        List<Node> statement = new ArrayList<>();
    }

    public void addStatement(Node newStatement){
        statement.add(newStatement);
    }

    @Override
    public double evaluate() throws SyntaxError {
        for(Node st : statement){
            st.evaluate();
        }
        return 0;
    }
    
}
