package com.example.project1.activity;

import android.content.res.AssetFileDescriptor;
import android.database.sqlite.SQLiteConstraintException;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.ItemClickSupport;
import com.example.project1.R;
import com.example.project1.adapter.AlphabetAdapter;
import com.example.project1.model.Alphabet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlphabetActivity extends BaseActivity {

    MediaPlayer mediaPlayer;
    AlertDialog alertDialog;
    private RecyclerView alphabetRecycleView;
    private List<Alphabet> list;
    private AlphabetAdapter alphabetAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("BẢNG CHỮ CÁI");


        innitData();

        alphabetRecycleView = (RecyclerView) findViewById(R.id.alphabet_recycleView);

        list = MainActivity.db.alphabetDAO().getALLBCC();


        alphabetRecycleView.setHasFixedSize(true);
        alphabetRecycleView.setLayoutManager(new GridLayoutManager(this, 5));
        alphabetAdapter = new AlphabetAdapter(this, list);
        alphabetRecycleView.setAdapter(alphabetAdapter);

        clickItem();
    }

    private void clickItem() {
        ItemClickSupport.addTo(alphabetRecycleView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(AlphabetActivity.this);

                final View dialog = LayoutInflater.from(AlphabetActivity.this).inflate(R.layout.alphabet_dialog_detail, null);
                builder.setView(dialog);


                TextView alphabetCardviewTvHira, alphabetCardviewTvRoma, alphabetCardviewTvKata, alphabetCardviewTvOk;
                ImageView alphabetCardviewImgPronun;

                alphabetCardviewTvHira = (TextView) dialog.findViewById(R.id.alphabet_cardview_tv_hira);
                alphabetCardviewTvRoma = (TextView) dialog.findViewById(R.id.alphabet_cardview_tv_roma);
                alphabetCardviewTvKata = (TextView) dialog.findViewById(R.id.alphabet_cardview_tv_kata);
                alphabetCardviewImgPronun = (ImageView) dialog.findViewById(R.id.alphabet_cardview_img_pronun);
                alphabetCardviewTvOk = (TextView) dialog.findViewById(R.id.alphabet_cardview_tv_ok);

                final Alphabet a = list.get(position);

                alphabetCardviewTvHira.setText(a.hiragana);
                alphabetCardviewTvRoma.setText(a.romari);
                alphabetCardviewTvKata.setText(a.katakana);

                alphabetCardviewTvOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
                alphabetCardviewImgPronun.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        playSound(a.sound);
                    }
                });

                alertDialog = builder.create();
//                alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog = builder.show();
            }
        });
    }

    public void playSound(String sound){
        AssetFileDescriptor afd = null;
        try {
            afd = getAssets().openFd("alphabet/"+sound+".mp3");

            mediaPlayer = new MediaPlayer();

            mediaPlayer.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
            mediaPlayer.prepare();
            mediaPlayer.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) mediaPlayer.release();
    }

    public void innitData() {

        try {
            MainActivity.db.alphabetDAO().delAll();
            //a
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(1, "あ", "ア", "a", "a"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(2, "い", "イ", "i", "i"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(3, "う", "ウ", "u", "u"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(4, "え", "エ", "e", "e"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(5, "お", "オ", "o", "o"));
            //ka
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(6, "か", "カ", "ka", "ka"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(7, "き", "キ", "ki", "ki"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(8, "く", "ク", "ku", "ku"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(9, "け", "ケ", "ke", "ke"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(10, "こ", "コ", "ko", "ko"));
            //sa
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(11, "さ", "サ", "sa", "sa"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(12, "し", "シ", "shi", "si"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(13, "す", "ス", "su", "su"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(14, "せ", "セ", "se", "se"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(15, "そ", "ソ", "so", "so"));
            //ta
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(16, "た", "タ", "ta", "ta"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(17, "ち", "チ", "chi", "chi"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(18, "つ", "ツ", "tsu", "tsu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(19, "て", "テ", "te", "te"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(20, "と", "ト", "to", "to"));
            //na
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(21, "な", "ナ", "na", "na"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(22, "に", "ニ", "ni", "ni"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(23, "ぬ", "ヌ", "nu", "nu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(24, "ね", "ネ", "ne", "ne"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(25, "の", "ノ", "no", "no"));
            //ha
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(26, "は", "ハ", "ha", "ha"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(27, "ひ", "ヒ", "hi", "hi"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(28, "ふ", "フ", "fu", "hu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(29, "へ", "ヘ", "he", "he"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(30, "ほ", "ホ", "ho", "ho"));
            //ma
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(31, "ま", "マ", "ma", "ma"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(32, "み", "ミ", "mi", "mi"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(33, "む", "ム", "mu", "mu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(34, "め", "メ", "me", "me"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(35, "も", "モ", "mo", "mo"));
            //ya
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(36, "や", "ヤ", "ya", "ya"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(37, "", "", "", ""));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(38, "ゆ", "ユ", "yu", "yu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(39, "", "", "", ""));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(40, "よ", "ヨ", "yo", "yo"));
            //ra
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(41, "ら", "ラ", "ra", "ra"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(42, "り", "リ", "ri", "ri"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(43, "る", "ル", "ru", "ru"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(44, "れ", "レ", "re", "re"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(45, "ろ", "ロ", "ro", "ro"));
            //wa
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(46, "わ", "ワ", "wa", "wa"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(47, "", "", "", ""));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(48, "を", "ヲ", "wo", "wo"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(49, "", "", "", ""));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(50, "ん", "ン", "n", "n"));
            //ga
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(51, "が", "ガ", "ga", "ga"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(52, "ぎ", "ギ", "gi", "gi"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(53, "ぐ", "グ", "gu", "gu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(54, "げ", "ゲ", "ge", "ge"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(55, "ご", "ゴ", "go", "go"));
            //za
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(56, "ざ", "ザ", "za", "za"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(57, "じ", "ジ", "ji", "ji"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(58, "ず", "ズ", "zu", "zu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(59, "ぜ", "ゼ", "ze", "ze"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(60, "ぞ", "ゾ", "zo", "zo"));
            //da
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(61, "だ", "ダ", "da", "da"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(62, "ぢ", "ヂ", "ji", "ji"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(63, "づ", "ヅ", "ju", "ju"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(64, "で", "デ", "de", "de"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(65, "ど", "ド", "do", "do"));
            //ba
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(66, "ば", "バ", "ba", "ba"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(67, "び", "ビ", "bi", "bi"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(68, "ぶ", "ブ", "bu", "bu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(69, "べ", "ベ", "be", "be"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(70, "ぼ", "ボ", "bo", "bo"));
            //pa
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(71, "ぱ", "パ", "pa", "pa"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(72, "ぴ", "ピ", "pi", "pi"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(73, "ぷ", "プ", "pu", "pu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(74, "ぺ", "ペ", "pe", "pe"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(75, "ぽ", "ポ", "po", "po"));

        } catch (SQLiteConstraintException x) {
            x.printStackTrace();
        }

    }
}
