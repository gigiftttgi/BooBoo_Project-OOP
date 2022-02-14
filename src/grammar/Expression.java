package grammar;

import java.util.HashMap;
import java.util.Map;

public class Expression implements Node {

    private Tokenizer tkz;

    public Expression(String src) throws SyntaxError{
        this.tkz = new Tokenizer(src);
    }

    private Node parseP() throws SyntaxError {
        if (isNumber(tkz.peek())) {
            return new Intlit(Integer.parseInt(tkz.consume()));
        } else {
            tkz.consume("(");
            Node f = parseF();
            tkz.consume(")");
            return f;
        }
    }

    private Node parseF() throws SyntaxError {
        Node p = parseP();
        tkz.consume();
        while (tkz.peek("^")){
            p = new Binary(p,"^",parseP());
        }
        return p;
    }
    

    private Node parseT() throws SyntaxError {
        Node f = parseF();
        while (tkz.peek("*") || tkz.peek("/") || tkz.peek("%")) {
            tkz.consume();
            if(tkz.peek("*"))
                f = new Binary(f, "*", parseF());
            if(tkz.peek("/"))
                f = new Binary(f, "/", parseF());
            if(tkz.peek("%"))
                f = new Binary(f, "%", parseF());
        }
        return f;
    }

    public Node parseE() throws SyntaxError {
        Node t = parseT();
        while (tkz.peek("+") || tkz.peek("-")) {
            tkz.consume();
            if(tkz.peek("+"))
                t = new Binary(t, "+", parseT());
            if(tkz.peek("-"))
                t = new Binary(t, "-", parseT());
        }
        return t;
    }

    private Node shootParse() throws SyntaxError{
        tkz.consume();
        Node a = null;
        if(tkz.peek("right") || tkz.peek("left") || tkz.peek("up") || tkz.peek("down") || tkz.peek("upleft") 
            || tkz.peek("upright") || tkz.peek("downleft") || tkz.peek("downright"))
            return new AttackCommand(tkz.peek());
        return a;
    }

    private Node moveParse() throws SyntaxError{
        tkz.consume();
        Node m = null;
        if(tkz.peek("right") || tkz.peek("left") || tkz.peek("up") || tkz.peek("down") || tkz.peek("upleft") 
            || tkz.peek("upright") || tkz.peek("downleft") || tkz.peek("downright"))
            return new MoveCommand(tkz.peek());
        return m;
    } 

    @Override
    public double evaluate() throws SyntaxError {
        if(tkz.peek("move")){
            System.out.print(tkz.peek() + " -> ");
            moveParse().evaluate();
        }
        if(tkz.peek("shoot")){
            System.out.print("\n" + tkz.peek() + " -> ");
            shootParse().evaluate();
        }
            
        return 0;
    }    

    private boolean isNumber(String s){
        try {
            Integer.parseInt(s);
            return true;
        }
        catch( Exception e ) {
            return false;
        }
    }
}
