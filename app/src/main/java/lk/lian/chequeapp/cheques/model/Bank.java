package lk.lian.chequeapp.cheques.model;

import android.support.annotation.NonNull;

/**
 * Model class for Bank.
 */

public class Bank {
  @NonNull private int mBankCode;
  @NonNull private String mSwiftCode;
  @NonNull private String mBankName;

  /**
   * @param mBankCode   Bank code
   * @param mSwiftCode Bank swift code
   * @param mBankName Bank name
   */
  public Bank(@NonNull int mBankCode, @NonNull String mSwiftCode, @NonNull String mBankName) {
    this.mBankCode = mBankCode;
    this.mSwiftCode = mSwiftCode;
    this.mBankName = mBankName;
  }

  @NonNull public int getmBankCode() {
    return mBankCode;
  }

  public void setmBankCode(@NonNull int mBankCode) {
    this.mBankCode = mBankCode;
  }

  @NonNull public String getmSwiftCode() {
    return mSwiftCode;
  }

  public void setmSwiftCode(@NonNull String mSwiftCode) {
    this.mSwiftCode = mSwiftCode;
  }

  @NonNull public String getmBankName() {
    return mBankName;
  }

  public void setmBankName(@NonNull String mBankName) {
    this.mBankName = mBankName;
  }
}
