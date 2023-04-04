package edu.mj102660.instagrans.ui.discover.adapter;

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

import edu.mj102660.instagrans.ClickableActivity;
import edu.mj102660.instagrans.R;
import edu.mj102660.instagrans.grans.Grans;

public class DiscoverAdapter extends BaseAdapter {
    private ClickableActivity activity;
    private LayoutInflater inflater;


    public DiscoverAdapter(ClickableActivity activity) {
        this.activity = activity;
        inflater = LayoutInflater.from(activity.getContext());
    }

    public int getCount() {
        return Grans.getInstance().size();
    }

    public Object getItem(int position) {
        return Grans.getInstance().get(position);
    }

    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        View layoutItem;

        //(1) : Réutilisation des layouts
        layoutItem = convertView == null ? inflater.inflate(R.layout.discover_granny_layout, parent, false) : convertView;

        ImageView imageProfile = layoutItem.findViewById(R.id.grannyPic);
        ImageView dishImage = layoutItem.findViewById(R.id.dishPic);
        TextView ageText = layoutItem.findViewById(R.id.age);
        TextView nameText = layoutItem.findViewById(R.id.name);

        //Profile Picture
        String resName = (Grans.getInstance().get(position).getUrlPicture());
        resName = resName.replace(".png", "");
        int resID =  parent.getResources().getIdentifier(resName, "drawable", activity.getContext().getPackageName());
        Bitmap userBitmap = BitmapFactory.decodeResource(layoutItem.getResources(),resID);
        RoundedBitmapDrawable roundedImageDrawable = createRoundedBitmapImageDrawableWithBorder(layoutItem, userBitmap);
        imageProfile.setImageDrawable(roundedImageDrawable);

        //Dish Picture
        String resDishName = (Grans.getInstance().get(position).getDishes().get(0).getUrlImage());
        resDishName = resDishName.replace(".png", "");
        int resDishID =  parent.getResources().getIdentifier(resDishName, "drawable", activity.getContext().getPackageName());
        Bitmap userDishBitmap = BitmapFactory.decodeResource(layoutItem.getResources(),resDishID);
        RoundedBitmapDrawable roundedImageDishDrawable = createRoundedBitmapImageDrawableWithBorder(layoutItem, userDishBitmap);
        dishImage.setImageResource(resDishID);

        layoutItem.setOnClickListener(click -> activity.onClickGranny(position));


        ageText.setText(String.valueOf(Grans.getInstance().get(position).getAge()));
        nameText.setText(String.valueOf(Grans.getInstance().get(position).getName()));

        return layoutItem;
    }
}