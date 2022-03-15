package com.booboo.CAREN.Model;

import com.booboo.CAREN.Parser.SyntaxError;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.List;

public class Gameplay {
  public static void main(String[] args) throws FileNotFoundException, SyntaxError {
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

    //ช่วงเริ่มเกมส์ 10
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
   
    // };
    // timer.scheduleAtFixedRate(task, 0, 2000);

    do{
        fac.createVirus();
      try {
        for(Gamecharacter g : listV)
            g.runGeneticcode();
      } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (SyntaxError e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }while(listA.isEmpty());
    
    if(!listA.isEmpty()){
      do{
        fac.createVirus();
      try {
        for(Gamecharacter g : listV)
            g.runGeneticcode();
      } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (SyntaxError e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      if(listA.isEmpty()||listV.isEmpty()) endState = true;
      }while(endState==false);
    }


  
  }

}
