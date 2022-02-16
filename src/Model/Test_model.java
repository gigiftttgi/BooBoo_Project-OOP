package Model;

import java.io.FileNotFoundException;

import grammar.SyntaxError;

public class Test_model {
    public static void main(String[] args) throws FileNotFoundException, SyntaxError {
        Antibody_A a = new Antibody_A();
        a.pos = new Position(3, 4);
        a.runGeneticcode();
        System.out.println(a.pos.getX_Position() + " " + a.pos.getY_Position());
    }
}
