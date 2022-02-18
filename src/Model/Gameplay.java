package Model;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

import Parser.SyntaxError;

public class Gameplay {

  public static void main(String[] args) throws FileNotFoundException, SyntaxError{
      Field field = new Field();
      field.creatVirus();
      for(Virus v : field.getListVirus()){
          System.out.println(v.getClass());
          v.runGeneticcode(field.getListVirus(),field.getListAntibosy());
      }
  }
    

//     // Test creat with time
//   //     Timer timer = new Timer();
//   //     TimerTask task = new TimerTask() {
//   //     int counter = 0;

//   //     @Override
//   //     public void run() {
//   //       if (counter < 20) {
//   //         counter++; 
//   //         Time t = new Time();
//   //         Characterfactory fac = new Characterfactory();
//   //         System.out.println("second pass: "+t.getcurrTime());
//   //         fac.createVirus(t.getcurrTime(), 3);
//   //       } else {
//   //         timer.cancel();
//   //       }
//   //     }
//   //   };
//   //   timer.scheduleAtFixedRate(task, 0, 1000);
// }
}
