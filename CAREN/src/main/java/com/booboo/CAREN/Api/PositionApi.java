package com.booboo.CAREN.Api;

import lombok.Data;

@Data
public class PositionApi {
    private int p;
    private int q;

    public int getP(){
        return p;
    }

    public int getQ() {
        return q;
    }
}
