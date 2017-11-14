package lk.lian.chequeapp.data.source.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import lk.lian.chequeapp.cheques.ChequeType;
import lk.lian.chequeapp.cheques.model.Cheque;
import lk.lian.chequeapp.data.source.ChequeDataSource;

import static lk.lian.chequeapp.data.source.local.LocalPersistence.ChequeEntity;

/**
 * Created by Chathura Wijesinghe <cdanasiri@gmail.com> on 11/9/17.
 */

public class ChequeLocalDataSource implements ChequeDataSource {

  private static ChequeLocalDataSource INSTANCE;
  private DBHelper mDbHelper;

  private ChequeLocalDataSource(@NonNull Context context) {
    mDbHelper = new DBHelper(context);
  }

  public static ChequeLocalDataSource getInstance(@NonNull Context context) {
    if (INSTANCE == null) INSTANCE = new ChequeLocalDataSource(context);
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

  @Override public void addCheques(@NonNull Cheque cheque, @NonNull AddChequeCallback callback) {
    SQLiteDatabase db = mDbHelper.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put(ChequeEntity.COLUMN_CHEQUE_NUMBER, cheque.getNumber());
    values.put(ChequeEntity.COLUMN_CHEQUE_BANKCODE, cheque.getBankCode());
    values.put(ChequeEntity.COLUMN_CHEQUE_BRANCHCODE, cheque.getBranchCode());
    values.put(ChequeEntity.COLUMN_CHEQUE_AMOUNT, cheque.getAmount());
    values.put(ChequeEntity.COLUMN_CHEQUE_DATE, cheque.getDate());

    db.insert(ChequeEntity.TABLE_NAME, null, values);

    db.close();

    callback.onChequeAdded(cheque);
  }
}
