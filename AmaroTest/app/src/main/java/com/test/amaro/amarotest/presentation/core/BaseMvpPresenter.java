package com.test.amaro.amarotest.presentation.core;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseMvpPresenter<V extends MvpView> {

    private CompositeDisposable disposables;
    private V view;

    public final V getView() {
        if (this.view != null) {
            return view;
        } else {
            throw new MvpViewNotAttachedException();
        }
    }

    @SuppressWarnings("UncheckedCast")
    public void attachView(V view) {
        this.view = view;
        this.disposables = new CompositeDisposable();
    }

    public void detachView() {
        this.view = null;
        if (this.disposables != null) {
            disposables.clear();
        }
    }

    public final void addDisposable(Disposable disposable) {
        if (this.disposables != null) {
            disposables.add(disposable);
        }
    }

    private static final class MvpViewNotAttachedException extends RuntimeException {

        private MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before requesting data to the Presenter");
        }
    }
}
