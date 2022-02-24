package com.booboo.CAREN.Model;

import javax.sql.rowset.spi.SyncResolver;

import com.booboo.CAREN.Controller.Button;

public class Shop {
    
    protected int balance ;
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
        if(balance >= 20 ){
            //Characterfactory facAnti = new Characterfactory();
            //Antibody a = facAnti.createAntibody("A");
            this.balance -=20;
            System.out.println("your balance is " + this.balance);
            field.addAntibody(facAnti.createAntibody("A"));
        }else{
            System.out.println("you dont have enough money");
        }
    }

    public void buyAntiB(){
        if(balance>=50 ){
            //Characterfactory facAnti = new Characterfactory();
            //facAnti.createAntibody("B");
            this.balance -=50;
            System.out.println("your balance is "+ this.balance);
            field.addAntibody(facAnti.createAntibody("B"));
        }else{
            System.out.println("you dont have enough money");
        }
    }

    public void buyAntiC(){
        if(balance>=50){
            //Characterfactory facAnti = new Characterfactory();
            //facAnti.createAntibody("C");
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
