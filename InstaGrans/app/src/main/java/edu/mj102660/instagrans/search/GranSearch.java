package edu.mj102660.instagrans.search;

import java.util.ArrayList;

import edu.mj102660.instagrans.grans.Granny;
import edu.mj102660.instagrans.grans.Grans;

public class GranSearch {

    public static ArrayList<Granny> requestResult(String request) {

        ArrayList<Granny> result = new ArrayList<>();

        Grans.getInstance().forEach(granny -> {
            if (granny.getName().contains(request)) {
                result.add(granny);
            }
        });

        return result;
    }
}
