package Parser;


import java.util.List;

import Model.Antibody;
import Model.Gamecharacter;
import Model.Position;
import Model.Virus;

public class AttackCommand implements Node{

    protected Node direction;
    protected Gamecharacter host;
    private List<Virus> listVirus;
    private List<Antibody> listAntibody;

    AttackCommand(Node direction, Gamecharacter host ,List<Virus> listVirus, List<Antibody> listAntibody){
        this.direction = direction;
        this.host = host;
        this.listVirus = listVirus;
        this.listAntibody = listAntibody;
    }

    @Override
    public double evaluate() throws SyntaxError {

        Position target = targetLocation(host.getPos(), direction.evaluate());
        if(host.getType().equals("virus")){
            for(Virus v : listVirus){
                if(v.getPos().equalPos(target))
                    v.attackedBy(host);
            }
        }
        else{
            for(Antibody a : listAntibody){
                if(a.getPos().equalPos(target))
                    a.attackedBy(host);
            }
        }

        return 0;
    }

    public Position targetLocation(Position hostPos,double direction){
        
        switch((int) direction){
            case 1 : {
                return new Position(hostPos.PosX()-1, hostPos.PosY());
            }
            case 2 : {
                return new Position(hostPos.PosX()-1, hostPos.PosY()+1);
            }
            case 3 : {
                return new Position(hostPos.PosX(), hostPos.PosY()+1);
            }
            case 4 : {
                return new Position(hostPos.PosX()+1, hostPos.PosY()+1);
            }
            case 5 : {
                return new Position(hostPos.PosX()+1, hostPos.PosY());
            }
            case 6 : {
                return new Position(hostPos.PosX()+1, hostPos.PosY()-1);
            }
            case 7 : {
                return new Position(hostPos.PosX(), hostPos.PosY()-1);
            }
            case 8 : {
                return new Position(hostPos.PosX()-1, hostPos.PosY()-1);
            }
        }   
        return null;     
    }
    
}
