package com.booboo.CAREN.Model;

import java.util.ArrayList;
import java.util.List;

public class Field {

  private List<Virus> listVirus;
  private List<Antibody> listAntibody;
  protected int[][] pos = new int[50][50];

  public Field() {
    listVirus = new ArrayList<>();
    listAntibody = new ArrayList<>();
  }

  public List<Virus> getListVirus() {
    return listVirus;
  }

  public List<Antibody> getListAntibosy() {
    return listAntibody;
  }

  public void creatVirus() {

    Random_int r = new Random_int(51);
    Characterfactory fac = new Characterfactory();
    int r1 = r.randomInt();
    int r2 = r.randomInt();
    while(pos[r1][r2] == 1) {
      r1 = r.randomInt();
      r2 = r.randomInt();
    }
    pos[r1][r2] = 1;
    listVirus.add(fac.createVirus(r1, r2));

  }
}
