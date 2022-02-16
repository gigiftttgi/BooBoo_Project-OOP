package grammar;

import java.util.LinkedHashMap;
import java.util.Map;

public class Expressionparse {

    private Tokenizer tkz;
    private Map<String,Double> allVariable = new LinkedHashMap<>();

    public Expressionparse(String src) throws SyntaxError{
        this.tkz = new Tokenizer(src);
    }

    // Power → <number> | <identifier> | ( Expression ) | SensorExpressio
    private Node parseP() throws SyntaxError {
        if (isNumber(tkz.peek())) {
            return new Intlit(Double.parseDouble(tkz.consume()));
        } else {
            Node e = parseE();
            return e;
        }
    }

    // Factor → Power ^ Factor | Power
    private Node parseF() throws SyntaxError {
        Node p = parseP();
        while (tkz.peek("^")){
            tkz.consume();
            p = new Binary(p,"^",parseP());
        }
        return p;
    }
    
    // Term → Term * Factor | Term / Factor | Term % Factor | Factor
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

    // Expression → Expression + Term | Expression - Term | Term
    private Node parseE() throws SyntaxError {
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
    public Node statementParse() throws SyntaxError {
        Node s = null;
        if(tkz.peek("if") || tkz.peek("else")){
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

    // BlockStatement → { Statement* }
    private Node blockParse() throws SyntaxError{
        tkz.consume(); 
        Node block = new BlockStatement(statementParse());
        return block;
    }

    // IfStatement → if ( Expression ) then Statement else Statement
    private Node ifParse() throws SyntaxError{

        System.out.println(tkz.peek());
        if(tkz.peek("else")){
            tkz.consume(); // else
        }
        System.out.println(tkz.peek());
        tkz.consume(); // if
        tkz.consume(); // (
        Node ifstat = parseE();
        tkz.consume(")");
        tkz.consume("then"); // then
        Node thenstat = statementParse();
        tkz.consume();
        tkz.consume("else"); 
        Node elsestat = statementParse();

        return new IfStatement(ifstat,thenstat,elsestat);
    }

    // WhileStatement → while ( Expression ) Statement
    private Node whileParse() throws SyntaxError{

        tkz.consume(); // if
        tkz.consume(); // (
        Node exp = parseE();
        tkz.consume(")");
        Node loop = statementParse();
        return new WhileStatement(exp, loop);
    }

    // Command → AssignmentStatement | ActionCommand
    private Node commandParse() throws SyntaxError{
        Node c = null;
        if(tkz.peek("shoot") || tkz.peek("move")){
            c = new Command(actionParse());
        }
        else{
            c = new Command(assignmentParse());
        }
           
        return c;
    }

    // AssignmentStatement → <identifier> = Expression
    private Node assignmentParse() throws SyntaxError{
        Variable var = new Variable(tkz.peek(),allVariable);
        tkz.consume(); //identifilfer
        tkz.consume("=");
        Node exp = parseE();
        return new AssignmentStatement(exp, var);
    }

    // ActionCommand → MoveCommand | AttackCommand
    private Node actionParse() throws SyntaxError{
        Node a = null;
        if(tkz.peek("move")){
            a = new ActionCommand(moveParse());
        }
        else if(tkz.peek("shoot")){
            a = new ActionCommand(shootParse());
        }
        return a;
    }
    
    // AttackCommand → shoot Direction
    private Node shootParse() throws SyntaxError{
        Node s = null;
        tkz.consume();
        s = new AttackCommand(directionParse());
        return s;
    }

    // MoveCommand → move Direction
    private Node moveParse() throws SyntaxError{
        Node m = null;
        tkz.consume();
        m = new MoveCommand(directionParse());
        return m;
    } 
    
    // Direction → left | right | up | down | upleft | upright | downleft | downright
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
