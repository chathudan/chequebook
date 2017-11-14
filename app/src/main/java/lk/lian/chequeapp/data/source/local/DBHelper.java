package lk.lian.chequeapp.data.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Chathura Wijesinghe <cdanasiri@gmail.com> on 11/9/17.
 */

public class DBHelper extends SQLiteOpenHelper {

  public static final int DATABASE_VERSION = 1;

  public static final String DATABASE_NAME = "chequeapp.db";


  public DBHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override public void onCreate(SQLiteDatabase db) {
    db.execSQL(LocalPersistence.ChequeEntity.SQL_CREATE);
  }

  @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
  // not required on first version
  }
}
