package com.booboo.CAREN.Model;

import com.booboo.CAREN.Parser.SyntaxError;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

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
  
  public static void main(String[] args) throws FileNotFoundException, SyntaxError {
    Field field = Field.getInstance();
    Virus_X x = new Virus_X(5, 5);
    field.addVirus(x);
    // Virus_Y y = new Virus_Y(12, 15);
    // field.addVirus(y);
    // field.addVirus(new Virus_Z(20, 19));
    // field.addVirus(new Virus_X(30, 10));

    Antibody_A a = new Antibody_A(5, 4);
    field.addAntibody(a);
    // Antibody_B b = new Antibody_B(12, 16);
    // field.addAntibody(b);
    // field.addAntibody(new Antibody_C(20, 22));
    // field.addAntibody(new Antibody_A(25, 14));

    System.out.println("Antibody list : "+field.getListAntibody());
    System.out.println("Virus list : "+field.getListVirus());

    System.out.println("bf x Hp = " + x.getHP());
    System.out.println("bf a Hp = " + a.getHP());
    System.out.println("-----------------------------");
    System.out.println("Virus pos : " + x.getPos().PosX()+""+x.getPos().PosY());
    x.runGeneticcode();
    System.out.println("-----------------------------");
    System.out.println("Antibody pos : " + a.getPos().PosX()+""+a.getPos().PosY());
    a.runGeneticcode();
    System.out.println("-----------------------------");
    System.out.println("af x Hp = " + x.getHP());
    System.out.println("af a Hp = " + a.getHP());
    // do{



    // }while(field.getListVirus().isEmpty());
  }

    // Virus_X x = new Virus_X(10, 10);
    // System.out.println(x.getPos().PosX() + " " + x.getPos().PosY());
    // x.runGeneticcode(field.getListVirus(),field.getListAntibosy());
    // System.out.println(x.getPos().PosX() + " " + x.getPos().PosY());

    //test create virus with time (เกิดไม่ซ้ำกัน)
    // Field field = new Field();
    // Timer timer = new Timer();
    // TimerTask task = new TimerTask() {
    // int counter = 0;

    //   @Override
    //   public void run() {
    //     if (counter < 30) {
    //       counter++;
    //       Time t = new Time();
          
    //       field.creatVirus();
    //       // System.out.println("second pass: " + t.getcurrTime());
    //       System.out.println("-----------------------------------------------");
    //     } else {
    //       timer.cancel();
    //     }
    //   }
    // };
    // timer.scheduleAtFixedRate(task, 0, 1000);
    
  // }
}
// Test creat with time
//     Timer timer = new Timer();
//     TimerTask task = new TimerTask() {
//     int counter = 0;
//     @Override
//     public void run() {
//       if (counter < 20) {
//         counter++;
//         Time t = new Time();
//         Characterfactory fac = new Characterfactory();
//         System.out.println("second pass: "+t.getcurrTime());
//         fac.createVirus(t.getcurrTime(), 3);
//       } else {
//         timer.cancel();
//       }
//     }
//   };
//   timer.scheduleAtFixedRate(task, 0, 1000);
