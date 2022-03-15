package com.booboo.CAREN.Model;

import java.util.ArrayList;
import java.util.List;

public class Field {

  private List<Virus> listVirus;
  private List<Antibody> listAntibody;
  private List<Gamecharacter> allChar;
  protected Gamecharacter[][] pos = new Gamecharacter[27][15];
  protected String[][] statusCell = new String[50][50];

  private static Field instance = new Field();

  private Field() {
    listVirus = new ArrayList<>();
    listAntibody = new ArrayList<>();
    allChar = new ArrayList<>();
  }

  public static Field getInstance(){
    return instance;
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

}
