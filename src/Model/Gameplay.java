package Model;

import Parser.SyntaxError;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class Gameplay {
  
  public static void main(String[] args) throws FileNotFoundException, SyntaxError {
    Field field = new Field();
    for(int i=0 ;i<1 ;i++){
      field.creatVirus();
    }   
    for(Virus v : field.getListVirus()){
        System.out.println(v.getClass());
        v.runGeneticcode(field.getListVirus(),field.getListAntibosy());
        System.out.println("-------------------------------------------------");
    }

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
    
  }
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
