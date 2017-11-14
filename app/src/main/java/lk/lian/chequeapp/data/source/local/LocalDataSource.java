package lk.lian.chequeapp.data.source.local;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import lk.lian.chequeapp.cheques.ChequeType;
import lk.lian.chequeapp.cheques.model.Cheque;
import lk.lian.chequeapp.data.source.ChequeDataSource;

import static android.support.v4.util.Preconditions.checkNotNull;
import static lk.lian.chequeapp.data.source.local.LocalPersistence.ChequeEntity;

/**
 * Created by Chathura Wijesinghe <cdanasiri@gmail.com> on 11/9/17.
 */

public class LocalDataSource implements ChequeDataSource {

  private static LocalDataSource INSTANCE;
  private DBHelper mDbHelper;

  @SuppressLint("RestrictedApi")
  private LocalDataSource(@NonNull Context context) {
    checkNotNull(context);
    mDbHelper = new DBHelper(context);
  }

  public static LocalDataSource getInstance(@NonNull Context context) {
    if (INSTANCE == null) INSTANCE = new LocalDataSource(context);
    return INSTANCE;
  }

  @Override public void getCheque(@NonNull int number, @NonNull LoadChequeCallback chequeCallback) {

  }

  @Override public void getCheques(@NonNull LoadChequesCallback chequesCallback) {
    List<Cheque> cheques = new ArrayList<>();
    SQLiteDatabase db = mDbHelper.getReadableDatabase();

    Cursor c =
        db.query(ChequeEntity.TABLE_NAME, ChequeEntity.PROJECTION, null, null, null, null, null);
    if (c != null && c.getCount() > 0) {
      while (c.moveToNext()) {
        int chequeNo = c.getInt(c.getColumnIndexOrThrow(ChequeEntity.COLUMN_CHEQUE_NUMBER));
        int bankCode = c.getInt(c.getColumnIndexOrThrow(ChequeEntity.COLUMN_CHEQUE_BANKCODE));
        int branchCode = c.getInt(c.getColumnIndexOrThrow(ChequeEntity.COLUMN_CHEQUE_BRANCHCODE));
        double amount = c.getDouble(c.getColumnIndexOrThrow(ChequeEntity.COLUMN_CHEQUE_AMOUNT));
        long date = c.getLong(c.getColumnIndexOrThrow(ChequeEntity.COLUMN_CHEQUE_DATE));

        // TODO date and payee must implemented
        Cheque cq = new Cheque(chequeNo,bankCode,branchCode,amount,"",date, ChequeType.UNCROSSED,"");
        cheques.add(cq);

      }
    }

    if (c != null) {
      c.close();
    }

    db.close();

    if (cheques.isEmpty()) {
      chequesCallback.onDataNotAvailable();
    } else {
      chequesCallback.onChequesLoaded(cheques);
    }
  }
}
