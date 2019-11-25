package com.example.project1.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.project1.model.Grammar;
import com.example.project1.model.Kaiwa;
import com.example.project1.model.Kanji;
import com.example.project1.model.Kotoba;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static String TAG = "DataBaseHelper"; // Tag just for the LogCat window
    //destination path (location) of our database on device
    private static String DB_PATH = "";
    private static String DB_NAME = "grammar_data.db";// Database name
    private SQLiteDatabase mDataBase;
    private final Context mContext;

    // do đường dẫn ở phiên bản API > 17 thay đổi nên chúng ta cần kiểm tra nhé
    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, 2);// 1? Its database Version
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.mContext = context;
    }

    public void createDataBase() {
        //If the database does not exist, copy it from the assets.

        boolean mDataBaseExist = checkDataBase();
        if (!mDataBaseExist) {
            this.getReadableDatabase();
            this.close();
            try {
                //Copy the database from assests
                copyDataBase();
                Log.e(TAG, "createDatabase database created");
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    //Check that the database exists here: /data/data/your package/databases/Database Name
    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        Log.e("dbFile", dbFile + "   " + dbFile.exists());
        return dbFile.exists();
    }

    //Copy the database from assets
    private void copyDataBase() throws IOException {
        InputStream mInput = mContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0) {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    //Open the database, so we can query it
    public boolean openDataBase() throws SQLException {
        String mPath = DB_PATH + DB_NAME;
        //Log.v("mPath", mPath);
        mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return mDataBase != null;
    }

    @Override
    public synchronized void close() {
        if (mDataBase != null)
            mDataBase.close();
        super.close();
    }


    public List<Kotoba> getKotoba(int lesson_id) {
        List<Kotoba> kotobaList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        String SQL = "SELECT * FROM kotoba WHERE lesson_id = " + lesson_id + "";

        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {

                    Kotoba word = new Kotoba();

                    word.setKotoba_id(cursor.getInt(0));
                    word.setLesson_id(cursor.getInt(1));
                    word.setHiragana(cursor.getString(2));
                    word.setKanji(cursor.getString(3));
                    word.setRoumaji(cursor.getString(4));
                    word.setCn_mean(cursor.getString(5));
                    word.setMean(cursor.getString(6));
                    word.setSound("1000");
                    ;

                    kotobaList.add(word);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return kotobaList;
    }

    public List<Grammar> getGrammar(int lesson_id) {
        List<Grammar> grammarList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        String SQL = "SELECT * FROM grammar WHERE lesson_id = " + lesson_id + "";

        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {

                    Grammar gm = new Grammar();

                    gm.setGrammar_id(cursor.getInt(0));
                    gm.setLesson_id(cursor.getInt(1));
                    gm.setName(cursor.getString(2));
                    gm.setUname(cursor.getString(3));
                    gm.setContent(cursor.getString(4));

                    grammarList.add(gm);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return grammarList;
    }

    public List<Kaiwa> getKaiwa(int lesson_id) {
        List<Kaiwa> kaiwaList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        String SQL = "SELECT * FROM kaiwa WHERE lesson_id = " + lesson_id + "";

        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {

                    Kaiwa kw = new Kaiwa();

                    kw.setKaiwa_id(cursor.getInt(0));
                    kw.setLesson_id(cursor.getInt(1));
                    kw.setCharacter(cursor.getString(2));
                    kw.setKaiwa(cursor.getString(3));
                    kw.setMean(cursor.getString(4));

                    kaiwaList.add(kw);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return kaiwaList;
    }

    public List<Kanji> getKanji(int lesson_id) {
        List<Kanji> kanjiList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        String SQL = "SELECT * FROM ikanji WHERE lesson = " + lesson_id + "";

        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {

                    Kanji kj = new Kanji();

                    kj.setKanji_id(cursor.getInt(0));
                    kj.setLesson_id(cursor.getInt(2));
                    kj.setKanji(cursor.getString(1));
                    kj.setMean(cursor.getString(3));
                    kj.setCn_mean(cursor.getString(5));
                    kj.setOnyomi(cursor.getString(cursor.getColumnIndex("onjomi")));
                    kj.setKunyomi(cursor.getString(cursor.getColumnIndex("kunjomi")));
                    kj.setNote(cursor.getString(cursor.getColumnIndex("note")));

                    kanjiList.add(kj);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return kanjiList;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
