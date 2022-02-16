package Model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import grammar.Expressionparse;
import grammar.SyntaxError;

public class Gamecharacter {

    protected double hp;
    protected double atk;
    protected Boolean status;
    protected Position pos;
    protected String filename;
    protected Map<String,Double> allVariable = new LinkedHashMap<>();

    public double getATK(){
        return atk;
    }

    public double getHP(){
        return hp;
    }

    public void attack(Gamecharacter a){
        hp = hp - a.getATK();
    }

    public void startPosition(){
        //ตำแหน่งตอนเกิด
    }

    public void move(Double direction){
        switch(direction.toString()){
            case "1.0" : { 
                System.out.println("move -> up");
                pos.movePosition(0, 1);
                break;
            }
            case "2.0" : { 
                System.out.println("move -> upright");
                pos.movePosition(1, 1);
                break;
            }
            case "3.0" : { 
                System.out.println("move -> right");
                pos.movePosition(1, 0);
                break;
            }
            case "4.0" : { 
                System.out.println("move -> downright");                
                pos.movePosition(1, -1);
                break;
            }
            case "5.0" : { 
                System.out.println("move -> down");
                pos.movePosition(0, -1);
                break;
            }
            case "6.0" : { 
                System.out.println("move -> downleft");
                pos.movePosition(-1, -1);
                break;
            }
            case "7.0" : { 
                System.out.println("move -> left");
                pos.movePosition(-1, 0);
                break;
            }
            case "8.0" : { 
                System.out.println("move -> upleft");
                pos.movePosition(-1, 1);
                break;
            }
        }

    }

    public void runGeneticcode() throws SyntaxError, FileNotFoundException{
        FileReader f = new FileReader(filename);
        Scanner reader = new Scanner(f);
        do {
            String l = reader.nextLine();
            System.out.println(l);
            Expressionparse e = new Expressionparse(l,this,allVariable);
            e.statementParse().evaluate(); 
            System.out.println("\n--------------------");
        } while (reader.hasNextLine());
    }
    
}
