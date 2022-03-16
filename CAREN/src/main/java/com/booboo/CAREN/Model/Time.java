package com.booboo.CAREN.Model;

import java.time.LocalDateTime;


public class Time {

  private int currtime;
  private int speed;

  public Time() {
    currtime = LocalDateTime.now().getSecond();
  }

  public void speedUP() {
    speed = 1;
  }

  public void speedDown() {
    speed = 3;
  }

  public int getSpeed(){
    return speed;
  }

  public void pause() {
    int pauseTime = currtime;
    currtime = pauseTime;
  }

  public int getcurrTime() {
    return currtime;
  }

}
