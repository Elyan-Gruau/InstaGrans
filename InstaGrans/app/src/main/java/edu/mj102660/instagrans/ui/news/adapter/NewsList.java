package edu.mj102660.instagrans.ui.news.adapter;

import android.view.View;

import java.util.ArrayList;

import edu.mj102660.instagrans.R;
import edu.mj102660.instagrans.grans.Granny;
import edu.mj102660.instagrans.grans.Grans;

public class NewsList extends ArrayList<News> {
    public NewsList(View layout) {
        for (Granny granny : Grans.getInstance()) {
            News news = new News(granny);
            news.generateNews(layout);
            add(news);
        }
        System.out.println("NewsList: " + size() + " news generated");
        System.out.println("NewsList (0): " + get(0).getNews());
        System.out.println("NewsList (24): " + get(24).getNews());
    }
}

class News {
    private Granny granny;
    private String news;
    private String image;

    public News(Granny granny) {
        this.granny = granny;
    }

    void generateNews(View layout) {
        // Cas de base (test)
        news = layout.getResources().getString(R.string.news_sentence_0) + granny.getDishes().get(0).getName();
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
