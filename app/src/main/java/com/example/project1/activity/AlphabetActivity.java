package com.example.project1.activity;

import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.example.project1.adapter.AlphabetAdapter;
import com.example.project1.model.Alphabet;

import java.util.ArrayList;
import java.util.List;

public class AlphabetActivity extends BaseActivity {

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

    }

    public void innitData() {

        try {
            MainActivity.db.alphabetDAO().delAll();
            //a
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(1, "あ", "ア", "a"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(2, "い", "イ", "i"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(3, "う", "ウ", "u"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(4, "え", "エ", "e"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(5, "お", "オ", "o"));
            //ka
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(6, "か", "カ", "ka"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(7, "き", "キ", "ki"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(8, "く", "ク", "ku"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(9, "け", "ケ", "ke"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(10, "こ", "コ", "ko"));
            //sa
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(11, "さ", "サ", "sa"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(12, "し", "シ", "shi"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(13, "す", "ス", "su"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(14, "せ", "セ", "se"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(15, "そ", "ソ", "so"));
            //ta
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(16, "た", "タ", "ta"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(17, "ち", "チ", "chi"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(18, "つ", "ツ", "tsu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(19, "て", "テ", "te"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(20, "と", "ト", "to"));
            //na
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(21, "な", "ナ", "na"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(22, "に", "ニ", "ni"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(23, "ぬ", "ヌ", "nu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(24, "ね", "ネ", "ne"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(25, "の", "ノ", "no"));
            //ha
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(26, "は", "ハ", "ha"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(27, "ひ", "ヒ", "hi"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(28, "ふ", "フ", "fu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(29, "へ", "ヘ", "he"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(30, "ほ", "ホ", "ho"));
            //ma
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(31, "ま", "マ", "ma"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(32, "み", "ミ", "mi"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(33, "む", "ム", "mu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(34, "め", "メ", "me"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(35, "も", "モ", "mo"));
            //ya
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(36, "や", "ヤ", "ya"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(37, "", "", ""));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(38, "ゆ", "ユ", "yu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(39, "", "", ""));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(40, "よ", "ヨ", "yo"));
            //ra
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(41, "ら", "ラ", "ra"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(42, "り", "リ", "ri"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(43, "る", "ル", "ru"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(44, "れ", "レ", "re"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(45, "ろ", "ロ", "ro"));
            //wa
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(46, "わ", "ワ", "wa"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(47, "", "", ""));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(48, "を", "ヲ", "wo"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(49, "", "", ""));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(50, "ん", "ン", "n"));
            //ga
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(51, "が", "ガ", "ga"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(52, "ぎ", "ギ", "gi"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(53, "ぐ", "グ", "gu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(54, "げ", "ゲ", "ge"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(55, "ご", "ゴ", "go"));
            //za
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(56, "ざ", "ザ", "za"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(57, "じ", "ジ", "ji"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(58, "ず", "ズ", "zu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(59, "ぜ", "ゼ", "ze"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(60, "ぞ", "ゾ", "zo"));
            //da
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(61, "だ", "ダ", "da"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(62, "ぢ", "ヂ", "ji"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(63, "づ", "ヅ", "zu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(64, "で", "デ", "de"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(65, "ど", "ド", "do"));
            //ba
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(66, "ば", "バ", "ba"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(67, "び", "ビ", "bi"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(68, "ぶ", "ブ", "bu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(69, "べ", "ベ", "be"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(70, "ぼ", "ボ", "bo"));
            //pa
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(71, "ぱ", "パ", "pa"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(72, "ぴ", "ピ", "pi"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(73, "ぷ", "プ", "pu"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(74, "ぺ", "ペ", "pe"));
            MainActivity.db.alphabetDAO().insertBCC(new Alphabet(75, "ぽ", "ポ", "po"));

        } catch (SQLiteConstraintException x) {
            x.printStackTrace();
        }

    }
}
