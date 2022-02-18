package Model;

import java.util.ArrayList;
import java.util.List;


public class Field {


    private List<Virus> listVirus;
    private List<Antibody> listAntibody;

    Field(){
        listVirus = new ArrayList<>();
        listAntibody = new ArrayList<>();
    }  

    public List<Virus> getListVirus(){
        return listVirus;
    }

    public List<Antibody> getListAntibosy(){
        return listAntibody;
    }

    public void creatVirus(){
        Characterfactory fac = new Characterfactory();
        listVirus.add(fac.createVirus(2, 4));
        listVirus.add(fac.createVirus(1, 3));
        listVirus.add(fac.createVirus(3, 3));
    }

}
