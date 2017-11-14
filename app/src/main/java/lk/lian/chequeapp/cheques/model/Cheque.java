/**
 * Created by Chathura Wijesinghe <cdanasiri@gmail.com> on 11/9/17.
 */

package lk.lian.chequeapp.cheques.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Date;
import lk.lian.chequeapp.cheques.ChequeType;

/**
 * Model class for a cheque.
 */
public class Cheque {
  @NonNull private int mNumber;

  @NonNull private int mBankCode;

  @NonNull private int mBranchCode;

  @NonNull private double mAmount;

  @NonNull private String mAmountInWord;

  @NonNull private long mDate;

  @NonNull private ChequeType mType;

  @Nullable private String mPayee;

  private boolean isReturn;

  private boolean isRealised;

  /**
   * Use this constructor to create a new cheque
   *
   * @param mNumber cheque number
   * @param mBankCode bank code of the cheque
   * @param mBranchCode branch code of the cheque
   * @param mAmount amount of the check
   * @param mAmountInWord amount in word of the check
   * @param mDate date of the cheque
   * @param mType cheque type can be {@link ChequeType#BEARER},
   *                          {@link ChequeType#ORDER},
   *                          {@link ChequeType#UNCROSSED},
   *                          {@link ChequeType#CROSSED},
   *                          {@link ChequeType#ANTIDATED},
   *                          {@link ChequeType#POSTDATED} or
   *                          {@link ChequeType#STALE}
   * @param mPayee payee name
   */
  public Cheque(@NonNull int mNumber, @NonNull int mBankCode, @NonNull int mBranchCode,
      @NonNull double mAmount, @NonNull String mAmountInWord, @NonNull long mDate,
      @NonNull ChequeType mType, String mPayee) {
    this.mNumber = mNumber;
    this.mBankCode = mBankCode;
    this.mBranchCode = mBranchCode;
    this.mAmount = mAmount;
    this.mAmountInWord = mAmountInWord;
    this.mDate = mDate;
    this.mType = mType;
    this.mPayee = mPayee;
  }

  @NonNull public int getmNumber() {
    return mNumber;
  }

  public void setmNumber(@NonNull int mNumber) {
    this.mNumber = mNumber;
  }

  @NonNull public int getmBankCode() {
    return mBankCode;
  }

  public void setmBankCode(@NonNull int mBankCode) {
    this.mBankCode = mBankCode;
  }

  @NonNull public int getmBranchCode() {
    return mBranchCode;
  }

  public void setmBranchCode(@NonNull int mBranchCode) {
    this.mBranchCode = mBranchCode;
  }

  @NonNull public double getmAmount() {
    return mAmount;
  }

  public void setmAmount(@NonNull double mAmount) {
    this.mAmount = mAmount;
  }

  @NonNull public String getmAmountInWord() {
    return mAmountInWord;
  }

  public void setmAmountInWord(@NonNull String mAmountInWord) {
    this.mAmountInWord = mAmountInWord;
  }

  @NonNull public long getmDate() {
    return mDate;
  }

  public void setmDate(@NonNull long mDate) {
    this.mDate = mDate;
  }

  @NonNull public ChequeType getmType() {
    return mType;
  }

  public void setmType(@NonNull ChequeType mType) {
    this.mType = mType;
  }

  @Nullable public String getmPayee() {
    return mPayee;
  }

  public void setmPayee(@Nullable String mPayee) {
    this.mPayee = mPayee;
  }

  public boolean isReturn() {
    return isReturn;
  }

  public void setReturn(boolean aReturn) {
    isReturn = aReturn;
  }

  public boolean isRealised() {
    return isRealised;
  }

  public void setRealised(boolean realised) {
    isRealised = realised;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Cheque cheque = (Cheque) o;

    if (mNumber != cheque.mNumber) return false;
    if (mBankCode != cheque.mBankCode) return false;
    return mBranchCode == cheque.mBranchCode;
  }

  @Override public String toString() {
    return "Cheque{"
        + "mNumber="
        + mNumber
        + ", mBankCode="
        + mBankCode
        + ", mBranchCode="
        + mBranchCode
        + ", mAmount="
        + mAmount
        + ", mAmountInWord='"
        + mAmountInWord
        + '\''
        + ", mDate="
        + mDate
        + ", mType="
        + mType
        + ", mPayee='"
        + mPayee
        + '\''
        + ", isReturn="
        + isReturn
        + ", isRealised="
        + isRealised
        + '}';
  }
}
