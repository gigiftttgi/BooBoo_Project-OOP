package com.booboo.CAREN.Model;

public class Shop {
    
   private int balance ;
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


    public void buyAntiA(){
        if(this.balance >= 20 ){    
            this.balance -=20;
            System.out.println("your balance is " + this.balance);
            field.addAntibody(facAnti.createAntibody("A"));
        }else{
            System.out.println("you dont have enough money");
        }
    }

    public void buyAntiB(){
        if(this.balance>=50 ){
            this.balance -=50;
            System.out.println("your balance is "+ this.balance);
            field.addAntibody(facAnti.createAntibody("B"));
        }else{
            System.out.println("you dont have enough money");
        }
    }

    public void buyAntiC(){
        if(this.balance>=50){
            this.balance -=50;
            System.out.println("your balance is "+ this.balance);
            field.addAntibody(facAnti.createAntibody("C"));
        }else{
            System.out.println("you dont have enough money");
        }
    }

    public int getMoney(){
        return balance;
    }
        

}
