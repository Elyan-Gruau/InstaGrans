package edu.mj102660.instagrans.ui.news.adapter;

import java.util.ArrayList;

import edu.mj102660.instagrans.grans.Granny;
import edu.mj102660.instagrans.grans.Grans;

public class NewsList extends ArrayList<News> {
    public NewsList() {
        Grans grans = Grans.getInstance();
        for (Granny granny : grans) {
            News news = new News(granny);
            news.generateNews();
            add(news);
        }
    }
}

class News {
    private Granny granny;
    private String news;
    private String image;

    public News(Granny granny) {
        this.granny = granny;
    }

    void generateNews() {
        // Cas de base (test)
        news = " a appris à faire " + granny.getDishes().get(0).getName();
        image = granny.getDishes().get(0).getUrlImage();
    }

    public String getNews() {
        return news;
    }

    public String getImage() {
        return image;
    }

    public Granny getGranny() {
        return granny;
    }
}
