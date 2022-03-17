package com.booboo.CAREN.Model;

public class Shop {
    
   private int balance;
    private static Shop instance;
//    private Field field = Field.getInstance();
    private Characterfactory fac = new Characterfactory();

    private Shop(){
        this.balance = 200;
    }

    public static Shop getInsShop()
    {
        if (instance == null)
        {
            instance = new Shop();
        }
        return instance;
    }


    public void buyAnti(String type, int newPos) {
        System.out.println("Hi");
        int posY = newPos % 15;
        if (posY == 0) {
            posY = 15;
        }
        int posX = ((newPos - posY) / 15) + 1;
        if (type.equals("A")&& balance>=30) {
            fac.createAntibodyA(posX, posY);
            balance -= 30;
        } else if (type.equals("B")&& balance>=50) {
            fac.createAntibodyB(posX, posY);
            balance -= 50;
        } else if (type.equals("C")&& balance>=80) {
            fac.createAntibodyC(posX, posY);
            balance -= 80;
        }
    }

    public int getMoney(){
        return balance;
    }

    public void moveCost(int cost){
        balance -= cost;
    }

    public void virusDead(int credit){
        balance += credit;
        if(credit == 0){
            fac.createVirus();
        }
    }

    public void reBalance(){
        balance = 200;
    }
        

}
