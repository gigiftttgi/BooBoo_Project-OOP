package Controller;

import Model.Time;

public class Button {

    private boolean state;
    private String type;

    public Button(String type){
        this.type = type;
    }

    public void pauseBtn(boolean state){
        if(state == false || !type.equals("pause")){
            System.out.println("Button type isn't pause");

        }else{
            Time t = new Time();
            t.pause();
        }
    }

    public void speedUpBtn(boolean state){
        if(state == false || !type.equals("speedUp")){
            System.out.println("Button type isn't speedUp");
        }else {
            Time t = new Time();
            t.speedUP();

        }
    }

    public void speedDownBtn(boolean state){
        if(state == false || !type.equals("speedDown")){
            System.out.println("Button type isn't speedDown");
        }else{
            Time t = new Time();
            t.speedDown();

        }
    }

    public void zoomInBtn(boolean state){
        if(state == false || !type.equals("zoomIn")){
            System.out.println("Button type isn't zoomIn");
        }else{
            //Wait for zoom design

        }
    }

    public void zoomOutBtn(boolean state){
        if(state == false || !type.equals("zoomOut")){
            System.out.println("Button type isn't zoomOut");
        }else{
            //Wait for zoom design

        }
    }

}
