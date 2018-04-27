package com.sdk.demo.musicplayerdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sdk.demo.musicplayerdemo.MainActivity;
import com.sdk.demo.musicplayerdemo.R;
import com.sdk.demo.musicplayerdemo.util.MediaItem;
import com.sdk.demo.musicplayerdemo.util.UtilFunctions;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

    ArrayList<MediaItem> listOfSongs;
    Context context;
    LayoutInflater inflator;
    public CustomAdapter(Context context, ArrayList<MediaItem> listOfSongs) {
        this.listOfSongs = listOfSongs;
        this.context = context;
        inflator = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflator.inflate(R.layout.custom_list,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MediaItem detail = listOfSongs.get(position);
        holder.textViewSongName.setText(detail.toString());
        holder.textViewArtist.setText(detail.getAlbum() + " - " + detail.getArtist());
        holder.textViewDuration.setText(UtilFunctions.getDuration(detail.getDuration()));
    }

    @Override
    public int getItemCount() {
        return listOfSongs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewSongName, textViewArtist, textViewDuration;
        public ViewHolder(View myView) {
            super(myView);
            textViewSongName = (TextView) myView.findViewById(R.id.textViewSongName);
            textViewArtist = (TextView) myView.findViewById(R.id.textViewArtist);
            textViewDuration = (TextView) myView.findViewById(R.id.textViewDuration);
        }
    }
}
