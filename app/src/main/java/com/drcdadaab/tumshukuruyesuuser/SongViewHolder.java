package com.drcdadaab.tumshukuruyesuuser;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by DAGA ICT on 26/09/2017.
 */

public class SongViewHolder extends RecyclerView.ViewHolder  {
    TextView textViewSongListTitle, textViewSongListNumber;
    View mView;

    public SongViewHolder(View itemView){
        super(itemView);
        this.mView = itemView;
        textViewSongListTitle = (TextView) itemView.findViewById(R.id.textViewSongListTitle);
        textViewSongListNumber = (TextView) itemView.findViewById(R.id.textViewSongListNumber);
    }
}