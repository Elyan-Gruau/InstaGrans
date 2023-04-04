package edu.mj102660.instagrans.cart;

import edu.mj102660.instagrans.grans.Granny;

public class Panier {
    private static Panier instance = null;
    private Granny granny;

    public static Panier getInstance() {
        if (instance == null) {
            instance = new Panier();
        }
        return instance;
    }

    private Panier(){
    }

    public void setGranny(Granny granny) {
        this.granny = granny;
    }
}
