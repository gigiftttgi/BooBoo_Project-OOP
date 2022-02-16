package Model;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

import Parser.SyntaxError;

public class Field {

    // List<Virus> allVirus;
    // List<Antibody> allAntibody;
    // Boolean[][] status = new Boolean[50][50];

    // Field(List<Virus> allVirus, List<Antibody> allAntibody, Boolean[][] status){
    //     this.allVirus = allVirus;
    //     this.allAntibody = allAntibody;
    //     this.status = status;
    // }

    public static void main(String[] args) throws FileNotFoundException, SyntaxError {
        List<Virus> allVirus = new LinkedList<>();
        List<Antibody> allAntibody = new LinkedList<>();
        Boolean[][] status = new Boolean[50][50];
        Characterfactory fac = new Characterfactory();
        Virus a = fac.createVirus(5,5);
        a.runGeneticcode();
    }
    
}
