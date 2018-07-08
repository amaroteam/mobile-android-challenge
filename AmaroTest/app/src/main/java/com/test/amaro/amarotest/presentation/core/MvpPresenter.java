package com.test.amaro.amarotest.presentation.core;

interface MvpPresenter {
    void attachView(MvpView view);
    void detachView();
}