package com.booboo.CAREN.Model;

import java.util.ArrayList;
import java.util.List;

public class Field {

  private List<Virus> listVirus;
  private List<Antibody> listAntibody;
  private List<Gamecharacter> allChar;
  protected Gamecharacter[][] pos = new Gamecharacter[27][15];
  protected String[][] statusCell = new String[50][50];

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

  public void charDie(Gamecharacter g){
    if(g.getType().equals("antibody")){
      listAntibody.remove(g);
    }
    else{
      listVirus.remove(g);
    }
  }

//  private Shop shop = Shop.getInsShop();
  public int movetoPosition(int oldPos,int newPos){
    int cost = 0;
       for(Antibody a : listAntibody){
         if((((a.getPos().PosX() - 1) * 25) + a.getPos().PosY()) == oldPos){
          int posY =  newPos%25;
          if(posY == 0){
            posY = 25;
          }
          int posX = ((newPos- posY) / 25) + 1;
            a.pos = new Position(posX,posY);
         }
         cost = a.moveCost;

//         shop.moveCost(a.moveCost);
       }
    return cost;
  }

}
