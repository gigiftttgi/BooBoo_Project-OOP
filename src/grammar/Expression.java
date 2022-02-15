package grammar;

public class Expression {

    private Tokenizer tkz;

    public Expression(String src) throws SyntaxError{
        this.tkz = new Tokenizer(src);
    }

    public Node startParse() throws SyntaxError{
        Node s = null;
        if(isNumber(tkz.peek())){
            s = parseE();
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
            return new Intlit(Double.parseDouble(tkz.consume()));
        } else {
            tkz.consume("(");
            Node e = parseE();
            tkz.consume(")");
            return e;
        }
    }

    private Node parseF() throws SyntaxError {
        Node p = parseP();
        while (tkz.peek("^")){
            tkz.consume();
            p = new Binary(p,"^",parseP());
        }
        return p;
    }
    
    private Node parseT() throws SyntaxError {
        Node f = parseF();
        while (tkz.peek("*") || tkz.peek("/") || tkz.peek("%")) {
            String op = tkz.peek();
            tkz.consume();
            switch(op){
                case "*" -> {
                    f = new Binary(f, "*", parseF());
                }
                case "/" -> {
                    f = new Binary(f, "/", parseF());
                }
                case "%" -> {
                    f = new Binary(f, "%", parseF());
                }
            }
        }
        return f;
    }

    public Node parseE() throws SyntaxError {
        Node t = parseT();
        while (tkz.peek("+") || tkz.peek("-")) {
            String op = tkz.peek();
            tkz.consume();
            switch(op){
                case "+" -> {
                    t = new Binary(t, "+", parseT());
                }
                case "-" -> {
                    t = new Binary(t, "-", parseT());
                }
            }
        }
        return t;
    }

    private Node ifParse() throws SyntaxError{
        Node i = null;
        if(tkz.peek("if")){
            tkz.consume("(");
            i = parseP();
            tkz.consume(")");
        }
        return i;
    }
    
    
    private Node shootParse() throws SyntaxError{
        Node s = null;
        tkz.consume();
        s = directionParse();
        return new AttackCommand(s);
    }

    private Node moveParse() throws SyntaxError{
        Node m = null;
        tkz.consume();
        m = new MoveCommand(directionParse());
        return m;
    } 

    private Node directionParse() throws SyntaxError{
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
