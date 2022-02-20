package Model;

import java.util.Random;

public class Random_int {

    protected Random r;
    protected int upperbound;

    public Random_int(int upperbound){
        this.r = new Random();
        this.upperbound = upperbound;
    }

    public int randomInt(){
        return r.nextInt(upperbound);
    }
    
}
