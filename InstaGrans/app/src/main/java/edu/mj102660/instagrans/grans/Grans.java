package edu.mj102660.instagrans.grans;

import java.util.ArrayList;

public class Grans extends ArrayList<Granny> {

    private static Grans instance = null;

    public static Grans getInstance() {
        if (instance == null) {
            instance = new Grans();
        }
        return instance;
    }

    private Grans(){

    }
}
