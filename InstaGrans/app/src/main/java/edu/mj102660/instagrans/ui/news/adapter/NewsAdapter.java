package edu.mj102660.instagrans.ui.news.adapter;

import static edu.mj102660.instagrans.RoundingImage.createRoundedBitmapImageDrawableWithBorder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.graphics.drawable.RoundedBitmapDrawable;

import edu.mj102660.instagrans.R;
import edu.mj102660.instagrans.grans.Grans;
import edu.mj102660.instagrans.ui.news.NewsFragment;

public class NewsAdapter extends BaseAdapter {

    private NewsList newsList;
    private NewsFragment context;
    private LayoutInflater layoutInflater;

    public NewsAdapter(NewsList newsList, NewsFragment newsFragment) {
        this.newsList = newsList;
        this.context = newsFragment;
        layoutInflater = LayoutInflater.from(newsFragment.getContext());
    }

    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public Object getItem(int i) {
        return newsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LinearLayout layoutItem;

        if (view == null) {
            layoutItem = (LinearLayout) layoutInflater.inflate(R.layout.news_wpic_layout, viewGroup, false);
        } else {
            layoutItem = (LinearLayout) view;
        }

        News news = newsList.get(i);

        // Granny Pic
        ImageView imageProfile = layoutItem.findViewById(R.id.grannyPic);

        String resName = (news.getGranny().getUrlPicture());
        int resID =  context.getContext().getResources().getIdentifier(resName, "drawable", context.getContext().getPackageName());

        Bitmap userBitmap = BitmapFactory.decodeResource(layoutItem.getResources(),resID);
        RoundedBitmapDrawable roundedImageDrawable = createRoundedBitmapImageDrawableWithBorder(layoutItem, userBitmap);
        imageProfile.setImageDrawable(roundedImageDrawable);

        // Granny Name
        TextView grannyName = layoutItem.findViewById(R.id.grannyName);
        grannyName.setText(news.getGranny().getName());
        grannyName.setTextColor(context.getResources().getColor(R.color.courge));

        // Granny News
        TextView grannyNews = layoutItem.findViewById(R.id.achievementText);
        grannyNews.setText(news.getNews());

        // Dish Pic
        ImageView imageDish = layoutItem.findViewById(R.id.newsPic);
        String dishName = (news.getGranny().getUrlPicture());
        int dishID =  context.getContext().getResources().getIdentifier(dishName, "drawable", context.getContext().getPackageName());
        imageDish.setImageResource(dishID);

        return layoutItem;
    }
}
