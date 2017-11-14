package lk.lian.chequeapp.data.source.local;

import android.provider.BaseColumns;

/**
 * Created by Chathura Wijesinghe <cdanasiri@gmail.com> on 11/9/17.
 */

public final class LocalPersistence {

  private static final String TEXT = " TEXT";
  private static final String NUMBER = " NUMBER";
  private static final String COMMA = ", ";

  private LocalPersistence(){}

  /*
  * Cheque table content
  * */
  public static abstract class ChequeEntity implements BaseColumns {
    private ChequeEntity(){}

    public static final String TABLE_NAME = "cheque";
    public static final String COLUMN_CHEQUE_NUMBER = "cheque_number";
    public static final String COLUMN_CHEQUE_BANKCODE = "bank_code";
    public static final String COLUMN_CHEQUE_BRANCHCODE = "branch_code";
    public static final String COLUMN_CHEQUE_AMOUNT = "amount";
    public static final String COLUMN_CHEQUE_DATE = "date";

    public static final String SQL_CREATE = "CREATE TABLE "
        +TABLE_NAME+" ("
        + _ID +" PRIMARY KEY"+COMMA
        +COLUMN_CHEQUE_NUMBER+NUMBER+COMMA
        +COLUMN_CHEQUE_BANKCODE+NUMBER+COMMA
        +COLUMN_CHEQUE_BRANCHCODE+NUMBER+COMMA
        +COLUMN_CHEQUE_AMOUNT+NUMBER+COMMA
        +COLUMN_CHEQUE_DATE+NUMBER+COMMA
        +" )";

    public static final String PROJECTION [] = {
        ChequeEntity.COLUMN_CHEQUE_NUMBER,
        ChequeEntity.COLUMN_CHEQUE_BANKCODE,
        ChequeEntity.COLUMN_CHEQUE_BRANCHCODE,
        ChequeEntity.COLUMN_CHEQUE_AMOUNT,
        ChequeEntity.COLUMN_CHEQUE_DATE
    };
  }
}
