package grammar;

public class Expressionparse {

    private Tokenizer tkz;

    public Expressionparse(String src) throws SyntaxError{
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
        else if(tkz.peek("if")){
            System.out.print("if parse");
            s = ifParse();
        }
           
        return s;
    }

    private Node parseP() throws SyntaxError {
        if (isNumber(tkz.peek())) {
            return new Intlit(Double.parseDouble(tkz.consume()));
        } else {
            Node e = parseE();
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

    // Statement → Command | BlockStatement | IfStatement | WhileStatement
    private Node statementParse() throws SyntaxError {
        Node s = null;
        if(tkz.peek("if")){
            s = new StatementNode(ifParse());
        }
        else if(tkz.peek("while")){
            s = new StatementNode(whileParse());
        }
        else if(tkz.peek("{")){
            s = new StatementNode(blockParse());
        }
        else{
            s = new StatementNode(commandParse());
        }

        return s;
    }

    private Node blockParse(){
        Node b = null;
        return b;
    }

    // IfStatement → if ( Expression ) then Statement else Statement
    private Node ifParse() throws SyntaxError{
        Node i = null;
        tkz.consume(); // if
        tkz.consume(); // (
        Node ifstat = parseE();
        tkz.consume(")");
        tkz.consume("then"); // then
        Node thenstat = statementParse();
        tkz.consume("else");
        Node elsestat = statementParse();

        return new IfStatement(ifstat,thenstat,elsestat);
    }

    private Node whileParse(){
        Node w = null;
        return w;
    }


    private Node commandParse(){
        Node c = null;
        return c;
    }

    private Node assignmentParse(){
        Node a = null;
        return a;
    }

    private Node actionParse(){
        Node a = null;
        return a;
    }
    
    private Node shootParse() throws SyntaxError{
        Node s = null;
        tkz.consume();
        s = new AttackCommand(directionParse());
        return s;
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
