package com.booboo.CAREN.Model;

import java.util.List;

public class Characterfactory {

  protected int currentTime;
  protected int virusRate;
  // protected int[][] pos = new int[50][50];
  protected Field field = Field.getInstance();

  protected int increaseVirusrate(int time) {
    return virusRate;
  }

  public void createVirus() {
    List<Gamecharacter> list = field.getAllChar();
    Random_int r = new Random_int(3);
    Random_int randomX = new Random_int(10);
    Random_int randomY = new Random_int(15);
    int rand = r.randomInt();
    int r1 = randomX.randomInt()+1;
    int r2 = randomY.randomInt()+1;
    System.out.println("r1 : " + r1 + " , r2 : " + r2);

      for(Gamecharacter g : list){
        while(g.getPos().PosX() == r1 && g.getPos().PosX() == r2){
          r1 = randomX.randomInt();
          r2 = randomY.randomInt();
        }
      }

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

}