package Model;
public class Position {

    protected int x;
    protected int y;

    public Position(int x,int y){
        this.x = x;
        this.y = y;
    }

    public void movePosition(int moveX,int moveY){
        x+=moveX;
        y+=moveY;
    }

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
