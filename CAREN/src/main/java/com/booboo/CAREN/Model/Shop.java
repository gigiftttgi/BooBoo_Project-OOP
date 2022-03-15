package com.booboo.CAREN.Model;

public class Shop {
    
   private int balance;
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


    public void buyAntiA(int posx, int posy){
        if(this.balance >= 20 ){    
            this.balance -=20;
            System.out.println("your balance is " + this.balance);

//            field.addAntibody(facAnti.createAntibodyA(1,1));
            facAnti.createAntibodyA(posx, posy);

        }else{
            System.out.println("you dont have enough money");
        }
    }

    public void buyAntiB(int posx, int posy){
        if(this.balance>=50 ){
            this.balance -=50;
            System.out.println("your balance is "+ this.balance);

//             field.addAntibody(facAnti.createAntibodyB(1,1));

            facAnti.createAntibodyB(posx, posy);

        }else{
            System.out.println("you dont have enough money");
        }
    }

    public void buyAntiC(int posx, int posy){
        if(this.balance>=50){
            this.balance -=50;
            System.out.println("your balance is "+ this.balance);

            facAnti.createAntibodyC(posx, posy);

//            field.addAntibody(facAnti.createAntibodyC(1,1));

           

        }else{
            System.out.println("you dont have enough money");
        }
    }

    public int getMoney(){
        return balance;
    }
        

}
