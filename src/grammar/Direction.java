package grammar;

public class Direction implements Node{

    // left | right | up | down | upleft | upright | downleft | downright
    private String direct;

    Direction(String direct){
        this.direct = direct;
    }

    @Override
    public double evaluate() throws SyntaxError {
        switch (direct) {
            case "up" -> { return 1.0; }
            case "upright"  -> { return 2.0; }
            case "right"  -> { return 3.0; }
            case "downright"  -> { return 4.0; }
            case "down"  -> { return 5.0; }
            case "downleft"  -> { return 6.0; }
            case "left"  -> { return 7.0; }
            case "upleft"  -> { return 8.0; }
        }
        return 0;
    }
    
}
