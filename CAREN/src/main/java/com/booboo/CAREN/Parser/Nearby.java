package com.booboo.CAREN.Parser;

import java.util.List;

import com.booboo.CAREN.Model.Antibody;
import com.booboo.CAREN.Model.Field;
import com.booboo.CAREN.Model.Gamecharacter;
import com.booboo.CAREN.Model.Virus;

public class Nearby implements Node{

    private Node direct;
    private Gamecharacter host;
    private List<Virus> listVirus;
    private List<Antibody> listAntibody;
    private Field field = Field.getInstance();


    Nearby(Node direct, Gamecharacter host){
        this.direct = direct;
        this.host = host;
        this.listVirus = field.getListVirus();
        this.listAntibody = field.getListAntibody();
        this.field = field;
    }

    @Override
    public int evaluate() throws SyntaxError {
        int min_virus = Integer.MAX_VALUE;
        int min_anti = Integer.MAX_VALUE;

        for(Virus v : listVirus){
            int newmin = findLocation(host.getPos().PosX(), host.getPos().PosY(), v.getPos().PosX(), v.getPos().PosY());
            if(newmin < min_virus && newmin%10 == direct.evaluate())
                min_virus = newmin;
        }

        for(Antibody a : listAntibody){
            int newmin = findLocation(host.getPos().PosX(), host.getPos().PosY(), a.getPos().PosX(), a.getPos().PosY());
            if(newmin < min_anti && newmin%10 == direct.evaluate())
                min_anti = newmin;
        }

        if(min_anti == Integer.MAX_VALUE && min_virus == Integer.MAX_VALUE)
            return 0;
        
        if(min_virus < min_anti)
            return min_virus+1;
        else
            return min_anti+2;
    }
    
    public int findLocation(int hostX,int hostY,int targetX, int targetY){
        int diffY = hostY - targetY;
        // locate 6-7-8
        if(diffY > 0){
            // locate 6
            if( hostX < targetX && targetX - hostX == hostY - targetY )
                return ( targetX - hostX )*10;
            // locate 8
            if(  hostX > targetX && hostX - targetX == hostY - targetY )
                return ( hostX - targetX )*10;
            // locate 7
            if( hostX == targetX )
                return ( hostY - targetY )*10;
        }
        // locate 2,3,4
        else if(diffY < 0){
            // local 4
            if( hostX < targetX && targetX - hostX == targetY - hostY )
                return ( targetX - hostX )*10;
            // locate 2
            if(  hostX > targetX && hostX - targetX == targetY - hostY)
                return ( hostX - targetX )*10;
            // locate 3
            if( hostX == targetX )
                return ( targetY - hostY ) * 10;
        }
        // locate 1,5
        else{
            if( hostX > targetX )
                return ( hostX - targetX )*10;
            if( hostX < targetX )
                return ( targetX - hostX )*10;

        }
        return Integer.MAX_VALUE;
    }
    
}
