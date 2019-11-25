package com.example.project1.activity;

import android.content.res.AssetFileDescriptor;
import android.database.sqlite.SQLiteConstraintException;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Build;
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
import java.util.List;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

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

                final View dialog = LayoutInflater.from(AlphabetActivity.this).inflate(R.layout.dialog_alphabet_detail, null);
                builder.setView(dialog);


                TextView alphabetCardviewTvRoma, alphabetCardviewTvOk;
                ImageView alphabetCardviewImgPronun;
                GifImageView alphabetCardviewTvHira1, alphabetCardviewTvKata1;

                alphabetCardviewTvHira1 = (GifImageView) dialog.findViewById(R.id.alphabet_cardview_tv_hira1);
                alphabetCardviewTvKata1 = (GifImageView) dialog.findViewById(R.id.alphabet_cardview_tv_kata1);

                alphabetCardviewTvRoma = (TextView) dialog.findViewById(R.id.alphabet_cardview_tv_roma);
                alphabetCardviewImgPronun = (ImageView) dialog.findViewById(R.id.alphabet_cardview_img_pronun);
                alphabetCardviewTvOk = (TextView) dialog.findViewById(R.id.alphabet_cardview_tv_ok);

                final Alphabet a = list.get(position);

                playSound(a.sound);

                getGifImage(a.gif_hiragana, alphabetCardviewTvHira1);
                getGifImage(a.gif_katakana, alphabetCardviewTvKata1);

                alphabetCardviewTvRoma.setText(a.romari);

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

    public void getGifImage(String name, GifImageView imageView){
        try {
            AssetFileDescriptor afd = getAssets().openFd( "alphabet_gif/" + name + ".gif");

            final GifDrawable drawable = new GifDrawable(afd);

            drawable.start();
            drawable.setLoopCount(1);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                imageView.setImageDrawable(drawable);
            }
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public void playSound(String sound) {
        try {
            AssetFileDescriptor afd = getAssets().openFd("alphabet_sound/" + sound + ".mp3");

            mediaPlayer = new MediaPlayer();

            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
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
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(1, "あ", "ア", "a", "a", "hiragana_a", "katakana_a"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(2, "い", "イ", "i", "i", "hiragana_i", "katakana_i"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(3, "う", "ウ", "u", "u", "hiragana_u", "katakana_u"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(4, "え", "エ", "e", "e", "hiragana_e", "katakana_e"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(5, "お", "オ", "o", "o", "hiragana_o", "katakana_o"));
            //ka
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(6, "か", "カ", "ka", "ka", "hiragana_ka", "katakana_ka"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(7, "き", "キ", "ki", "ki", "hiragana_ki", "katakana_ki"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(8, "く", "ク", "ku", "ku", "hiragana_ku", "katakana_ku"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(9, "け", "ケ", "ke", "ke", "hiragana_ke", "katakana_ke"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(10, "こ", "コ", "ko", "ko", "hiragana_ko", "katakana_ko"));
            //sa
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(11, "さ", "サ", "sa", "sa", "hiragana_sa", "katakana_sa"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(12, "し", "シ", "shi", "si", "hiragana_shi", "katakana_shi"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(13, "す", "ス", "su", "su", "hiragana_su", "katakana_su"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(14, "せ", "セ", "se", "se", "hiragana_se", "katakana_se"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(15, "そ", "ソ", "so", "so", "hiragana_so", "katakana_so"));
            //ta
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(16, "た", "タ", "ta", "ta", "hiragana_ta", "katakana_ta"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(17, "ち", "チ", "chi", "chi", "hiragana_chi", "katakana_chi"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(18, "つ", "ツ", "tsu", "tsu", "hiragana_tsu", "katakana_tsu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(19, "て", "テ", "te", "te", "hiragana_te", "katakana_te"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(20, "と", "ト", "to", "to", "hiragana_to", "katakana_to"));
            //na
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(21, "な", "ナ", "na", "na", "hiragana_na", "katakana_na"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(22, "に", "ニ", "ni", "ni", "hiragana_ni", "katakana_ni"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(23, "ぬ", "ヌ", "nu", "nu", "hiragana_nu", "katakana_nu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(24, "ね", "ネ", "ne", "ne", "hiragana_ne", "katakana_ne"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(25, "の", "ノ", "no", "no", "hiragana_no", "katakana_no"));
            //ha
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(26, "は", "ハ", "ha", "ha", "hiragana_ha", "katakana_ha"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(27, "ひ", "ヒ", "hi", "hi", "hiragana_hi", "katakana_hi"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(28, "ふ", "フ", "fu", "hu", "hiragana_fu", "katakana_fu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(29, "へ", "ヘ", "he", "he", "hiragana_he", "katakana_he"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(30, "ほ", "ホ", "ho", "ho", "hiragana_ho", "katakana_ho"));
            //ma
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(31, "ま", "マ", "ma", "ma", "hiragana_ma", "katakana_ma"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(32, "み", "ミ", "mi", "mi", "hiragana_mi", "katakana_mi"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(33, "む", "ム", "mu", "mu", "hiragana_mu", "katakana_mu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(34, "め", "メ", "me", "me", "hiragana_me", "katakana_me"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(35, "も", "モ", "mo", "mo", "hiragana_mo", "katakana_mo"));
            //ya
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(36, "や", "ヤ", "ya", "ya", "hiragana_ya", "katakana_ya"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(37, "", "", "", "", "", ""));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(38, "ゆ", "ユ", "yu", "yu", "hiragana_yu", "katakana_yu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(39, "", "", "", "", "", ""));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(40, "よ", "ヨ", "yo", "yo", "hiragana_yo", "katakana_yo"));
            //ra
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(41, "ら", "ラ", "ra", "ra", "hiragana_ra", "katakana_ra"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(42, "り", "リ", "ri", "ri", "hiragana_ri", "katakana_ri"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(43, "る", "ル", "ru", "ru", "hiragana_ru", "katakana_ru"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(44, "れ", "レ", "re", "re", "hiragana_re", "katakana_re"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(45, "ろ", "ロ", "ro", "ro", "hiragana_ro", "katakana_ro"));
            //wa
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(46, "わ", "ワ", "wa", "wa", "hiragana_wa", "katakana_wa"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(47, "", "", "", "", "", ""));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(48, "を", "ヲ", "wo", "wo", "hiragana_wo", "katakana_wo"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(49, "", "", "", "", "", ""));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(50, "ん", "ン", "n", "n", "hiragana_n", "katakana_n"));
            //ga
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(51, "が", "ガ", "ga", "ga", "hiragana_ga", "katakana_ga"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(52, "ぎ", "ギ", "gi", "gi", "hiragana_gi", "katakana_gi"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(53, "ぐ", "グ", "gu", "gu", "hiragana_gu", "katakana_gu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(54, "げ", "ゲ", "ge", "ge", "hiragana_ge", "katakana_ge"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(55, "ご", "ゴ", "go", "go", "hiragana_go", "katakana_go"));
            //za
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(56, "ざ", "ザ", "za", "za", "hiragana_za", "katakana_za"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(57, "じ", "ジ", "ji", "ji", "hiragana_ji", "katakana_ji"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(58, "ず", "ズ", "zu", "zu", "hiragana_zu", "katakana_zu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(59, "ぜ", "ゼ", "ze", "ze", "hiragana_ze", "katakana_ze"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(60, "ぞ", "ゾ", "zo", "zo", "hiragana_zo", "katakana_zo"));
            //da
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(61, "だ", "ダ", "da", "da", "hiragana_da", "katakana_da"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(62, "ぢ", "ヂ", "ji", "ji", "hiragana_di", "katakana_di"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(63, "づ", "ヅ", "ju", "ju", "hiragana_du", "katakana_du"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(64, "で", "デ", "de", "de", "hiragana_de", "katakana_de"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(65, "ど", "ド", "do", "do", "hiragana_do", "katakana_do"));
            //ba
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(66, "ば", "バ", "ba", "ba", "hiragana_ba", "katakana_ba"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(67, "び", "ビ", "bi", "bi", "hiragana_bi", "katakana_bi"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(68, "ぶ", "ブ", "bu", "bu", "hiragana_bu", "katakana_bu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(69, "べ", "ベ", "be", "be", "hiragana_be", "katakana_be"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(70, "ぼ", "ボ", "bo", "bo", "hiragana_bo", "katakana_bo"));
            //pa
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(71, "ぱ", "パ", "pa", "pa", "hiragana_pa", "katakana_pa"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(72, "ぴ", "ピ", "pi", "pi", "hiragana_pi", "katakana_pi"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(73, "ぷ", "プ", "pu", "pu", "hiragana_pu", "katakana_pu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(74, "ぺ", "ペ", "pe", "pe", "hiragana_pe", "katakana_pe"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(75, "ぽ", "ポ", "po", "po", "hiragana_po", "katakana_po"));

        } catch (SQLiteConstraintException x) {
            x.printStackTrace();
        }

    }
}
