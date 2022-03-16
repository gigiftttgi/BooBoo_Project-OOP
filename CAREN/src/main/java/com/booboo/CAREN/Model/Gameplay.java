package com.booboo.CAREN.Model;

import com.booboo.CAREN.Parser.SyntaxError;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.List;

public class Gameplay {
  public static void main(String[] args) throws FileNotFoundException, SyntaxError, InterruptedException {
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
    Time t = new Time();
    t.speedDown();

    while(endState==false){
      if(listA.isEmpty()||listV.isEmpty()) endState = true;
      Time time = new Time();
      System.out.println("curr time: "+time.getcurrTime());
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
      System.out.println("now speed level is "+t.getSpeed());
      System.out.println("===============================================");
      Thread.sleep(t.getSpeed()*1000);
    }


  
  }

}
