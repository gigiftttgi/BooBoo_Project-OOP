package com.booboo.CAREN.Model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import com.booboo.CAREN.Parser.GenaticParse;
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
    private Field field = Field.getInstance();
    private Random_int r = new Random_int(3);
    private Shop shop = Shop.getInsShop();

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

    public Map<String,Integer> getAllVar(){
        return allVariable;
    }

    public void attackedBy(Gamecharacter attacker){
        hp = hp - attacker.getATK();
        if(hp <=0 ){
            shop.virusDead(field.charDie(this));
        }
    }

    public void move(int direction){
        int oldposX = pos.PosX();
        int oldposY = pos.PosY();
        System.out.println("Old pos x : "+ oldposX + " , y : "+ oldposY);
        switch(direction){
            case  1 : { 
                System.out.println("move -> up");
                this.pos = new Position(oldposX-1, oldposY);
                System.out.println("New pos x : "+pos.PosX() + " , y : "+ pos.PosY());
                break;
            }
            case 2 : { 
                System.out.println("move -> upright");
                this.pos = new Position(oldposX-1, oldposY+1);
                System.out.println("pos x : "+pos.PosX() + " ,pos y : "+ pos.PosY());
                break;
            }
            case 3 : { 
                System.out.println("move -> right");
                this.pos = new Position(oldposX, oldposY+1);
                System.out.println("pos x : "+pos.PosX() + " ,pos y : "+ pos.PosY());
                break;
            }
            case 4 : { 
                System.out.println("move -> downright");    
                this.pos = new Position(oldposX+1, oldposY+1);  
                System.out.println("pos x : "+pos.PosX() + " ,pos y : "+ pos.PosY());          
                break;
            }
            case 5 : { 
                System.out.println("move -> down");
                this.pos = new Position(oldposX+1, oldposY);
                System.out.println("pos x : "+pos.PosX() + " ,pos y : "+ pos.PosY());
                break;
            }
            case 6: { 
                System.out.println("move -> downleft");
                this.pos = new Position(oldposX+1, oldposY-1);
                System.out.println("pos x : "+pos.PosX() + " ,pos y : "+ pos.PosY());
                break;
            }
            case 7 : { 
                System.out.println("move -> left");
                this.pos = new Position(oldposX, oldposY-1);
                System.out.println("pos x : "+pos.PosX() + " ,pos y : "+ pos.PosY());
                break;
            }
            case 8 : { 
                System.out.println("move -> upleft");
                this.pos = new Position(oldposX-1, oldposY-1);
                System.out.println("pos x : "+ pos.PosX() + " ,pos y : "+ pos.PosY());
                break;
            }
        }

    }

    public void runGeneticcode() throws SyntaxError, FileNotFoundException{
        FileReader f = new FileReader(filename);
        Scanner reader = new Scanner(f);
        StringBuilder all = new StringBuilder();
        while (reader.hasNextLine()){
            all.append(reader.nextLine());
            all.append("\n");
        }
        GenaticParse exp = new GenaticParse(all.toString(), this);
        Node parseExp = exp.parse();
        parseExp.evaluate();
 
    }
    
}
