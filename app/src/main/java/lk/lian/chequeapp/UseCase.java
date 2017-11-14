package lk.lian.chequeapp;

/**
 * Use cases are the entry point to the domain layer.
 * @param <S> request value
 * @param <T> response value
 */
public abstract class UseCase<S extends UseCase.RequestValues, T extends UseCase.ResponseValue> {


  private S mRequestValues;

  private UseCaseCallback<T> mUseCaseCallback;
  public void setRequestValues(S requestValues) {
    mRequestValues = requestValues;
  }

  public S getRequestValues() {
    return mRequestValues;
  }

  public UseCaseCallback<T> getUseCaseCallback() {
    return mUseCaseCallback;
  }

  public void setUseCaseCallback(UseCaseCallback<T> useCaseCallback) {
    mUseCaseCallback = useCaseCallback;
  }

  void run() {
    executeUseCase(mRequestValues);
  }

  protected abstract void executeUseCase(S requestValues);

  /**
   * Data passed to a request.
   */
  public interface RequestValues {
  }

  /**
   * Data received from a request.
   */
  public interface ResponseValue {
  }

  public interface UseCaseCallback<R> {
    void onSuccess(R response);
    void onError();
  }
}
