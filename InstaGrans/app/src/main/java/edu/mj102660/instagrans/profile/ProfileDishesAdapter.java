package edu.mj102660.instagrans.profile;

import static edu.mj102660.instagrans.RoundingImage.createRoundedBitmapImageDrawableWithBorder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
        System.out.println("Alain" + dishes.size());
        inflater = LayoutInflater.from(activity.getContext());
    }

    public int getCount() {
        return dishes.size();
    }

    public Dish getItem(int position) {
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
        resName = resName.replace(".png", "");
        int resID =  parent.getResources().getIdentifier(resName, "drawable", activity.getContext().getPackageName());

        imageDish.setImageResource(resID);

        TextView dish_name = layoutItem.findViewById(R.id.dish_name);

        dish_name.setText(dishes.get(position).getName());


//        layoutItem.setOnClickListener(click -> activity.onClickGranny(position));

        return layoutItem;
    }
}
