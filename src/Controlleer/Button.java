package Controlleer;

import Model.Time;

public class Button {

    private boolean state;

    public void pauseBtn(boolean state){
        //If button doesn't onclick, do nothing
        if(state == false){

        }else{
            Time t = new Time();
            t.pause();
        }
    }

    public void speedUpBtn(boolean state){
        if(state == false){

        }else {
            Time t = new Time();
            t.speedUP();

        }
    }

    public void speedDownBtn(boolean state){
        if(state == false){

        }else{
            Time t = new Time();
            t.speedDown();

        }
    }

    public void zoomInBtn(boolean state){
        if(state == false){

        }else{
            //Wait for zoom design

        }
    }

    public void zoomOutBtn(boolean state){
        if(state == false){

        }else{
            //Wait for zoom design

        }
    }
    
}
