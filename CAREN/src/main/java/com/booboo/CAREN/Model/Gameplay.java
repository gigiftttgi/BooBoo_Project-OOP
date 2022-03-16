package com.booboo.CAREN.Model;

//import com.booboo.CAREN.Controller.Button;
import com.booboo.CAREN.Parser.SyntaxError;
import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.List;

public class Gameplay {

  public void pauseGame() throws InterruptedException{
    System.out.println("pauseGame");
    synchronized (this){
      System.out.println("Going to wait");
      wait();
      System.out.println("Resume");
    }
  }

  public void resumeGame(boolean state) throws InterruptedException{
    System.out.println("resumeGame");
    System.out.println("Pause");
    pNum = 0;
//    Thread.sleep(5000);
    synchronized (this){

      if (state==true){
        notify();
      }
    }
  }

  boolean btn_speedUp = false;
  boolean btn_speedDown = false;
  boolean btn_pause = false;
  boolean rsm = false;
  int pNum = 0;

  public void setPauseState(boolean state){
    System.out.println("setPauseState");
    btn_pause = state;
    pNum = 1;
  }

  public void setSpeedUpState(boolean state){
    btn_speedUp = state;
  }

  public void setSpeedDownState(boolean state){
    btn_speedDown = state;
  }


  public Thread createThread_pause(){
    System.out.println("createPauseT");
    Thread t_pause = new Thread(new Runnable() {
      @SneakyThrows
      @Override
      public void run() {
        pauseGame();
      }
    });
    return t_pause;
  }

//  Button pBtn = new Button("pause");
  public Thread createThread_resume(){
    System.out.println("createResumeT");
    Thread t_resume = new Thread(new Runnable() {
      @SneakyThrows
      @Override
      public void run() {
//        System.out.println("run p" + pBtn.getPauseState());
        resumeGame(rsm);
      }
    });
    return t_resume;
  }

  public void runThread() throws InterruptedException {
    System.out.println("runT");
    Thread tr1 = createThread_pause();
    Thread tr2 = createThread_resume();
    tr1.start();
    tr2.start();

    tr1.join();
    tr2.join();

  }


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
//    Button btn_speedUp = new Button("speedUp");
//    Button btn_speedDown = new Button("speedDown");
//    Button btn_pause = new Button("pause");

    //ครั้งแรกเท่านั้น เพราะอยู่นอกลูป
//    btn_pause.setPauseState(true);
    while(endState==false){
      int sp = 2;
      Time time = new Time();
      if(listA.isEmpty()||listV.isEmpty()) endState = true;
      if(btn_speedUp){
        System.out.println("jjjjjj");
        sp = time.getSpeed();
      }else if(btn_speedDown){
        sp = time.getSpeed();
      }else if(btn_pause && pNum==1){
        runThread();
//        isPause = true;
//        System.out.println("Pause status: "+isPause);
      }

      System.out.println("now sec is: "+time.getcurrTime());
      // fac.createVirus();
      try {
//        for(Gamecharacter g : field.getAllChar())
//          g.runGeneticcode();
        for(int i = 0; i < field.getAllChar().size() ; i++){
          Gamecharacter g = field.getAllChar().get(i);
          g.runGeneticcode();
        }
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
