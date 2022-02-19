package Model;

import java.io.FileNotFoundException;

import Controller.Button;
import Parser.SyntaxError;

public class Test_model {
    // public static void main(String[] args) throws FileNotFoundException, SyntaxError {
    //     Characterfactory factory = new Characterfactory();
    //     factory.
    //     a.pos = new Position(3, 4);
    //     a.runGeneticcode();
    //     System.out.println(a.pos.getX_Position() + " " + a.pos.getY_Position());
    // }

    //test Shop.java
    public static void main(String[] args) {
        //press the button
        Button btnA = new Button("Buy Antibody A");
        Button btnB = new Button("Buy Antibody B");
        
       Shop shop = new Shop();
       System.out.println("Player start money is "+shop.balance);
       shop.buyAntiA("A", btnA.buyAntiA_btn());
       shop.buyAntiA("A", btnA.buyAntiA_btn());
       shop.buyAntiB("B", btnB.buyAntiB_btn());
       shop.buyAntiB("B", btnB.buyAntiB_btn());
       System.out.println("Your final balance is "+shop.balance);

    }
}
