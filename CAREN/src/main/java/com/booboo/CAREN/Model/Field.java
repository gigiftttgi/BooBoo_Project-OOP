package com.booboo.CAREN.Model;

import java.util.ArrayList;
import java.util.List;

public class Field {

  private List<Virus> listVirus;
  private List<Antibody> listAntibody;
  private List<Gamecharacter> allChar;

  private static Field instanceF;

  private Field() {
    listVirus = new ArrayList<>();
    listAntibody = new ArrayList<>();
    allChar = new ArrayList<>();
  }

  public static Field getInstance(){

    if (instanceF == null)
    {
      instanceF = new Field();
    }
    return instanceF;
  }

  public List<Virus> getListVirus() {
    return listVirus;
  }

  public List<Antibody> getListAntibody() {
    return listAntibody;
  }


  public List<Gamecharacter> getAllChar() {
    return allChar;
  }

  // for testing
  public void addVirus(Virus v){
    listVirus.add(v);
    allChar.add(v);
  }

  public void addAntibody(Antibody a){
    listAntibody.add(a);
    allChar.add(a);
  }

  public int charDie(Gamecharacter g){
    allChar.remove(g);
    if(g.getType().equals("A") || g.getType().equals("B") || g.getType().equals("C")){
      listAntibody.remove(g);
      return 0;
    }
    else{
      Virus x = (Virus) g;
      listVirus.remove(g);
      return x.credit;
    }
  }

  public void clearField(){
    listVirus = new ArrayList<>();
    listAntibody = new ArrayList<>();
    allChar = new ArrayList<>();
  }

//  private Shop shop = Shop.getInsShop();
  public int movetoPosition(int oldPos,int newPos){
    System.out.println("old" + oldPos + "new" + newPos);
    int cost = 0;
       for(Antibody a : listAntibody){

         if((((a.pos.x - 1) * 15) + a.pos.y) == oldPos){

          int posY =  newPos%15;
          if(posY == 0){
            posY = 15;
          }
          int posX = ((newPos- posY) / 15) + 1;
            a.pos = new Position(posX,posY);
            cost = a.moveCost;
         }


//         shop.moveCost(a.moveCost);
       }
    return cost;
  }

}
