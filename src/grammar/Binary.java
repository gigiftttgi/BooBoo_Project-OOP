package grammar;

public class Binary implements Node{

    private Node left;
    private Node right;
    private String op;

    Binary(Node left, String op, Node right){
        this.left = left;
        this.right = right;
        this.op = op;
    }

    @Override
    public double evaluate() throws SyntaxError {
        double lv = left.evaluate();
        double rv = right.evaluate();
        System.out.print("lv :" + lv + " , rv : " + rv);
        if(op.equals("+")) return lv+rv;
        if(op.equals("-")) return lv-rv;
        if(op.equals("*")) return lv*rv;
        if(op.equals("/")) return lv/rv;
        if(op.equals("%")) return lv%rv;
        if(op.equals("^")) return Math.pow(lv, rv);
        throw new SyntaxError();
    }
    
}
