package edu.mj102660.instagrans.grans;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import edu.mj102660.instagrans.ClickableActivity;
import edu.mj102660.instagrans.R;

public class GransAdapter extends BaseAdapter {
    private ClickableActivity activity;
    //Un mécanisme pour gérer l'affichage graphique depuis un layout XML
    private LayoutInflater inflater;


    public GransAdapter(ClickableActivity activity) {
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
        layoutItem = convertView == null ? inflater.inflate(R.layout.simple_granny_layout, parent, false) : convertView;


        layoutItem.setOnClickListener( click -> activity.onClickGranny(position) );
        //On retourne l'item créé.
        return layoutItem;
    }
}