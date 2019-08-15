package com.dotplays.moneylover.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dotplays.moneylover.model.ThuChi;

public class ThuChiSqlite extends SQLiteOpenHelper {


    public static final String taoBangThuChi = "CREATE TABLE khoanThuChi " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "ten TEXT, tien FLOAT, thoiGian TEXT, " +
            "khoanThuChi TEXT,loaiThuChi TEXT)";

    public static final String TABLE_THU_CHI = "khoanThuChi";
    public static final String TC_ID = "id";
    public static final String TC_TEN = "ten";
    public static final String TC_TIEN = "tien";
    public static final String TC_TIME = "thoiGian";
    public static final String TC_KHOAN_THU_CHI = "khoanThuChi";
    public static final String TC_LOAI_THU_CHI = "loaiThuChi";

    public long insertThuChi(ThuChi thuChi) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TC_TEN, thuChi.TC_TEN);
        contentValues.put(TC_TIEN, thuChi.TC_TIEN);
        contentValues.put(TC_TIME, thuChi.TC_TIME);
        contentValues.put(TC_KHOAN_THU_CHI, thuChi.TC_KHOAN_THU_CHI);
        contentValues.put(TC_LOAI_THU_CHI, thuChi.TC_LOAI_THU_CHI);
        long result = sqLiteDatabase.insert(TABLE_THU_CHI,
                null, contentValues);
        sqLiteDatabase.close();

        return result;

    }

    public ThuChiSqlite(Context context) {
        super(context, "thuChi.db", null, 1);
    }

    public long deleteThuChi(int id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long result = sqLiteDatabase.delete(TABLE_THU_CHI, TC_ID + "=?",
                new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
        return result;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(taoBangThuChi);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
