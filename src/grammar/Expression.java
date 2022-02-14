package grammar;

public class Expression implements Node {

    private Tokenizer tkz;


    public Expression(String src) throws SyntaxError{
        this.tkz = new Tokenizer(src);
    }

    @Override
    public double evaluate() {
        if(tkz.peek("move")){
            System.out.print("move -> ");
            MoveCommand m = new MoveCommand("right");
            m.evaluate();
        }
        return 0;
    }

    
}
