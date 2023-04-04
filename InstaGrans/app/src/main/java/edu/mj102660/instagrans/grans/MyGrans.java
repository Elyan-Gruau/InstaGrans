package edu.mj102660.instagrans.grans;

import java.util.ArrayList;

public class MyGrans extends ArrayList<Granny> {

    private static MyGrans instance = null;

    public static MyGrans getInstance() {
        if (instance == null) {
            instance = new MyGrans();
        }
        return instance;
    }

    private MyGrans() {

    }

}
