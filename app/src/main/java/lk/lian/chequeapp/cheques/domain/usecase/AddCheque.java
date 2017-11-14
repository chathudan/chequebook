package lk.lian.chequeapp.cheques.domain.usecase;

import android.support.annotation.NonNull;
import lk.lian.chequeapp.UseCase;
import lk.lian.chequeapp.cheques.domain.model.Cheque;
import lk.lian.chequeapp.data.source.CheckRepository;
import lk.lian.chequeapp.data.source.ChequeDataSource;


/**
 * Created by Chathura Wijesinghe <cdanasiri@gmail.com> on 11/14/17.
 */

public class AddCheque extends UseCase<AddCheque.RequestValues,AddCheque.ResponseValues> {

  private CheckRepository mCheckRepository;

  public AddCheque(@NonNull CheckRepository checkRepository){
    mCheckRepository = checkRepository;
  }

  @Override protected void executeUseCase(final RequestValues requestValues) {
    mCheckRepository.addCheque(requestValues.getCheque(), new ChequeDataSource.AddChequeCallback() {
      @Override public void onChequeAdded(Cheque cheque) {
        if (cheque!=null){
          ResponseValues respose = new ResponseValues(cheque);
          getUseCaseCallback().onSuccess(respose);
        }
      }

      @Override public void onChequeAddFailed() {
        getUseCaseCallback().onError();
      }
    });

    //getUseCaseCallback().onSuccess(new ResponseValues(cheque));
  }

  public final static class RequestValues implements UseCase.RequestValues{
    private final Cheque mCheque;

    public RequestValues(@NonNull Cheque cheque) {
      mCheque =  cheque;
    }

    public Cheque getCheque() {
      return mCheque;
    }
  }

  public final static class ResponseValues implements UseCase.ResponseValue{
    private final Cheque mCheque;

    public ResponseValues(@NonNull Cheque cheque) {
      mCheque =  cheque;
    }

    public Cheque getCheque() {
      return mCheque;
    }
  }
}
