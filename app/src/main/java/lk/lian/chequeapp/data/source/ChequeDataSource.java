package lk.lian.chequeapp.data.source;

import android.support.annotation.NonNull;
import java.util.List;
import lk.lian.chequeapp.cheques.model.Cheque;

/**
 * The main access point for accessing cheque data.
 */
public interface ChequeDataSource {

  void getCheque(@NonNull int number, @NonNull LoadChequeCallback chequeCallback);

  void getCheques(@NonNull LoadChequesCallback chequesCallback);

  interface AddChequeCallback {
    void onChequeAdded(Cheque cheque);

    //TODO return error and reason
    void onChequeAddFailed();
  }

  interface LoadChequeCallback {
    void onChequeLoaded(Cheque cheque);

    void onDataNotAvailable();
  }

  interface LoadChequesCallback {
    void onChequesLoaded(List<Cheque> cheques);

    void onDataNotAvailable();
  }
}
