package Model;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class Time {

  private int currtime;

  public Time() {
    currtime = LocalDateTime.now().getSecond();
  }

  public void speedUP() {
    currtime = currtime * 2;
  }

  public void speedDown() {
    currtime = currtime * -2;
  }

  public void pause() {
    int pauseTime = currtime;
    currtime = pauseTime;
  }

  public int getcurrTime() {
    return currtime;
  }

}
