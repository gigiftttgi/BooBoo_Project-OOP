package Model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import grammar.Expressionparse;
import grammar.SyntaxError;

public class Character {

    protected double hp;
    protected double atk;
    protected Boolean status;
    protected Position pos;
    protected String filename;

    public double getATK(){
        return atk;
    }

    public double getHP(){
        return hp;
    }

    public void attack(Character a){
        hp = hp - a.getATK();
    }

    public void startPosition(){
        //ตำแหน่งตอนเกิด
    }

    public void runGeneticcode() throws SyntaxError, FileNotFoundException{
        FileReader f = new FileReader(filename);
        Scanner reader = new Scanner(f);
        do {
            String l = reader.nextLine();
            System.out.println(l);
            Expressionparse e = new Expressionparse(l);
            e.statementParse().evaluate(); 
            System.out.println("\n--------------------");
        } while (reader.hasNextLine());
    }
    
}
