package com.booboo.CAREN.Parser;

import java.util.Map;

import com.booboo.CAREN.Model.Gamecharacter;


public class GenaticParse {

    private Tokenizer tkz;
    private Gamecharacter host;
    private Map<String,Integer> allVariable;

    public GenaticParse(String src, Gamecharacter host) throws SyntaxError{
        this.tkz = new Tokenizer(src);
        this.host = host;
        this.allVariable = host.getAllVar();
    }

    // Program → Statement+
    public Node parse() throws SyntaxError{
        ProgramNode pro = new ProgramNode();

        while(tkz.peek() != null && !tkz.peek("")){
            if(tkz.peek("if")){
                pro.addStatement(ifParse());
            }
            else if(tkz.peek("while")){
                pro.addStatement(whileParse());
            }
            else if(tkz.peek("move") || tkz.peek("shoot")){
                pro.addStatement(commandParse());
            }
            else if(tkz.peek("else")) break;
            else if(tkz.peek("{")){
                tkz.consume();
                pro.addStatement(parse());
                if(!tkz.peek("}")) throw new SyntaxError();
                tkz.consume();
            }
            else if(tkz.peek("}")) break;
            else if(tkz.peek("\n")) tkz.consume();
            else if(tkz.peek().matches("up|upright|right|downright|down|downleft|left|upleft|antibody|virus|nearby") || 
                tkz.peek().matches("^[+]|^[-]|^[*]|^[%]|^[\\/]|^[\\^]")){
                    tkz.consume();
                }
            else{
                pro.addStatement(commandParse());
            }
        }
        return pro;
    }

    // SensorExpression → virus | antibody | nearby Direction
    private Node sensorParse() throws SyntaxError {
        Node s = null;
        if(tkz.peek("virus")){
            return new VirusNode(host);
        }
        if(tkz.peek("antibody")){
            return new AntibodyNode(host);
        }
        if(tkz.peek("nearby")){
            tkz.consume();
            return new Nearby(directionParse(), host);
        }
        return s;
    }

    // Power → <number> | <identifier> | ( Expression ) | SensorExpressio
    private Node parseP() throws SyntaxError {
        if (tkz.peek().matches("[a-zA-Z0-9]+")) {
            if(tkz.peek("virus") || tkz.peek("antibody") || tkz.peek("nearby")){
                return new SensorExpression(sensorParse());
            } 
            return new Intlit(tkz.consume(),allVariable);
        }         
        else {
            Node e = parseE();
            return e;
        }
    }

    // Factor → Power ^ Factor | Power
    private Node parseF() throws SyntaxError {
        Node p = parseP();
        while (tkz.peek("^")){
            tkz.consume();
            p = new RighBinary(parseP(),"^",p);
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

    // IfStatement → if ( Expression ) then Statement else Statement
    private Node ifParse() throws SyntaxError{

        tkz.consume(); // if
        tkz.consume(); // (
        Node ifstat = parseE();
        tkz.consume(); // )

        tkz.consume(); // then
        Node thenstat = parse();
        
        tkz.consume(); //else
        Node elsestat = parse();

        return new IfStatement(ifstat,thenstat,elsestat);
    }

    // WhileStatement → while ( Expression ) Statement
    private Node whileParse() throws SyntaxError{

        tkz.consume(); // while
        tkz.consume(); // (
        Node exp = parseE();
        tkz.consume(); // )
        Node loop = parse();
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
        // if(isNumber(tkz.peek())){
        Node exp = parseE();
        return new AssignmentStatement(exp, var);
        // return null;
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
        s = new AttackCommand(directionParse(),host);
        return s;
    }

    // MoveCommand → move Direction
    private Node moveParse() throws SyntaxError{
        Node m = null;
        tkz.consume();
        m = new MoveCommand(directionParse(),host);
        return m;
    } 
    
    // Direction → left | right | up | down | upleft | upright | downleft | downright
    private Node directionParse() throws SyntaxError{
        if(tkz.peek("right") || tkz.peek("left") || tkz.peek("up") || tkz.peek("down") || tkz.peek("upleft") 
            || tkz.peek("upright") || tkz.peek("downleft") || tkz.peek("downright"))
            return new Direction(tkz.peek());
        return null;
    }


}
