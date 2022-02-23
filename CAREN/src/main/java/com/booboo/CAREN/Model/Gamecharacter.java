package com.booboo.CAREN.Model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import com.booboo.CAREN.Parser.Expressionparse;
import com.booboo.CAREN.Parser.Node;
import com.booboo.CAREN.Parser.ProgramNode;
import com.booboo.CAREN.Parser.SyntaxError;

public class Gamecharacter {

    protected double hp;
    protected double atk;
    protected Boolean status;
    protected Position pos;
    protected String filename;
    protected String type;
    protected Map<String,Integer> allVariable = new LinkedHashMap<>();

    public double getATK(){
        return atk;
    }

    public double getHP(){
        return hp;
    }

    public Position getPos(){
        return pos;
    }

    public String getType(){
        return type;
    }

    public void attackedBy(Gamecharacter attacker){
        hp = hp - attacker.getATK();
    }

    public void move(int direction){
        switch(direction){
            case  1 : { 
                System.out.println("move -> up");
                pos.movePosition(0, 1);
                break;
            }
            case 2 : { 
                System.out.println("move -> upright");
                pos.movePosition(1, 1);
                break;
            }
            case 3 : { 
                System.out.println("move -> right");
                pos.movePosition(1, 0);
                break;
            }
            case 4 : { 
                System.out.println("move -> downright");                
                pos.movePosition(1, -1);
                break;
            }
            case 5 : { 
                System.out.println("move -> down");
                pos.movePosition(0, -1);
                break;
            }
            case 6: { 
                System.out.println("move -> downleft");
                pos.movePosition(-1, -1);
                break;
            }
            case 7 : { 
                System.out.println("move -> left");
                pos.movePosition(-1, 0);
                break;
            }
            case 8 : { 
                System.out.println("move -> upleft");
                pos.movePosition(-1, 1);
                break;
            }
        }

    }

    public void runGeneticcode(List<Virus> listVirus,List<Antibody> listAntibody) throws SyntaxError, FileNotFoundException{
        FileReader f = new FileReader(filename);
        Scanner reader = new Scanner(f);
        StringBuilder all = new StringBuilder();
        while (reader.hasNextLine()){
            all.append(reader.nextLine());
            all.append("\n");
        }
        Expressionparse exp = new Expressionparse(all.toString(), this , allVariable, listVirus, listAntibody);
        Node parseExp = exp.parse();
        parseExp.evaluate();
 
    }
    
}
