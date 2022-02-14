package grammar;

public class Expression implements Node {

    private Tokenizer tkz;


    public Expression(String src) throws SyntaxError{
        this.tkz = new Tokenizer(src);
    }

    public Node parseE() throws NumberFormatException, SyntaxError{
        if (isNumber(tkz.peek())) {
            return new Intlit(Integer.parseInt(tkz.consume()));
        } else {
            while (tkz.peek("*") || tkz.peek("/") || tkz.peek("%")) {
                String op = tkz.peek();
                tkz.consume();
                switch (op){
                    case "*" -> {
                        binary = new Binary(f, "*", parseF());
                        f = binary;
                    }
                    case "/" -> {
                        binary = new Binary(f, "/", parseF());
                        f = binary;
                    }
                    case "%" -> {
                        binary = new Binary(f, "%", parseF());
                        f = binary;
                    }
                }
                result = binary.eval(map);
            }
        }
    }

    private Node parseT() throws SyntaxError {
        Expr t = parseT();
        while (tkz.peek("+") || tkz.peek("-")) {
            String op = tkz.peek();
            tkz.consume();
            switch (op){
                case "+" -> {
                    binary = new Binary(t, "+", parseT());
                    t = binary;
                }

                case "-" -> {
                    binary = new Binary(t, "-", parseT());
                    t = binary;
                }
            }
            result = binary.eval(map);
        }
        return t;
    }

    private Node attackParse() throws SyntaxError{
        tkz.consume();
        Node a = null;
        if(tkz.peek("right"))
            return new MoveCommand("right");
        else if(tkz.peek("left"))
            return new MoveCommand("left");
        else if(tkz.peek("up"))
            return new MoveCommand("up");
        else if(tkz.peek("down"))
            return new MoveCommand("down");
        else if(tkz.peek("upleft"))
            return new MoveCommand("upleft");
        else if(tkz.peek("upright"))
            return new MoveCommand("upright");
        else if(tkz.peek("downleft"))
            return new MoveCommand("downleft");
        else if(tkz.peek("downright"))
            return new MoveCommand("downright");
        return a;
    }

    private Node moveParse() throws SyntaxError{
        tkz.consume();
        Node m = null;
        if(tkz.peek("right"))
            return new MoveCommand("right");
        else if(tkz.peek("left"))
            return new MoveCommand("left");
        else if(tkz.peek("up"))
            return new MoveCommand("up");
        else if(tkz.peek("down"))
            return new MoveCommand("down");
        else if(tkz.peek("upleft"))
            return new MoveCommand("upleft");
        else if(tkz.peek("upright"))
            return new MoveCommand("upright");
        else if(tkz.peek("downleft"))
            return new MoveCommand("downleft");
        else if(tkz.peek("downright"))
            return new MoveCommand("downright");
        return m;
    } 

    @Override
    public double evaluate() throws SyntaxError {
        if(tkz.peek("move")){
            System.out.print(tkz.peek() + " -> ");
            moveParse().evaluate();
        }
        if(tkz.peek("attack")){
            System.out.print("\n" + tkz.peek() + " -> ");
            attackParse().evaluate();
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
