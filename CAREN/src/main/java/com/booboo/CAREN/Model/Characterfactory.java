package com.booboo.CAREN.Model;

public class Characterfactory {

  protected int currentTime;
  protected int virusRate;
  protected int[][] pos = new int[50][50];
  protected Field field = Field.getInstance();

  protected int increaseVirusrate(int time) {
    return virusRate;
  }

  public void createVirus() {
    Random_int r = new Random_int(3);
    Random_int random = new Random_int(50);
    int rand = r.randomInt();
    int r1 = random.randomInt();
    int r2 = random.randomInt();
    System.out.println("r1 : " + r1 + " , r2 : " + r2);
    if (pos[r1][r2] == 1) {
      System.out.println("HERE");
      while (pos[r1][r2] == 1) {
        System.out.println("r1 : " + r1 + " , r2 : " + r2);
        r1 = random.randomInt();
        r2 = random.randomInt();
      }
    }
    pos[r1][r2] = 1;

    if (rand == 0) {
      System.out.println("virusX: x_position: " + r1 + " ,y_position: " + r2);
      // return new Virus_X(r1, r2);
      field.addVirus(new Virus_X(r1, r2));
    } else if (rand == 1) {
      System.out.println("virusY: x_position: " + r1 + " ,y_position: " + r2);
      field.addVirus(new Virus_Y(r1, r2));
    } else {
      System.out.println("virusZ: x_position: " + r1 + " ,y_position: " + r2);
      field.addVirus(new Virus_Z(r1, r2));
    }
  }

  //use this
  public void createAntibodyA(int posx, int posy) {
      field.addAntibody(new Antibody_A(posx, posy));
  }

  public void createAntibodyB(int posx, int posy) {
    field.addAntibody(new Antibody_B(posx, posy));
  }

  public void createAntibodyC(int posx, int posy) {
    field.addAntibody(new Antibody_C(posx, posy));
  }
  // =======
  //     public Antibody createAntibody(String type,int posx,int posy) {
  //       if (type.equals("A")) {
  //         System.out.println("Antibody A is now create");
  //         Antibody_A a = new Antibody_A(1,1);
  //         return a;
  //       } else if (type.equals("B")) {
  //         System.out.println("Antibody B is now create");
  //         Antibody_B b = new Antibody_B(1,1);
  //         return b;
  //       } else if (type.equals("C")) {
  //         System.out.println("Antibody C is now create");
  //         Antibody_C c = new Antibody_C(1,1);
  //         return c;
  //       }
  //       return null;
  //     }

  //     public Antibody createAntibodytest(String type,int posx, int posy) {
  //       if (type.equals("A")) {
  //         System.out.println("Antibody A is now create");
  //         Antibody_A a = new Antibody_A(1,1);
  //         return a;
  //       } else if (type.equals("B")) {
  //         System.out.println("Antibody B is now create");
  //         Antibody_B b = new Antibody_B(1,1);
  //         return b;
  //       } else if (type.equals("C")) {
  //         System.out.println("Antibody C is now create");
  //         Antibody_C c = new Antibody_C(1,1);
  //         return c;
  //       }
  //       return null;
  //     }

  // >>>>>>> master
}
