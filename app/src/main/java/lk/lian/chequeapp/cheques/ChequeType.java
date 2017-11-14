package lk.lian.chequeapp.cheques;

/**
 * Created by Chathura Wijesinghe <cdanasiri@gmail.com> on 11/9/17.
 */

public enum ChequeType {
  /**
   * When the words "or bearer" appearing on the face of the cheque are not cancel.
   */
  BEARER,

  /**
   * When the word "bearer" appearing on the face of a cheque is cancelled and when in its place the
   * word "or order" is written on the face of the cheque.
   */
  ORDER,

  /**
   * Cheque is not crossed
   */
  UNCROSSED,

  /**
   * Crossing of cheque means drawing two parallel lines on the face of the cheque with or without
   * additional words like "& CO." or "Account Payee" or "Not Negotiable".
   */
  CROSSED,

  /**
   * Cheque bears a date earlier than the date on which it is presented to the bank.
   */
  ANTIDATED,

  /**
   * Cheque bears a date which is yet to come (future date)
   */
  POSTDATED,

  /**
   * Cheque is presented for payment after three months from the date of the cheque.
   */
  STALE

}
