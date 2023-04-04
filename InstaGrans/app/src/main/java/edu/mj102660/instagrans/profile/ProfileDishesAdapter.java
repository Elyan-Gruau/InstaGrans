package edu.mj102660.instagrans.profile;

import static edu.mj102660.instagrans.RoundingImage.createRoundedBitmapImageDrawableWithBorder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.core.graphics.drawable.RoundedBitmapDrawable;

import java.util.ArrayList;

import edu.mj102660.instagrans.ClickableActivity;
import edu.mj102660.instagrans.R;
import edu.mj102660.instagrans.grans.Granny;
import edu.mj102660.instagrans.grans.Grans;
import edu.mj102660.instagrans.grans.dish.Dish;

public class ProfileDishesAdapter extends BaseAdapter {

    private ClickableActivity activity;
    private LayoutInflater inflater;

    ArrayList<Dish> dishes;


    public ProfileDishesAdapter(ClickableActivity activity, ArrayList<Dish> dishes) {
        this.activity = activity;
        this.dishes = dishes;
        inflater = LayoutInflater.from(activity.getContext());
    }

    public int getCount() {
        return dishes.size();
    }

    public Object getItem(int position) {
        return dishes.get(position);
    }

    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        View layoutItem;

        layoutItem = convertView == null ? inflater.inflate(R.layout.profile_dish_layout, parent, false) : convertView;

        ImageView imageDish = layoutItem.findViewById(R.id.dish_image);

        String resName = (dishes.get(position).getUrlImage());
        int resID =  parent.getResources().getIdentifier(resName, "drawable", activity.getContext().getPackageName());

        imageDish.setImageResource(resID);

//        layoutItem.setOnClickListener(click -> activity.onClickGranny(position));

        return layoutItem;
    }
}
