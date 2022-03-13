package com.booboo.CAREN.Model;

public class Characterfactory {

  protected int currentTime;
  protected int virusRate;


  protected int increaseVirusrate(int time) {
    return virusRate;
  }

  public Virus createVirus(int posx, int posy) {
    Random_int r = new Random_int(3);
    int rand = r.randomInt();

    if (rand == 0) {
      System.out.println(
        "virusX: x_position: " + posx + " ,y_position: " + posy
      );
      return new Virus_X(posx, posy);
    } else if (rand == 1) {
      System.out.println(
        "virusY: x_position: " + posx + " ,y_position: " + posy
      );
      return new Virus_Y(posx, posy);
    } else {
      System.out.println(
        "virusZ: x_position: " + posx + " ,y_position: " + posy
      );
      return new Virus_Z(posx, posy);
    }
  }



    public Antibody createAntibody(String type,int posx,int posy) {
      if (type.equals("A")) {
        System.out.println("Antibody A is now create");
<<<<<<< HEAD
        Antibody_A a = new Antibody_A(1,1);
        return a;
      } else if (type.equals("B")) {
        System.out.println("Antibody B is now create");
        Antibody_B b = new Antibody_B(1,1);
        return b;
      } else if (type.equals("C")) {
        System.out.println("Antibody C is now create");
        Antibody_C c = new Antibody_C(1,1);
        return c;
      }
      return null;
    }

    public Antibody createAntibodytest(String type,int posx, int posy) {
      if (type.equals("A")) {
        System.out.println("Antibody A is now create");
        Antibody_A a = new Antibody_A(1,1);
        return a;
      } else if (type.equals("B")) {
        System.out.println("Antibody B is now create");
        Antibody_B b = new Antibody_B(1,1);
        return b;
      } else if (type.equals("C")) {
        System.out.println("Antibody C is now create");
        Antibody_C c = new Antibody_C(1,1);
        return c;
=======
        return new Antibody_A(posx, posy);
      } else if (type.equals("B")) {
        System.out.println("Antibody B is now create");
        return new Antibody_B(posx, posy);
      } else if (type.equals("C")) {
        System.out.println("Antibody C is now create");
        return new Antibody_C(posx, posy);
>>>>>>> d7ffa376cf1268c0272f79a7818e3f7327cf8e6b
      }
      return null;
    }

    
}
