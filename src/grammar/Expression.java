package grammar;

public class Expression {

    private Tokenizer tkz;

    public Expression(String src) throws SyntaxError{
        this.tkz = new Tokenizer(src);
    }

    public Node startParse() throws SyntaxError{
        System.out.println(tkz.peek());
        Node s = null;
        if(isNumber(tkz.peek())){
            s = parseP();
        }
        else if(tkz.peek("move")){ 
            s = moveParse();
        }
        else if(tkz.peek("shoot")){
            s = shootParse();
        }
           
        return s;
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
        Node s = null;
        s = directionParse();
        return new AttackCommand(s);
    }

    private Node moveParse() throws SyntaxError{
        Node m = null;
        m = directionParse();
        return new MoveCommand(m);
    } 

    private Node directionParse() throws SyntaxError{
        tkz.consume();
        if(tkz.peek("right") || tkz.peek("left") || tkz.peek("up") || tkz.peek("down") || tkz.peek("upleft") 
            || tkz.peek("upright") || tkz.peek("downleft") || tkz.peek("downright"))
            return new Direction(tkz.peek());
        return null;
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
