package edu.mj102660.instagrans.search;

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

        layoutItem = convertView == null ? inflater.inflate(R.layout.simple_granny_layout, parent, false) : convertView;

        ImageView imageProfile = layoutItem.findViewById(R.id.grannyPic);

        String resName = (Grans.getInstance().get(position).getUrlPicture());
        int resID =  parent.getResources().getIdentifier(resName, "drawable", activity.getContext().getPackageName());

        Bitmap userBitmap = BitmapFactory.decodeResource(layoutItem.getResources(),resID);
        RoundedBitmapDrawable roundedImageDrawable = createRoundedBitmapImageDrawableWithBorder(layoutItem, userBitmap);
        imageProfile.setImageDrawable(roundedImageDrawable);

        layoutItem.setOnClickListener(click -> {
            int pos = Grans.getInstance().indexOf(grans.get(position));
            activity.onClickGranny(pos);
        });

        return layoutItem;
    }
}