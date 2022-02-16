package Model;
public class Characterfactory {

    int currentTime;
    int virusRate;

    int increaseVirusrate(int time){
        return virusRate;
    }

    Virus createVirus(int time,int virusRate){

        Virus virus = new Virus();
        if(time%3==0){
            Virus_X x = new Virus_X();
            System.out.println("Virus x is now create.");
            virus = x;
        }else if(time%5==0){
            Virus_Y y = new Virus_Y();
            System.out.println("Virus y is now create.");
            virus = y;
        }else if(time%7==0){
            Virus_Z z = new Virus_Z();
            System.out.println("Virus z is now create.");
            virus = z;
        }

        return virus;
    }

    Antibody createAntibody(int credit){
        Antibody anb = new Antibody();
        if (credit >= 20) {

            System.out.println("Virus A is now create");
            Antibody_A a = new Antibody_A();
            anb = a;
        }else if(credit >= 50){
            System.out.println("Virus B is now create");
            Antibody_B b = new Antibody_B();
            anb = b;
        }else if(credit >= 70){
            System.out.println("Virus C is now create");
            Antibody_C c = new Antibody_C();
            anb = c;
        }
        return anb;
    }
    
}
