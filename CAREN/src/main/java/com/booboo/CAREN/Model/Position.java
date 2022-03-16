package com.booboo.CAREN.Model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Position {

    protected int x;
    protected int y;

    public Position(int x,int y){
        if(x > 10){
           this.x = 10; 
        }
        else if(x < 1){
            this.x = 1;
        }
        else{
            this.x = x;
        }

        if(y > 15){
            this.y = 15; 
         }
         else if(y < 1){
            this.y = 1;
        }
         else{
             this.y = y;
         }
    }

    // public void movePosition(int moveX,int moveY){
    //     x+=moveX;
    //     y+=moveY;
    // }

    public int PosX(){
        return x;
    }

    public int PosY(){
        return y;
    }

    public boolean equalPos(Position target){
        if( x == target.PosX() && y == target.PosY())
            return true;
        return false;
    }
    
    
}
