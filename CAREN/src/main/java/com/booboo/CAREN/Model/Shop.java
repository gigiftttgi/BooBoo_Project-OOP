package com.booboo.CAREN.Model;

public class Shop {
    
   private int balance,px,py ;
    private static Shop instance;
    private Field field = Field.getInstance();
    private Characterfactory facAnti = new Characterfactory();

    private Shop(){
        this.balance = 100;
    }

    public static Shop getInsShop()
    {
        if (instance == null)
        {
            instance = new Shop();
        }
        return instance;
    }

    public void getWebPos(int x,int y){
        px = x;
        py = y;
      }

    public void buyAntiA(int posx, int posy){
        if(this.balance >= 20 ){    
            this.balance -=20;
            System.out.println("your balance is " + this.balance);
            field.addAntibody(facAnti.createAntibodyA(posx, posy));
        }else{
            System.out.println("you dont have enough money");
        }
    }

    public void buyAntiB(int posx, int posy){
        if(this.balance>=50 ){
            this.balance -=50;
            System.out.println("your balance is "+ this.balance);
            field.addAntibody(facAnti.createAntibodyB(posx, posy));
        }else{
            System.out.println("you dont have enough money");
        }
    }

    public void buyAntiC(int posx, int posy){
        if(this.balance>=50){
            this.balance -=50;
            System.out.println("your balance is "+ this.balance);
            field.addAntibody(facAnti.createAntibodyC(posx, posy));
        }else{
            System.out.println("you dont have enough money");
        }
    }

    public int getMoney(){
        return balance;
    }
        

}
