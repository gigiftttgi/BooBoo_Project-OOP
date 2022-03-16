package com.booboo.CAREN.Model;

import com.booboo.CAREN.Controller.Button;
import com.booboo.CAREN.Parser.SyntaxError;
import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.List;

public class Gameplay {

  // public void pauseGame() throws InterruptedException{
  //   synchronized (this){
  //     System.out.println("Going to wait");
  //     wait();
  //     System.out.println("Resume");
  //   }
  // }

  // public void resumeGame(boolean pauseState) throws InterruptedException{

  //   System.out.println("Pause");
  //   Thread.sleep(5000);
  //   synchronized (this){
  //     if (pauseState==true){
  //       notify();
  //     }
  //   }
  // }

  // public Thread createThread_pause(){
  //   Thread t_pause = new Thread(new Runnable() {
  //     @SneakyThrows
  //     @Override
  //     public void run() {
  //       // pauseGame();
  //     }
  //   });
  //   return t_pause;
  // }

  // public Thread createThread_resume(){
  //   Thread t_resume = new Thread(new Runnable() {
  //     @SneakyThrows
  //     @Override
  //     public void run() {
  //       // resumeGame(true);
  //     }
  //   });
  //   return t_resume;
  // }

  // public void runThread() throws InterruptedException {
  //   Thread tr1 = createThread_pause();
  //   Thread tr2 = createThread_resume();
  //   tr1.start();
  //   tr2.start();

  //   tr1.join();
  //   tr2.join();

  // }

  public void startGame() throws InterruptedException{
    boolean endState = false;
    // boolean isPause = false;
    Field field = Field.getInstance();
    Characterfactory fac = new Characterfactory();
    //สมมุติว่าตรงนี้กำหนด10วิ ก่อนที่จะเริ่มเช็คว่าในfield ยังมี antibody or virus อยู่รึเปล่า
    Virus_X x = new Virus_X(5, 5);
    field.addVirus(x);
    Antibody_A a = new Antibody_A(5, 4);
    field.addAntibody(a);
    Antibody_B b = new Antibody_B(5, 6);
    field.addAntibody(b);
    List<Virus> listV = field.getListVirus();
    List<Antibody> listA = field.getListAntibody();
    Button btn_speedUp = new Button("speedUp");
    Button btn_speedDown = new Button("speedDown");
    Button btn_pause = new Button("pause");

    //ครั้งแรกเท่านั้น เพราะอยู่นอกลูป
    btn_pause.setPauseState(true);
    while(endState==false){
      int sp = 2;
      Time time = new Time();
      if(listA.isEmpty()||listV.isEmpty()) endState = true;
      if(btn_speedUp.speedUpBtn()){
        System.out.println("jjjjjj");
        sp = time.getSpeed();
      }else if(btn_speedDown.speedDownBtn()){
        sp = time.getSpeed();
      }else if(btn_pause.pauseBtn()){
        // runThread();
//        isPause = true;
//        System.out.println("Pause status: "+isPause);
      }

      System.out.println("now sec is: "+time.getcurrTime());
      // fac.createVirus();
      try {
        for(Gamecharacter g : field.getAllChar())
          g.runGeneticcode();
      } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (SyntaxError e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      System.out.println("===============================================");

//      if (isPause==true ) {
//        runThread();
//      }else{
//        Thread.sleep(sp*1000);
//      }
      Thread.sleep(sp*1000);

    }
  }
  
  public static void main(String[] args) throws FileNotFoundException, SyntaxError, InterruptedException {
    Gameplay gameplay = new Gameplay();
    gameplay.startGame();
  }

}
