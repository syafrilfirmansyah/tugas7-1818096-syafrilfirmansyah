package com.example.tugasrumah7;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Buku> movieItems;

    public CustomListAdapter(Activity activity, List<Buku> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }

    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView judul = (TextView) convertView.findViewById(R.id.text_judul);
        TextView namapenerbit = (TextView) convertView.findViewById(R.id.text_penerbit);
        TextView tahun = (TextView) convertView.findViewById(R.id.text_tahun);
        // ImageView imageView = (ImageView) convertView.findViewById(R.id.);

        Buku m = movieItems.get(position);

        judul.setText("Judul : "+ m.get_judul());
        namapenerbit.setText("Penerbit : "+ m.get_penerbit());
        tahun.setText("Tahun : "+ m.get_tahun());

        return convertView;
    }
}

