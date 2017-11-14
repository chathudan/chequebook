package lk.lian.chequeapp;

/**
 * Created by Chathura Wijesinghe <cdanasiri@gmail.com> on 11/9/17.
 */

public interface BaseView<T extends BasePresenter> {
  void setPresenter(T presenter);
}
