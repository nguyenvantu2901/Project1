package com.example.project1.fragment;

import android.content.ContentUris;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.project1.R;
import com.example.project1.adapter.KaiwaAdapter;
import com.example.project1.adapter.KanjiAdapter;
import com.example.project1.database.DataBaseHelper;
import com.example.project1.model.Kaiwa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.example.project1.morefunc.DataSave.idSpinnerChose;

public class KaiwaFragment extends Fragment {

    private SeekBar sbTime;
    private ImageView imgPlay;
    private TextView tvStartTime;
    private TextView tvEndTime;
    private TextView tvKaiwaTitle;
    private ListView lvKaiwa;

    private List<Kaiwa> kaiwaList;
    DataBaseHelper dataBaseHelper;
    KaiwaAdapter kaiwaAdapter;

    MediaPlayer mediaPlayer;
    double startTime = 0;
    double finalTime = 0;
    Handler myHandler = new Handler();
    static int oneTimeOnly = 0;

    public KaiwaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kaiwa, container, false);
        initView(view);

        mediaPlayer = new MediaPlayer();

        kaiwaList = new ArrayList<>();
        dataBaseHelper = new DataBaseHelper(getActivity());
        kaiwaList = dataBaseHelper.getKaiwa(idSpinnerChose);

        tvKaiwaTitle.setText(kaiwaList.get(0).getCharacter());


        List<Kaiwa> kaiwaListCut = new ArrayList<>();
        for (int j = 1; j < kaiwaList.size(); j++) {
            kaiwaListCut.add(kaiwaList.get(j));
        }
        kaiwaAdapter = new KaiwaAdapter(getActivity(), kaiwaListCut);
        lvKaiwa.setAdapter(kaiwaAdapter);



        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mediaPlayer.isPlaying()) {

                    if (mediaPlayer != null) {
                        mediaPlayer.pause();
                        // Changing button image to play button
                        imgPlay.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                    }

                } else {
                    // Resume song
                    if (mediaPlayer != null) {
                        mediaPlayer.start();
                        // Changing button image to pause button
                        imgPlay.setImageResource(R.drawable.ic_pause_black_24dp);
                    }
                }
            }
        });

        return view;
    }



    public void playKaiwa(int lesson_id) {
        try {
            AssetFileDescriptor afd = getActivity().getAssets().openFd("kaiwa/" + lesson_id + ".mp3");

            mediaPlayer = new MediaPlayer();

            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mediaPlayer.prepare();

            mediaPlayer.start();

            // Displaying Song title

            finalTime = mediaPlayer.getDuration();
            startTime = mediaPlayer.getCurrentPosition();
            if (oneTimeOnly == 0) {
                sbTime.setMax((int) finalTime);
                oneTimeOnly = 1;
            }
            tvStartTime.setText(String.format(
                    "%d : %d",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime)
                            - TimeUnit.MINUTES.toSeconds(
                            TimeUnit.MILLISECONDS.toMinutes((long) startTime))

            ));
            tvEndTime.setText(String.format(
                    "%d : %d",
                    TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) finalTime)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes((long) finalTime))
            ));

            sbTime.setProgress((int) startTime);
//            myHandler.postDelayed(UpdateSongTime, 100);
            imgPlay.setImageResource(R.drawable.ic_pause_black_24dp);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    private Runnable UpdateSongTime = new Runnable() {
//        @Override
//        public void run() {
//            startTime = mediaPlayer.getCurrentPosition();
//            tvStartTime.setText(String.format(
//                    "%d : %d",
//                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
//                    TimeUnit.MILLISECONDS.toSeconds((long) startTime)
//                            - TimeUnit.MINUTES.toSeconds(
//                            TimeUnit.MILLISECONDS.toMinutes((long) startTime))
//
//            ));
//            sbTime.setProgress((int) startTime);
//            myHandler.postDelayed(this, 100);
//        }
//    };




    @Override
    public void onResume() {
        super.onResume();
        playKaiwa(idSpinnerChose);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) mediaPlayer.release();
    }

    @Override
    public void onPause() {
        super.onPause();
        mediaPlayer.release();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mediaPlayer.release();
    }



    private void initView(View view) {
        sbTime = (SeekBar) view.findViewById(R.id.sbTime);
        imgPlay = (ImageView) view.findViewById(R.id.imgPlay);
        tvStartTime = (TextView) view.findViewById(R.id.tvStartTime);
        tvEndTime = (TextView) view.findViewById(R.id.tvEndTime);
        tvKaiwaTitle = (TextView) view.findViewById(R.id.tvKaiwa_Title);
        lvKaiwa = (ListView) view.findViewById(R.id.lvKaiwa);

    }

}
