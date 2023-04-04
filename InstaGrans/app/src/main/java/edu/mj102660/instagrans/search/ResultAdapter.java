package edu.mj102660.instagrans.search;

import static edu.mj102660.instagrans.RoundingImage.createRoundedBitmapImageDrawableWithBorder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.core.graphics.drawable.RoundedBitmapDrawable;

import java.util.ArrayList;

import edu.mj102660.instagrans.ClickableActivity;
import edu.mj102660.instagrans.R;
import edu.mj102660.instagrans.grans.Granny;
import edu.mj102660.instagrans.grans.Grans;

public class ResultAdapter extends BaseAdapter {
    private ClickableActivity activity;
    private LayoutInflater inflater;

    ArrayList<Granny> grans;


    public ResultAdapter(ClickableActivity activity, ArrayList<Granny> grans) {
        this.activity = activity;
        this.grans = grans;
        inflater = LayoutInflater.from(activity.getContext());
    }

    public int getCount() {
        return grans.size();
    }

    public Object getItem(int position) {
        return grans.get(position);
    }

    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        View layoutItem;

        layoutItem = convertView == null ? inflater.inflate(R.layout.simple_granny_layout, parent, false) : convertView;

        ImageView imageProfile = layoutItem.findViewById(R.id.my_image_view);
        TextView name = layoutItem.findViewById(R.id.name);
        TextView age = layoutItem.findViewById(R.id.age);
        RatingBar rating = layoutItem.findViewById(R.id.rating_simple);

        String resName = (grans.get(position).getUrlPicture());
        resName = resName.replace(".png", "");

        int resID =  parent.getResources().getIdentifier(resName, "drawable", activity.getContext().getPackageName());

        Bitmap userBitmap = BitmapFactory.decodeResource(layoutItem.getResources(), resID);

        RoundedBitmapDrawable roundedImageDrawable = createRoundedBitmapImageDrawableWithBorder(layoutItem, userBitmap);
        imageProfile.setImageDrawable(roundedImageDrawable);


        name.setText(grans.get(position).getName());
        age.setText(grans.get(position).getAge() + " " + layoutItem.getResources().getString(R.string.yearsold));
        rating.setRating((float) grans.get(position).getScore());


        layoutItem.setOnClickListener(click -> {
            int pos = Grans.getInstance().indexOf(grans.get(position));
            activity.onClickGranny(pos);
        });

        return layoutItem;
    }
}