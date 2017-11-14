/**
 * Created by Chathura Wijesinghe <cdanasiri@gmail.com> on 11/9/17.
 */

package lk.lian.chequeapp.cheques.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import lk.lian.chequeapp.cheques.ChequeType;

/**
 * Model class for a cheque.
 */
public class Cheque {
  @NonNull private int number;

  @NonNull private int bankCode;

  @NonNull private int branchCode;

  @NonNull private double amount;

  @NonNull private String amountInWord;

  @NonNull private long date;

  @NonNull private ChequeType type;

  @Nullable private String payee;

  private boolean isReturn;

  private boolean isRealised;

  /**
   * Use this constructor to create a new cheque
   *
   * @param number cheque number
   * @param bankCode bank code of the cheque
   * @param branchCode branch code of the cheque
   * @param amount amount of the check
   * @param amountInWord amount in word of the check
   * @param date date of the cheque
   * @param type cheque type can be {@link ChequeType#BEARER},
   *                          {@link ChequeType#ORDER},
   *                          {@link ChequeType#UNCROSSED},
   *                          {@link ChequeType#CROSSED},
   *                          {@link ChequeType#ANTIDATED},
   *                          {@link ChequeType#POSTDATED} or
   *                          {@link ChequeType#STALE}
   * @param payee payee name
   */
  public Cheque(@NonNull int number, @NonNull int bankCode, @NonNull int branchCode,
      @NonNull double amount, @NonNull String amountInWord, @NonNull long date,
      @NonNull ChequeType type, String payee) {
    this.number = number;
    this.bankCode = bankCode;
    this.branchCode = branchCode;
    this.amount = amount;
    this.amountInWord = amountInWord;
    this.date = date;
    this.type = type;
    this.payee = payee;
  }

  @NonNull public int getNumber() {
    return number;
  }

  public void setNumber(@NonNull int number) {
    this.number = number;
  }

  @NonNull public int getBankCode() {
    return bankCode;
  }

  public void setBankCode(@NonNull int bankCode) {
    this.bankCode = bankCode;
  }

  @NonNull public int getBranchCode() {
    return branchCode;
  }

  public void setBranchCode(@NonNull int branchCode) {
    this.branchCode = branchCode;
  }

  @NonNull public double getAmount() {
    return amount;
  }

  public void setAmount(@NonNull double amount) {
    this.amount = amount;
  }

  @NonNull public String getAmountInWord() {
    return amountInWord;
  }

  public void setAmountInWord(@NonNull String amountInWord) {
    this.amountInWord = amountInWord;
  }

  @NonNull public long getDate() {
    return date;
  }

  public void setDate(@NonNull long date) {
    this.date = date;
  }

  @NonNull public ChequeType getType() {
    return type;
  }

  public void setType(@NonNull ChequeType type) {
    this.type = type;
  }

  @Nullable public String getPayee() {
    return payee;
  }

  public void setPayee(@Nullable String payee) {
    this.payee = payee;
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

    if (number != cheque.number) return false;
    if (bankCode != cheque.bankCode) return false;
    return branchCode == cheque.branchCode;
  }

  @Override public String toString() {
    return "Cheque{"
        + "number="
        + number
        + ", bankCode="
        + bankCode
        + ", branchCode="
        + branchCode
        + ", amount="
        + amount
        + ", amountInWord='"
        + amountInWord
        + '\''
        + ", date="
        + date
        + ", type="
        + type
        + ", payee='"
        + payee
        + '\''
        + ", isReturn="
        + isReturn
        + ", isRealised="
        + isRealised
        + '}';
  }
}
