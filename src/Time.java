public class Time {
    private int currtime;

    public Time(){
        currtime = (int) System.currentTimeMillis();

    }

    public void speedUP(){
        currtime = currtime*2;
    }

    public void speedDown(){
        currtime = currtime*-2;
    }

    public void pause(){
        int pauseTime = currtime;
        currtime = pauseTime;
    }
    public int getcurrTime(){
        return currtime;
    }
    
}
