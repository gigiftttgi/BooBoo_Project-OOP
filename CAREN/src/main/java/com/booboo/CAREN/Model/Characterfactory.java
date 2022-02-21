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
  // ยังใช้ class time ไม่ได้
  // public Virus createVirus(int time,int virusRate){

  //     int randVirus = (int)(Math.random()*3)+1;

  //     if (randVirus==1) {
  //         System.out.println("Virus x is now create.");
  //         return new Virus_X();
  //     }else if(randVirus==2){
  //         System.out.println("Virus y is now create.");
  //         return new Virus_Y();
  //     }else{
  //         System.out.println("Virus z is now create.");
  //         return new Virus_Z();
  //     }
  // }

  //wait shop to finish
    public Antibody createAntibody(String type) {
      if (type.equals("A")) {
        System.out.println("Antibody A is now create");
        Antibody_A a = new Antibody_A();
        return a;
      } else if (type.equals("B")) {
        System.out.println("Antibody B is now create");
        Antibody_B b = new Antibody_B();
        return b;
      } else if (type.equals("C")) {
        System.out.println("Antibody C is now create");
        Antibody_C c = new Antibody_C();
        return c;
      }
      return null;
    }
}
