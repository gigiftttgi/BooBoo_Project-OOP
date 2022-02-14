package grammar;

import java.util.Map;

public class Binary implements Node{

    private Node left;
    private Node right;
    private String op;

    Binary(Node left, Node right, String op){
        this.left = left;
        this.right = right;
        this.op = op;
    }

    @Override
    public double evaluate() {
        int lv = Integer.parseInt(left.toString());
        int rv = Integer.parseInt(right.toString());
        if(op.equals("+")) return lv+rv;
        if(op.equals("-")) return lv-rv;
        if(op.equals("*")) return lv*rv;
        if(op.equals("/")) return lv/rv;
        if(op.equals("%")) return lv%rv;
        return 0;
    }
    
}
