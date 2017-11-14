package lk.lian.chequeapp.data.source;

import android.support.annotation.NonNull;
import java.util.List;
import lk.lian.chequeapp.cheques.domain.model.Cheque;

/**
 * The main access point for accessing cheque data.
 */
public interface ChequeDataSource {

  void getCheque(@NonNull int number, @NonNull LoadChequeCallback callback);

  void getCheques(@NonNull LoadChequesCallback callback);

  void addCheque(@NonNull Cheque cheque, @NonNull AddChequeCallback callback);

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
