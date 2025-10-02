package com.example.fragments_5a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PassengerAdapter extends ArrayAdapter<Passenger> {

    Context context;
    public PassengerAdapter(Context context, int resource ,ArrayList<Passenger> passengers)
    {
        super(context, resource,passengers);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView==null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.single_passenger_item_design, parent, false);
        }
        Passenger p = getItem(position);
        ImageView ivPref = convertView.findViewById(R.id.ivPref);
        TextView tvName = convertView.findViewById(R.id.tvName);

        tvName.setText(p.getName());

        if(p.getPreference().equalsIgnoreCase("buss"))
        {
            ivPref.setImageResource(R.drawable.icon_buss);
        }
        else if(p.getPreference().equalsIgnoreCase("plane"))
        {
            ivPref.setImageResource(R.drawable.icon_plane);
        }
        else if(p.getPreference().equalsIgnoreCase("train"))
        {
            ivPref.setImageResource(R.drawable.icon_train);
        }

        return convertView;

    }
}
