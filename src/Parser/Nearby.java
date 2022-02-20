package Parser;

import java.util.List;

import Model.Antibody;
import Model.Gamecharacter;
import Model.Virus;

public class Nearby implements Node{

    private Node direct;
    private Gamecharacter host;
    private List<Virus> listVirus;
    private List<Antibody> listAntibody;

    Nearby(Node direct, Gamecharacter host, List<Virus> listVirus, List<Antibody> listAntibody){
        this.direct = direct;
        this.host = host;
        this.listVirus = listVirus;
        this.listAntibody = listAntibody;
    }

    @Override
    public double evaluate() throws SyntaxError {
        int min = Integer.MAX_VALUE;
        for(Virus v : listVirus){
            int newmin = findLocation(host.getPos().PosX(), host.getPos().PosY(), v.getPos().PosX(), v.getPos().PosY());
            if(newmin < min && newmin%10 == direct.evaluate())
                min = newmin;
        }

        for(Antibody a : listAntibody){
            int newmin = findLocation(host.getPos().PosX(), host.getPos().PosY(), a.getPos().PosX(), a.getPos().PosY());
            if(newmin < min && newmin%10 == direct.evaluate())
                min = newmin;
        }

        if(min == Integer.MAX_VALUE)
            return 0;
            
        return min;
    }
    
    public int findLocation(int hostX,int hostY,int targetX, int targetY){
        int diffY = hostY - targetY;
        // locate 6-7-8
        if(diffY > 0){
            // locate 6
            if( hostX < targetX && targetX - hostX == hostY - targetY )
                return ( targetX - hostX )*10 + 6;
            // locate 8
            if(  hostX > targetX && hostX - targetX == hostY - targetY )
                return ( hostX - targetX )*10 + 8;
            // locate 7
            if( hostX == targetX )
                return ( hostY - targetY )*10 + 7;
        }
        // locate 2,3,4
        else if(diffY < 0){
            // local 4
            if( hostX < targetX && targetX - hostX == targetY - hostY )
                return ( targetX - hostX )*10 + 4;
            // locate 2
            if(  hostX > targetX && hostX - targetX == targetY - hostY)
                return ( hostX - targetX )*10 + 2;
            // locate 3
            if( hostX == targetX )
                return ( targetY - hostY ) * 10 + 3;
        }
        // locate 1,5
        else{
            if( hostX > targetX )
                return ( hostX - targetX )*10 + 1;
            else
                return ( targetX - hostX )*10 + 5;

        }
        return Integer.MAX_VALUE;
    }
}