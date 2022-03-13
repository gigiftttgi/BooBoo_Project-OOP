package com.booboo.CAREN.Model;

public class Shop {
    
   private int balance ;
    private static Shop instance;
<<<<<<< HEAD
    private Field field = Field.getInstance();
    private Characterfactory facAnti = new Characterfactory();
=======
    protected int px;
    protected int py;
>>>>>>> d7ffa376cf1268c0272f79a7818e3f7327cf8e6b

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

    public void buyAntiA(){
<<<<<<< HEAD
        if(this.balance >= 20 ){    
=======
        if(balance>=20 ){
            Characterfactory facAnti = new Characterfactory();
            facAnti.createAntibody("A",px,py);
>>>>>>> d7ffa376cf1268c0272f79a7818e3f7327cf8e6b
            this.balance -=20;
            System.out.println("your balance is " + this.balance);
            field.addAntibody(facAnti.createAntibody("A"));
        }else{
            System.out.println("you dont have enough money");
        }
    }

    public void buyAntiB(){
<<<<<<< HEAD
        if(this.balance>=50 ){
=======
        if(balance>=50 ){
            Characterfactory facAnti = new Characterfactory();
            
            facAnti.createAntibody("B",px,py);
>>>>>>> d7ffa376cf1268c0272f79a7818e3f7327cf8e6b
            this.balance -=50;
            System.out.println("your balance is "+ this.balance);
            field.addAntibody(facAnti.createAntibody("B"));
        }else{
            System.out.println("you dont have enough money");
        }
    }

    public void buyAntiC(){
<<<<<<< HEAD
        if(this.balance>=50){
=======
        if(balance>=50){
            Characterfactory facAnti = new Characterfactory();
            facAnti.createAntibody("C",px,py);
>>>>>>> d7ffa376cf1268c0272f79a7818e3f7327cf8e6b
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
