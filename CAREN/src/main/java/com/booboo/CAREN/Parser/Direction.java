package com.booboo.CAREN.Parser;

public class Direction implements Node{

    // left | right | up | down | upleft | upright | downleft | downright
    private String direct;

    Direction(String direct){
        this.direct = direct;
    }

    @Override
    public int evaluate() throws SyntaxError {
        switch (direct) {
            case "up" -> { return 1; }
            case "upright"  -> { return 2; }
            case "right"  -> { return 3; }
            case "downright"  -> { return 4; }
            case "down"  -> { return 5; }
            case "downleft"  -> { return 6; }
            case "left"  -> { return 7; }
            case "upleft"  -> { return 8; }
        }
        return 0;
    }
    
}
