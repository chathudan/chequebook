package lk.lian.chequeapp.data.source;

import android.support.annotation.NonNull;
import java.util.List;
import lk.lian.chequeapp.cheques.model.Cheque;

/**
 * Created by Chathura Wijesinghe <cdanasiri@gmail.com> on 11/9/17.
 */

public class CheckRepository implements ChequeDataSource {

  private static CheckRepository INSTANCE;
  private ChequeDataSource mChequeDataSource;

  private CheckRepository(@NonNull ChequeDataSource chequeDataSource){
    mChequeDataSource = chequeDataSource;
  }

  public static CheckRepository getInstance(@NonNull ChequeDataSource chequeDataSource){
    if (INSTANCE==null)
      INSTANCE = new CheckRepository(chequeDataSource);

    return INSTANCE;
  }

  @Override public void getCheque(@NonNull int number, @NonNull LoadChequeCallback chequeCallback) {

  }

  @Override public void getCheques(@NonNull final LoadChequesCallback callback) {
    mChequeDataSource.getCheques(new LoadChequesCallback() {
      @Override public void onChequesLoaded(List<Cheque> cheques) {
        callback.onChequesLoaded(cheques);
      }

      @Override public void onDataNotAvailable() {
        callback.onDataNotAvailable();
      }
    });
  }

  @Override public void addCheques(@NonNull Cheque cheque, @NonNull AddChequeCallback callback) {

  }
}
