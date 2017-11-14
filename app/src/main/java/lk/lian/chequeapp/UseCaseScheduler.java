package lk.lian.chequeapp;

/**
 * Created by Chathura Wijesinghe <cdanasiri@gmail.com> on 11/14/17.
 */

public interface UseCaseScheduler {
  void execute(Runnable runnable);

  <T extends UseCase.ResponseValue> void notifyResponse(final T response,
      final UseCase.UseCaseCallback<T> callback);

  <T extends UseCase.ResponseValue> void onError(final UseCase.UseCaseCallback<T> callback);
}
