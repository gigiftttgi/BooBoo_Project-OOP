package com.booboo.CAREN.Parser;

public class RighBinary implements Node {
    
    private Node left;
    private Node right;
    private String op;

    RighBinary(Node left, String op, Node right){
        this.left = left;
        this.right = right;
        this.op = op;
    }

    @Override
    public int evaluate() throws SyntaxError {
        int lv = left.evaluate();
        int rv = right.evaluate();
        if(op.equals("^")) return (int) Math.pow(lv, rv);
        throw new SyntaxError();
    }
    
}
