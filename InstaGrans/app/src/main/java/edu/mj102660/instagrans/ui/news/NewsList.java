package edu.mj102660.instagrans.ui.news;

import java.util.ArrayList;

import edu.mj102660.instagrans.grans.Granny;

public class NewsList extends ArrayList<News> {
    public NewsList() {
        // Foreach des grannies
    }
}

class News {
    private Granny granny;
    private String news;
    private String image;

    public News(Granny granny) {
        this.granny = granny;
    }

    private void generateNews() {
        // Cas de base (test)
        news = granny.getName() + " a appris à faire " + granny.getDishes().get(0).getName();
        image = granny.getDishes().get(0).getUrlImage();
    }
}
