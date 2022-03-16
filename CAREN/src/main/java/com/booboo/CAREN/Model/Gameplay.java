package com.booboo.CAREN.Model;

import com.booboo.CAREN.Controller.Button;
import com.booboo.CAREN.Parser.SyntaxError;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.List;

public class Gameplay {

  public void startGame() throws InterruptedException{
    boolean endState = false;
    Field field = Field.getInstance();
    Characterfactory fac = new Characterfactory();
    //สมมุติว่าตรงนี้กำหนด10วิ ก่อนที่จะเริ่มเช็คว่าในfield ยังมี antibody or virus อยู่รึเปล่า
    Virus_X x = new Virus_X(5, 5);
    field.addVirus(x);
     Antibody_A a = new Antibody_A(5, 4);
     field.addAntibody(a);
    List<Virus> listV = field.getListVirus();
    List<Antibody> listA = field.getListAntibody();
    List<Gamecharacter> allChar = field.getAllChar();
    Button btn_speedUp = new Button("speedUp");

    while(endState==false){
      int sp;
      Time time = new Time();
      if(listV.isEmpty()) endState = true;
      if(btn_speedUp.speedUpBtn(true)){
        sp = time.getSpeed();
      }
      
      System.out.println("now sec is: "+time.getcurrTime());
      //fac.createVirus();
      try {
        for(Gamecharacter g : allChar)
            g.runGeneticcode();
      } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (SyntaxError e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      System.out.println("===============================================");
      // int speed = sp * 1000;
      Thread.sleep(5000);
    }
  }
  
  public static void main(String[] args) throws FileNotFoundException, SyntaxError, InterruptedException {
    // boolean endState = false;
    // Field field = Field.getInstance();
    // Characterfactory fac = new Characterfactory();
    // //สมมุติว่าตรงนี้กำหนด10วิ ก่อนที่จะเริ่มเช็คว่าในfield ยังมี antibody or virus อยู่รึเปล่า
    // Virus_X x = new Virus_X(5, 5);
    // field.addVirus(x);
    // Antibody_A a = new Antibody_A(5, 4);
    // field.addAntibody(a);
    // List<Virus> listV = field.getListVirus();
    // List<Antibody> listA = field.getListAntibody();
    // Button btn_speedUp = new Button("speedUp");

    // while(endState==false){
    //   int sp;
    //   Time time = new Time();
    //   if(listA.isEmpty()||listV.isEmpty()) endState = true;
    //   if(btn_speedUp.speedUpBtn(true)){
    //     sp = time.getSpeed();
    //   }
      
    //   System.out.println("curr time: "+time.getcurrTime());
    //   fac.createVirus();
    //   try {
    //     for(Gamecharacter g : listV)
    //         g.runGeneticcode();
    //   } catch (FileNotFoundException e) {
    //     // TODO Auto-generated catch block
    //     e.printStackTrace();
    //   } catch (SyntaxError e) {
    //     // TODO Auto-generated catch block
    //     e.printStackTrace();
    //   }
    //   // System.out.println("now speed level is "+t.getSpeed());
    //   System.out.println("===============================================");
    //   int speed = sp * 1000;
    //   Thread.sleep(sp*1000);
    // }
    Gameplay gameplay = new Gameplay();
    gameplay.startGame();


  
  }

}
