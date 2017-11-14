package lk.lian.chequeapp.cheques;

import android.support.annotation.NonNull;
import android.view.View;
import java.util.List;
import lk.lian.chequeapp.BasePresenter;
import lk.lian.chequeapp.BaseView;
import lk.lian.chequeapp.cheques.model.Cheque;

/**
 * Created by Chathura Wijesinghe <cdanasiri@gmail.com> on 11/9/17.
 */

public interface ChequeContract {

  interface View extends BaseView<Presenter>{
    void showCheques(List<Cheque> cheques);
  }

  interface Presenter extends BasePresenter {

    void addNewCheque();
    void deleteCheque(@NonNull Cheque cheque);
    void updateCheque(@NonNull Cheque cheque);

  }
}
