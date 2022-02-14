package grammar;

public class WhileStatement extends StatementNode {

    protected Node expression;
    protected StatementNode loopStatement;

    WhileStatement(Node expression, StatementNode loopStatement){
        this.expression = expression;
        this.loopStatement = loopStatement;
    }

    public StatementNode getLoopstatem(){
        return loopStatement;
    }

    public Node setCondition(Node exp){
        if(expression == exp){
            return expression;
        }
        else{
            expression = exp;
            return expression;
        }
    }
       
}
