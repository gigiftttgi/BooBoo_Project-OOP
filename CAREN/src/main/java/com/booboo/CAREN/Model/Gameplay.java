package com.booboo.CAREN.Model;

import com.booboo.CAREN.Parser.SyntaxError;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.List;

public class Gameplay {

  // Field field = new Field();
  // private static Gameplay instance;
  // private Gameplay(){

  // }

  // public static Gameplay getInsGameplay()
  //   {
  //       if (instance == null)
  //       {
  //           instance = new Gameplay();
  //       }
  //       return instance;
  //   }

  // Virus_X x = new Virus_X(10, 10);

  // Virus_X x = new Virus_X(5, 5);
  // field.addVirus(x);
  // Antibody_A a = new Antibody_A(5, 4);
  // field.addAntibody(a);

  // Timer timer = new Timer();
  // TimerTask task = new TimerTask(){
  // int counter = 0;
  // @Override
  // public void run() {
  //   if (counter < 10) {
  //     counter++;
  //     Time t = new Time();
  //     System.out.println("second pass: "+t.getcurrTime());
  //     Virus v = fac.createVirus();
  //     try {
  //       v.runGeneticcode();
  //     } catch (FileNotFoundException e) {
  //       // TODO Auto-generated catch block
  //       e.printStackTrace();
  //     } catch (SyntaxError e) {
  //       // TODO Auto-generated catch block
  //       e.printStackTrace();
  //     }
  //   } else {
  //     timer.cancel();
  //   }
  // }

  public static void main(String[] args) throws FileNotFoundException, SyntaxError {
    //Set up
    Time time = new Time();
    boolean endState = false;
    Field field = Field.getInstance();
    Characterfactory fac = new Characterfactory();
    List<Virus> listV = field.getListVirus();
    List<Antibody> listA = field.getListAntibody();

    Virus_X x = new Virus_X(5, 5);
    field.addVirus(x);
    Antibody_A a = new Antibody_A(5, 4);
    field.addAntibody(a);

    // ช่วงเริ่มเกมส์ 10
    do{
      System.out.println("There's no antibody");
      Virus v = fac.createVirus();
      try {
        v.runGeneticcode();
      } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (SyntaxError e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }while(listA.isEmpty());

    System.out.println("there is antibody in the field");

    //there is antibody in the field
    Timer timer = new Timer();
    TimerTask task = new TimerTask(){
    @Override
    public void run() {
      Time t = new Time();
      System.out.println("second pass: "+t.getcurrTime());
      Virus v = fac.createVirus();
      try {
         v.runGeneticcode();
      } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (SyntaxError e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
   
  };
  timer.scheduleAtFixedRate(task, 0, 2000);

  
  



  }
}

    













    // Virus_Y y = new Virus_Y(12, 15);
    // field.addVirus(y);
    // field.addVirus(new Virus_Z(20, 19));
    // field.addVirus(new Virus_X(30, 10));


    // Antibody_B b = new Antibody_B(12, 16);
    // field.addAntibody(b);
    // field.addAntibody(new Antibody_C(20, 22));
    // field.addAntibody(new Antibody_A(25, 14));

    // System.out.println("Antibody list : "+field.getListAntibody());
    // System.out.println("Virus list : "+field.getListVirus());

    // System.out.println("bf x Hp = " + x.getHP());
    // System.out.println("bf a Hp = " + a.getHP());
    // System.out.println("-----------------------------");
    // System.out.println("Virus pos : " + x.getPos().PosX()+""+x.getPos().PosY());
    // x.runGeneticcode();
    // System.out.println("-----------------------------");
    // System.out.println("Antibody pos : " + a.getPos().PosX()+""+a.getPos().PosY());
    // a.runGeneticcode();
    // System.out.println("-----------------------------");
    // System.out.println("af x Hp = " + x.getHP());
    // System.out.println("af a Hp = " + a.getHP());
    // do{



    // }while(field.getListVirus().isEmpty());
  

    // Virus_X x = new Virus_X(10, 10);
    // System.out.println(x.getPos().PosX() + " " + x.getPos().PosY());
    // x.runGeneticcode(field.getListVirus(),field.getListAntibosy());
    // System.out.println(x.getPos().PosX() + " " + x.getPos().PosY());

    
    
  // }


