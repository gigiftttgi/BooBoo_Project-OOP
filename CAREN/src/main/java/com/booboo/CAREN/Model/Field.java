package com.booboo.CAREN.Model;

import java.util.ArrayList;
import java.util.List;

public class Field {

  private List<Virus> listVirus;
  private List<Antibody> listAntibody;
  protected int[][] pos = new int[50][50];
  protected String[][] statusCell = new String[50][50];

  private static Field instance = new Field();

  private Field() {
    listVirus = new ArrayList<>();
    listAntibody = new ArrayList<>();
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

  public void updateStatus(){

  }

  // for testing
  public void addVirus(Virus v){
    listVirus.add(v);
  }

  public void addAntibody(Antibody a){
    listAntibody.add(a);
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
