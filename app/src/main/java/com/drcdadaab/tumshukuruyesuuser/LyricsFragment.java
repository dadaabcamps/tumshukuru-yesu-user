package com.drcdadaab.tumshukuruyesuuser;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


/**
 * A simple {@link Fragment} subclass.
 */
public class LyricsFragment extends Fragment {

    private static final String TAG = MainActivity.class.getSimpleName();
    RecyclerView rv;
    LinearLayoutManager linearLayoutManager;
    DatabaseReference db;
    FirebaseRecyclerAdapter<Song, SongViewHolder> firebasenewsRecycleAdapter;
    ProgressBar progressBarLyrics;

    public LyricsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_lyrics, container, false);

        //Initialize Firebase DB
        db = FirebaseDatabase.getInstance().getReference();

        //SETUP RECYCLER
        rv = (RecyclerView) rootView.findViewById(R.id.recyclerViewLyrics);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setStackFromEnd(false);


        progressBarLyrics = (ProgressBar) rootView.findViewById(R.id.progressBarLyrics);
        progressBarLyrics.setVisibility(View.VISIBLE);

        Query query =  db.child("Songs").orderByChild("hymn").equalTo(false);
//        Query query =  db.child("Songs");

        firebasenewsRecycleAdapter = new FirebaseRecyclerAdapter<Song, SongViewHolder>(Song.class, R.layout.song_list_item, SongViewHolder.class, query) {
            @Override
            protected void populateViewHolder(SongViewHolder viewHolder, final Song model, final int position) {
                viewHolder.textViewSongListTitle.setText(model.getTitle());
                viewHolder.textViewSongListNumber.setText(model.getHymnnumber());
                progressBarLyrics.setVisibility(View.GONE);
                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //firebasenewsRecycleAdapter.getRef(position).removeValue();
                        openSongDetailActivity(model.getSongId(), model.getTitle(), model.getHymnnumber(), model.getContent(), model.getLanguage());
                    }
                });
            }

            private void openSongDetailActivity(String id, String title, String hymnnumber, String content, String language) {
                Intent intent = new Intent(getActivity(), ViewSongActivity.class);
                intent.putExtra("idKey", id);
                intent.putExtra("titleKey", title);
                intent.putExtra("HymnNumberKey", hymnnumber);
                intent.putExtra("ContentKey", content);
                intent.putExtra("languageKey", language);

                startActivity(intent);
            }
        };
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(firebasenewsRecycleAdapter);

        return rootView;
    }

}
